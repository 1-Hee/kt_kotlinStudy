package co.kr.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import co.kr.snackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
//            var snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_SHORT)
            var snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_INDEFINITE)

            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.BLUE)
            snack1.animationMode = Snackbar.ANIMATION_MODE_FADE

            val callback = object:BaseTransientBottomBar.BaseCallback<Snackbar>(){
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    b.textView2.text  ="SnackBar가 나타남"
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    b.textView2.text ="SnackBar가 사라짐"
                }
            }
            snack1.addCallback(callback)

            snack1.setAction("Action1"){
                b.textView.text = "ActionClick"
            }

            snack1.show()
        }

        b.button2.setOnClickListener {
            //스낵바 생성
            val snack2 = Snackbar.make(it, "Custom SnackBar",  Snackbar.LENGTH_SHORT)

            //스낵바를 통해 보여줄 뷰 생성
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar, null)

            snackView.run{
                snackView.findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.img_android)
                snackView.findViewById<TextView>(R.id.textView3).text = "새로 추가된 View"
                snackView.findViewById<TextView>(R.id.textView3).setTextColor(Color.WHITE)
            }

            //스낵바 레이아웃을 추출해서 새로운 뷰를 추가
            val snackBarLayout = snack2.view as Snackbar.SnackbarLayout
            snackBarLayout.addView(snackView)

            // 스낵바에 있는 TextView(커스텀한거 말고 기본적으로 나오는 텍스트뷰)를 추출하여 이를 보이지 않게 처리
            val snackText = snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE

            snack2.show()
        }

    }
}