package co.kr.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.localization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val str2 = getString(R.string.str)
        r.textView2.text = str2


    }
}