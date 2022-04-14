package co.kr.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            textView.text = "현재값 : ${progressBar5.progress}"
        }

        button2.setOnClickListener {
            progressBar5.progress = 140
        }

        button3.setOnClickListener {
            progressBar5.incrementProgressBy(10)
        }

        button4.setOnClickListener {
            progressBar5.incrementProgressBy(-10)
        }
    }
}