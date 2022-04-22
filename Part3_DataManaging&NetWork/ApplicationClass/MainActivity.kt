package co.kr.applicationclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.applicationclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val app = application as AppClass
            app.value1 = 100
            app.value2 = "안녕하세요"
            val secondintent = Intent(this, SecondActivity::class.java)
            startActivityForResult(secondintent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val app = application as AppClass
        r.textView.text = "value1 : ${app.value1}\n"
        r.textView.append("value2 : ${app.value2}")

    }

}