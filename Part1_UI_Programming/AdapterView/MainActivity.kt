package co.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("st1", "st2", "st3", "st4", "st5",
        "st6", "st7", "st8", "st9", "st10",
        "st11", "st12", "st13", "st14", "st15",
        "st16", "st17", "st18", "st19", "st20",
        "st21", "st22", "st23", "st24", "st25")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 첫번째 : context
        // 두번째 : 항목 하나를 구성하기 위한 layout
        //
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        list1.adapter = adapter1

        list1.setOnItemClickListener(ls1)

    }

    val ls1 = object : AdapterView.OnItemClickListener{
        // 첫번째 매개변수 : 이벤트가 발생한 항목을 가지고 있는 EventView
        // 두번째 매개변수 : 이벤트가 발생한 항목 View
        // 세번째 매개변수 : 이벤트가 발생한 항목의 index
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p0?.id){
                R.id.list1 -> {
                    textView.text ="data[pos] : ${data1[p2]} 를 클릭했습니다"
                }

            }


        }
    }

}