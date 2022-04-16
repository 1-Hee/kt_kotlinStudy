package co.kr.onactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.onactivityresult.databinding.ActivityMainBinding

// 안드로이드에서 다른 액티비티를 실행하다 돌아와도 onResume()이 작동하고
// 잠시 홈버튼 같은걸 눌러서 액티비티를 종료해도 onResume()이 작동해서 개발자가 원하는대로 분기가 어려울 수 있음
// 그래서 다른 액티비티에 갔다가 돌아오는 구체적인 상황에서만 작동하는 기능을 구현하려면
// startActivityForResult를 사용하면 됌

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 100
    val THIRD_ACTIVITY = 200

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)
        b.button.setOnClickListener {
            val sec_int = Intent(this, SecondActivity::class.java)
            startActivityForResult(sec_int, SECOND_ACTIVITY)
        }

        b.button4.setOnClickListener {
            val thd_int = Intent(this, ThirdActivity::class.java)
            startActivityForResult(thd_int, THIRD_ACTIVITY) //deprecated 됨
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        b.textView.text = " 다른 Acitivity에서 돌아옴"
        when(requestCode){
            SECOND_ACTIVITY -> b.textView.text = "Sec에서 Back"
            THIRD_ACTIVITY -> b.textView.text = "Thd 에서 Back"
        }

        when(resultCode){
            Activity.RESULT_OK -> b.textView.text = "결과 : OK"
            Activity.RESULT_CANCELED -> b.textView.text = "결과 : CANCEL"
            Activity.RESULT_FIRST_USER -> b.textView.text = "결과 : USER1"
            Activity.RESULT_FIRST_USER+1 -> b.textView.text = "결과 : USER2"

        }
    }
}