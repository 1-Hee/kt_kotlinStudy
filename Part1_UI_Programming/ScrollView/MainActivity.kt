package co.kr.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Scroller
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Y : ${scroll1.scaleY}"
            textView2.text = "X : ${scroll2.scaleX}"
        }

        button2.setOnClickListener {
                // 단순히 지정된 위치로 이동
//            scroll1.scrollTo(0, 500)
//            scroll2.scrollTo(500, 0)
                // 지정된 위치로 애니메이션과 같이 이동
//            scroll1.smoothScrollTo(0, 500)
//            scroll2.smoothScrollTo(500, 0)

            // 현재 위치에서 설정한 값만큼 애니메이션과 이동
            scroll1.smoothScrollBy(0, 500)
            scroll2.smoothScrollBy(500, 0)
        }

        scroll1.setOnScrollChangeListener(ls1)

        scroll2.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            textView2.text = "X : $i2 -> $i"
        }
    }

    var ls1 = object : View.OnScrollChangeListener{
        override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {
            when(p0?.id){
                R.id.scroll1 -> {
                    textView.text = "Y : ${p3} -> ${p4}"
                }
            }
        }

    }
}