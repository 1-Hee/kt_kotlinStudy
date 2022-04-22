package co.kr.xmlview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import co.kr.xmlview.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // View 객체를 생성한다
        val sub1 = layoutInflater.inflate(R.layout.layout_sub, null)
        val sub2 = layoutInflater.inflate(R.layout.layout_sub2, null)
        val sub3 = layoutInflater.inflate(R.layout.layout_sub3, r.container)
        // sub3 처럼 선언하면 removeView로 지울수 없음

        r.button.setOnClickListener {
            r.container.addView(sub1)
            r.container.addView(sub2)
        }

        r.button2.setOnClickListener {
            r.container.removeView(sub1)
            r.container.removeView(sub2)
            r.container.removeView(sub3)
        }

        val sbtn = sub1.findViewById<TextView>(R.id.sub1_btn)

        sbtn.setOnClickListener {
                        sub1.run{
                val text = sub1.findViewById<TextView>(R.id.sub1_text)
                text.text = "sub1의 버튼을 눌렀습니다."
                r.textView.text = "sub1의 버튼을 눌렀습니다."
            }
        }
    }
}