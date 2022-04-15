package co.kr.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    var imgRes = intArrayOf(
        R.drawable.imgflag1,
        R.drawable.imgflag2,
        R.drawable.imgflag3,
        R.drawable.imgflag4,
        R.drawable.imgflag5,
        R.drawable.imgflag6,
        R.drawable.imgflag7,
        R.drawable.imgflag8,
        )

    var data1 = arrayOf(
        "토고", "프랑스 문자열을 길게 작성해주세요", "스위스", "스페인", "일본 문자열을 길게 작성해 주세요", "독일", "브라질", "대한민국"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = RecyclerAdapter()
        recycler1.adapter = adapter1

        // listView처럼 하기
        //recycler1.layoutManager = LinearLayoutManager(this)

        // 두줄로 리스트 표현하는 경우(그리드)
        //recycler1.layoutManager = GridLayoutManager(this, 2)

        // 가로 스크롤이 가능한 경우
        recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        // 단순 그리드로 표현하면, 고정된 이미지 영역에 요소가 들어가 잘리는 등의 문제가 있지만,
        // 이방법으로 구현하면 이미지의 요소의 크기에 따라 그리드 영역이 가변적으로 변함

    }

    // RecyclerView의 Adapter Class
    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {

        // 항목 구성을 위해 사용할 ViewHolder 객체가 필요할때 호출되는 메서드
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //항목으로 사용할 View 객체를 생성
            val itemView = layoutInflater.inflate(R.layout.row, null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)
            return holder
        }

        // ViewHolder를 통해 항목을 구성할 때 항목 내의 View 객체에 데이터를 세팅한다.
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        //View holder Class
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
            //항목 View 내부의 View 객체의 주소값을 담음
            val rowImageView = itemView.rowImageView
            val rowTextView = itemView.rowTextView
            override fun onClick(p0: View?) {
                textView.text = data1[adapterPosition]
            }
        }
    }





}