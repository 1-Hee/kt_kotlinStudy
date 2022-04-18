package co.kr.activityanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityanimation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val r by lazy { ActivitySecondBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(r.root)

        r.button2.setOnClickListener {
            finishActivity()
        }
    }

    // Back 버튼을 누르면 호출되는 메서드

    override fun onBackPressed() {
        finishActivity()
    }

    fun finishActivity(){
        finish()
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        overridePendingTransition(R.anim.slide_xml3, R.anim.slide_xml4)

    }
}