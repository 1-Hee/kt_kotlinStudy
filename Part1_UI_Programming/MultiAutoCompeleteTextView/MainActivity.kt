package co.kr.multiautocompeletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = arrayOf(
        "abcd", "bbed", "cced", "ddhrt", "eenzzd", "rrghwe"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        // 구분자
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            // 쉼표를 기준으로 문자열을 잘라 낸다.
            val strArray = multiAutoCompleteTextView.text.split(",")
            textView.text = ""
            for(str in strArray){
                if(str.trim() != ""){
                    textView.append("${str.trim()}\n")
                }
            }
        }

        multiAutoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            textView2.text = "${data[i]} 번째 항목을 선택"
       }

    }
}