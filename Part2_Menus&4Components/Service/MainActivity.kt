package co.kr.service

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        val serviceIntent = Intent(this, TestService::class.java)

        b.button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }

        }

        b.button2.setOnClickListener {
            stopService(serviceIntent)
        }


    }
}