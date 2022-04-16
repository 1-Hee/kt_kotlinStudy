package co.kr.startactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.startactivity.databinding.ActivityMainBinding
import co.kr.startactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val bind by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(bind.root)

        bind.button2.setOnClickListener {
            finish()
        }
    }
}