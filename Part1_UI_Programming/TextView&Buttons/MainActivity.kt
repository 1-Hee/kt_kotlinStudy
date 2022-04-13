package co.kr.sf.jo.kt_textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.setBackgroundColor(Color.argb(10, 100, 100, 100))

        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = "jos phone"
        text2.text =  "ohohoho"

        text1.setBackgroundColor(Color.CYAN);
        text1.setBackgroundColor(Color.rgb(100, 200 , 255))
        text1.setBackgroundColor(Color.argb(100, 100, 100, 100))
        text1.setTextColor(Color.WHITE)

        text1.append("add text")
        ///////////////////////////////////////////////////////////////////////
        btn1.setOnClickListener(ls1);
        imgbtn1.setOnClickListener(ls2)
        btn1.setOnClickListener(ls3);
        imgbtn1.setOnClickListener(ls3)
        btn3.setOnClickListener {
            text2.text = "세번째 버튼을 누름 (고차함수로 구현)"
        }

    }
    val ls1 = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            text1.text = "첫 버튼을 누름"
        }
    }

    val ls2 = object : View.OnClickListener{
        override fun onClick(p0: View?) {
            text1.text = "이미지 버튼 누름"
        }
    }

    val ls3 = object : View.OnClickListener{
        override fun onClick(p0: View?) {
            when(p0?.id){
                R.id.btn1 -> text2.text ="1번 버튼으로 누름(ls3)"
                R.id.imgbtn1 -> text2.text = "2번 버튼으로 누름(ls3)"
            }

        }
    }



}