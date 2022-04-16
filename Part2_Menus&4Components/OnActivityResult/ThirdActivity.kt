package co.kr.onactivityresult

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.onactivityresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    val b by lazy { ActivityThirdBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        setContentView(b.root)

        b.button3.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        b.button5.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        b.button6.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }

        b.button7.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER+1)
            finish()
        }

    }
}