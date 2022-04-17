package co.kr.handlerrepeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import co.kr.handlerrepeat.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val now = System.currentTimeMillis()
            b.textView.text = "버튼클릭 : $now "
        }

//        while (true){
//            SystemClock.sleep(100)
//            val now2 = System.currentTimeMillis()
//            b.textView2.text = "while 문 : $now2"
//        }

        //  처리 한번에 대한 작업을 구현
        // 5초 이상 걸리는 작업은 하면 안됌
        val handler = Handler(Looper.myLooper()!!)
        val thread1 = object : Thread() {
            override fun run(){
                super.run()
                val now2 = System.currentTimeMillis()
                b.textView2.text = "while 문 : $now2"

                handler.postDelayed(this, 100)
            }
        }
        handler.post(thread1)
//        handler.postDelayed(thread1, 1000)
    }
}