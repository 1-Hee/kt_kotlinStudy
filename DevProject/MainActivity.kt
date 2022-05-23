package co.kr.to_it

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.kr.to_it.databinding.ActivityMainBinding
import co.kr.to_it.databinding.MainRecyclerRowBinding

class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val subject_list = ArrayList<String>()
    val time_list = ArrayList<String>()
    val idx_list = ArrayList<Int>()

    val vis = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 나중에 splash등을 위해 위쪽에 구현할 것임.

        setContentView(b.root)

        setSupportActionBar(b.mainToolbar)
        title = "To Do List"
        
        
        // recycler를 생성하는 부분
        b.memoRecycler.adapter = MainRecyclerAdapter()
        b.memoRecycler.layoutManager = LinearLayoutManager(this)

        b.mainFb1.setOnClickListener {
            val memo_add_intent = Intent(this, MemoEditActivity::class.java)
            startActivity(memo_add_intent)
        }


    }

    override fun onResume() {
        super.onResume()
    }

    inner class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolderClass>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val mainRecyclerBinding = MainRecyclerRowBinding.inflate(layoutInflater)
            val holder = ViewHolderClass(mainRecyclerBinding)

            val layoutPrams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            mainRecyclerBinding.root.layoutParams = layoutPrams

            mainRecyclerBinding.root.setOnClickListener(holder)
            return holder

        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowMemoSubject.text = subject_list[position]
            holder.rowMemoTime.text = time_list[position]
        }

        override fun getItemCount(): Int {
            return subject_list.size
        }



        inner class ViewHolderClass(mainRecyclerBinding: MainRecyclerRowBinding) : RecyclerView.ViewHolder(mainRecyclerBinding.root), View.OnClickListener {
            // view의 주소값을 담기
            val rowMemoSubject = mainRecyclerBinding.memoSubject
            val rowMemoTime = mainRecyclerBinding.memoTime

            override fun onClick(p0: View?) {
                val rec_idx = idx_list[adapterPosition]
                val memoReaderAdater = Intent(baseContext, MemoEditActivity::class.java)
                memoReaderAdater.putExtra("rec_idx", rec_idx)
                startActivity(memoReaderAdater)
            }
        }
    }
}