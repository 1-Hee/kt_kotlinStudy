package co.kr.activityapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)
    }
}