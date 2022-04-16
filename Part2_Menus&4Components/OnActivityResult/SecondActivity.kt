package co.kr.onactivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.onactivityresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val b by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(b.root)

        b.button2.setOnClickListener {
            finish()
        }
    }
}