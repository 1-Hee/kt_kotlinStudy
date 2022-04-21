package co.kr.actionbarnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.actionbarnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val secondintent = Intent(this, SecondActivity::class.java)
            startActivity(secondintent)
        }


    }
}