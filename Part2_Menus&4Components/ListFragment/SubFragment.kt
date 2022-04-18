package co.kr.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.ListFragment

class SubFragment :ListFragment(){

    val data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sub, null)


        // 리스트 프래그먼트는 내장으로 adapter를 가져서 아래와 같이 작성 가능
       listAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, data1)

        return view

    }

    // 기존에 리스트 뷰에서는 리스너를 작성해서 그안에 처리하고 해야했는데,
    // 리스트뷰는 아예 그 기능을 제공함
    // 리스트 뷰의 항목을 터치했을때 호출

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val view = view?.findViewById<TextView>(R.id.sub_text1)
        view?.text = data1[position]


    }

}