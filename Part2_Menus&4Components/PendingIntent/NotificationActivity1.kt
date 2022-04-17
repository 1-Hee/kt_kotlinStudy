package co.kr.pendingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import co.kr.pendingintent.databinding.ActivityMainBinding
import co.kr.pendingintent.databinding.ActivityNotification1Binding

class NotificationActivity1 : AppCompatActivity() {
    val b by lazy { ActivityNotification1Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification1)
        setContentView(b.root)

        // 액티비티를 실행했을 때 사용한 Intent를 통해 데이터를 추출
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getIntExtra("data2", 0)

        b.nottextView1.text = "data1 : $data1 \n"
        b.nottextView1.append("data2 : $data2 ")




    }
}