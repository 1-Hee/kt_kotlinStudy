package co.kr.handlerscreen

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import co.kr.handlerscreen.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var isrunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val now = System.currentTimeMillis()
            b.textView2.text = "버튼 클릭 : $now "


        }

//        SystemClock.sleep(5000)
//        b.textView3.text = "안녕하세요"

        // 화면 처리를 위한 핸들러
        val handler1  = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
//                val now3 = System.currentTimeMillis()
//                b.textView3.text  = "핸들러 : $now3"
                when(msg.what){
                    0 -> b.textView3.text = "Handler 0"
                    1 -> b.textView3.text = "Handler 1"
                    2 -> {
                        b.textView3.text = "Handler 2 : ${msg.arg1}, ${msg.arg2}, ${msg.obj}"
                    }
                }

            }
        }


        // 오래 걸리는 작업
        isrunning =true
        thread {
            while (isrunning){
                val now2 = System.currentTimeMillis()
                Log.d("test", "오래 걸리는 작업 $now2")
                SystemClock.sleep(1000)

                handler1.sendEmptyMessage(0)
                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isrunning = false
    }
}