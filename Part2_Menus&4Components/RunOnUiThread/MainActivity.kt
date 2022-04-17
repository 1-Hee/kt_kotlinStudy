package co.kr.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import co.kr.runonuithread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var isRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val now = System.currentTimeMillis()
            b.textView.text = "버튼클릭 : $now"
        }

        isRun = true
        thread {
            while(isRun){
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread : $now2")

//                runOnUiThread(object : Thread(){
//                    override fun run() {
//                        super.run()
//                        b.textView2.text = "RunOnUIThread: $now2"
//
//                    }
//                })

                runOnUiThread {
                    b.textView2.text = "runOnUI : $now2"
                }

                SystemClock.sleep(500)

//                runOnUiThread(object : Thread(){
//                    override fun run() {
//                        super.run()
//                        b.textView2.text = "또 다른 작업"
//                    }
//                })

                runOnUiThread {
                    b.textView2.text = "another Jobs"
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRun = false
    }

}