package co.kr.actionbarcustomizing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import co.kr.actionbarcustomizing.databinding.ActivityMainBinding
import co.kr.actionbarcustomizing.databinding.CustomActionbarBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false) // 홈버튼(백버튼) 비활성
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //layout을 통해 View를 생성
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = topBar


        val textView2 = findViewById<TextView>(R.id.textView2)
        val Button = findViewById<Button>(R.id.button)

        topBar.run {
            textView2.text = "커스텀 액션바"
            textView2.setTextColor(Color.WHITE)

            Button.setOnClickListener {
                r.textView.text = "액션바의 버튼을 누름"
            }
        }
    }
}