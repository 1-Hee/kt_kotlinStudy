package co.kr.httpnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.kr.httpnetwork.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)


        r.button.setOnClickListener {
            r.textView.text =" 텍스트는 눌림"
            thread {

                val site = "http://192.168.0.5:8080/basic.jsp"
                val url = URL(site)

                // 접속
                val conn = url.openConnection() as HttpURLConnection

                val isr = InputStreamReader(conn.inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val buf = StringBuffer()

                do{
                    str = br.readLine()
                    if(str != null) {
                        buf.append("$str\n")
                    }

                } while (str != null)

                runOnUiThread {
                    r.textView.text = buf.toString()
                }

            }
        }
    }
}