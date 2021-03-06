package co.kr.multichoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7" ,"항목8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data1)
        list1.adapter = adapter1
        list1.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        list1.setItemChecked(0, true)
        list1.setItemChecked(2, true)
        list1.setItemChecked(4, true)

        button.setOnClickListener {
            textView.text =""
            //현재 체크 상태에 관련된 객체 가져오기
            val boolArray = list1.checkedItemPositions
//            textView.text = "개수 : ${boolArray.size()}"

            for(idx in 0 until boolArray.size()){
                //textView.append("${boolArray.keyAt(idx)}")
                // 체크되었다가 해제되는 경우에도 기록이 남아 그것도 읽어오기 때문에 현재 체크된 것 판별에는 부적합
                // 항목의 인덱스 번호
                val key = boolArray.keyAt(idx)
                // 해당 항목이 체크되어 있는지 확인
                if(boolArray[key]==true){
                    textView.append("${data1[key]}")
                }
            }
        }


    }
}