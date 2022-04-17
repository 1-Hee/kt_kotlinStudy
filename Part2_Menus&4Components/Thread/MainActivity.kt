package co.kr.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import co.kr.thread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class
MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val now = System.currentTimeMillis()
            b.textView.text = "버튼 클릭 : $now"
        }

//        while(true){
//            SystemClock.sleep(100)
//            val now2 = System.currentTimeMillis()
//            Log.d("test", "while문 $now2 ")
//        }

        isRunning = true

//        val Thread1 = object : Thread(){
//            override fun run() {
//                super.run()
//                while(isRunning){
//                    SystemClock.sleep(100)
//                    val now2 = System.currentTimeMillis()
//                    Log.d("test", "Thread : $now2")
//                    //b.textView2.text = "Thread : $now2"
//                }
//            }
//        }
//        Thread1.start()
//    }
        thread {
            while (isRunning){
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread $now2")
                b.textView2.text = "Times : $now2"
            }

        }


//    override fun onDestroy() {
//        super.onDestroy()
//        isRunning = false
//    }
    }
}