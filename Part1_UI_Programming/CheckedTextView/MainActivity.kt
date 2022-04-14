package co.kr.checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            if(chtxv1.isChecked == true){
                textView.append("첫번째 체크박스 체크 \n")
            } else {
                textView.append("첫번째 체크박스 체크해제 \n")
            }

            if(chtxv2.isChecked == true){
                textView.append("두번째 체크박스 체크 \n")
            } else {
                textView.append("두번째 체크박스 체크해제 \n")
            }

            if(chtxv3.isChecked == true){
                textView.append("세번째 체크박스 체크 \n")
            } else {
                textView.append("세번째 체크박스 체크해제 \n")
            }

            if(chtxv4.isChecked==true){
                textView.append("첫번째 라디오")
            } else if (chtxv5.isChecked == true){
                textView.append("두번째 라디오")
            } else if (chtxv6.isChecked == true){
                textView.append("세번째 라디오")
            }
        }

        button2.setOnClickListener{
            chtxv1.isChecked = true
            chtxv2.isChecked = false
            chtxv3.isChecked = true

            chtxv4.isChecked = true
            chtxv5.isChecked = false
            chtxv6.isChecked = false

        }

        chtxv1.setOnClickListener(ls1)
        chtxv2.setOnClickListener(ls1)
        chtxv3.setOnClickListener(ls1)

        chtxv4.setOnClickListener(ls2)
        chtxv5.setOnClickListener(ls2)
        chtxv6.setOnClickListener(ls2)




    }
    val ls1 = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            // 형변환
            val obj = p0 as CheckedTextView

            if(obj.isChecked == true){
                obj.isChecked = false
            } else {
                obj.isChecked =true
            }
        }

    }

    val ls2 = object  : View.OnClickListener{
        override fun onClick(p0: View?) {

            chtxv4.isChecked = false
            chtxv5.isChecked = false
            chtxv6.isChecked = false

            val obj = p0 as CheckedTextView
            obj.isChecked=true


        }

    }
}