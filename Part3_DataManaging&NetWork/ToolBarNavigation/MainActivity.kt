package co.kr.toolbarnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.toolbarnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setSupportActionBar(r.toolbar)

        r.button.setOnClickListener {
            val secintent = Intent(this, SecondActivity::class.java)
            startActivity(secintent)
        }



    }
}