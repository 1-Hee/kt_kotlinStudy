package co.kr.codeviewcreate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import co.kr.codeviewcreate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val param1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val btn1 = Button(this)
        btn1.text = "추가된 버튼입니다"
        btn1.layoutParams = param1


        val img1 = ImageView(this)
        img1.layoutParams = param1
        img1.setImageResource(R.drawable.ic_launcher_background)


        btn1.setOnClickListener {
            r.textView.text = "추가버튼을 누름"
        }

        r.button.setOnClickListener {
            r.container.addView(btn1)
            r.container.addView(img1)
        }

        r.button2.setOnClickListener {
            r.container.removeView(btn1)
            r.container.removeView(img1)
        }


    }
}