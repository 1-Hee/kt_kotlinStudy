package co.kr.applicationclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.applicationclass.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val s by lazy {ActivitySecondBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(s.root)

        val app = application as AppClass
        s.textView2.text = "value1 : ${app.value1}\n"
        s.textView2.append("value2 : ${app.value2}")

        s.button2.setOnClickListener {
            app.value1 = 200
            app.value2 = "반갑소"
            finish()

        }

    }
}