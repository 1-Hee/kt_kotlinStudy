package co.kr.broadcastreciever

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.broadcastreciever.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val br = TestReceiver()

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        // 8.0 이상부터는 코드를 통해 등록하고 해제 해야 한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val filter = IntentFilter("kr.co.testbr")
            registerReceiver(br, filter)
        }

        b.button.setOnClickListener {
//            val brIntent = Intent(this, TestReceiver::class.java)
            val brIntent = Intent("kr.co.testbr")
            sendBroadcast(brIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            unregisterReceiver(br)
        }
    }

}