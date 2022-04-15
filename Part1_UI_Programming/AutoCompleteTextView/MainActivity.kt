package co.kr.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "abcd", "abca", "abcb", "abcc", "bbaa", "defab", "bcab", "bcab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        autoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            textView.text = autoCompleteTextView.text
        }

        // autoCompleteTextView.setOnItemClickListener(ls1)

        autoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            textView2.text = "${data1[i]} 항목을 클릭함"
        }
    }

    val ls1 = object : AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            // autocomplete 를 터치하여 값을 선택했을때 when과 layout id 값으로 분기가 안되는 오류?? 가 현존
            textView2.text = "${data1[p2]} 항목을 클릭함"
        }

    }
}