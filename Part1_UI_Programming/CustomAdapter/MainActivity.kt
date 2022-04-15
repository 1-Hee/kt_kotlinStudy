package co.kr.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1.adapter = adapter1

    }
    val adapter1 = object : BaseAdapter(){

        // 항목의 값을 반환하는 함수
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        //항목 하나를 구성하기 위해 호출되는 메서드
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {

            // 재사용 가능한 뷰를 변수에 담기
            var rowView = p1
            // 해당 매개변수는 읽기 전용이므로 직접 변수에 접근할 수 없음
            // 따라서 새로운 변수에 값을 할당해주고 그 변수를 조작하는 방식으로 다뤄야함

            if(rowView == null) {
                rowView = layoutInflater.inflate(R.layout.row, null)
            }

//            // 정석인 방법
//            // 커스텀 뷰의 경우에는 onCreate 함수에서
//            // 로딩과 동시에 변수에 주솟값 할당이 자동으로 안됌
//            // 항목 뷰 내부에 배치된 뷰들의 주소값을 직접 할당해주어야함
//            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView1)
//            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
//            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)
//
//            text1?.text = data1[p0]
//            btn1?.tag = p0
//            btn2?.tag = p0
//
//            btn1?.setOnClickListener{
//                textView.text = "첫번째 버튼을 누름 ${it.tag}"
//            }
//
//            btn2?.setOnClickListener{
//                textView.text = "두번째 버튼을 누름 ${it.tag}"
//            }

            rowView?.run {
                rowTextView1.text = data1[p0]
                rowButton1.tag = p0
                rowButton2.tag = p0

                rowButton1.setOnClickListener {
                    textView.text = "첫번째 버튼 누름스 ${it.tag}"
                }

                rowButton2.setOnClickListener {
                    textView.text = "두번째 버튼 누름스 ${it.tag}"
                }
            }

            return rowView!!
        }
    }
}