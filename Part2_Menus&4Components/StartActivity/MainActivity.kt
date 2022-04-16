package co.kr.startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.startactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val bind by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(bind.root)

        bind.button.setOnClickListener {
            val sec_intent = Intent(this, SecondActivity::class.java)
            startActivity(sec_intent)
        }


    }
}