package co.kr.httpjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.kr.httpjson.databinding.ActivityMainBinding
import org.json.JSONArray
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
            Log.d("test", "버튼 눌림")
            thread {
                Log.d("test", "쓰레드 들어옴")

                val site = "http://192.168.0.5:8080/json.jsp"
                val url = URL(site)
                val conn = url.openConnection() as HttpURLConnection

                // 문자열 데이터를 읽어옴
                val isr = InputStreamReader(conn.inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val buf = StringBuffer()

                Log.d("test", "while문 전")

                do {
                    str = br.readLine()
                    if(str != null) {
                        buf.append("$str")
                    }
                } while(str != null)

                Log.d("test", "while문 후")
                val data = buf.toString()

                // JSON데이터 분석
                runOnUiThread {
                    r.textView.text = ""
                }
                Log.d("test", "초기화")

                // JSON 배열 생성
                val root = JSONArray(data)

                Log.d("test", "for문 전")


                //배열의 객체 개수만큼 반복
                for(i in 0 until root.length()){
                    // i번째 객체를 추출
                    val obj = root.getJSONObject(i)
                    // 데이터를 추출
                    val data1 = obj.getString("data1")
                    val data2 = obj.getInt("data2")
                    val data3 = obj.getDouble("data3")

                    runOnUiThread {
                        r.textView.append("data1 : $data1\n")
                        r.textView.append("data2 : $data2\n")
                        r.textView.append("data3 : $data3\n\n")
                    }
                }

                Log.d("test", "종료")

            }
        }
    }
}