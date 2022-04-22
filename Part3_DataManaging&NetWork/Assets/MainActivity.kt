package co.kr.assets

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.assets.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val inputStream = assets.open("text/data1.txt")
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)

            var str:String? = null
            val sb = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    sb.append("$str\n")
                }
            }while(str != null)
            br.close()

            r.textView.text = sb.toString()
        }

        r.button2.setOnClickListener {
            val inputStream = assets.open("text/data2.txt")
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)

            var str:String? = null
            val sb = StringBuffer()

            do{
                str = br.readLine()
                if(str != null){
                    sb.append("$str\n")
                }
            }while(str != null)
            br.close()

            r.textView.text = sb.toString()
        }

        r.button3.setOnClickListener {
            //폰트 객체 생성
            val face = Typeface.createFromAsset(assets, "font/Gugi-Regular.ttf")
            r.textView.typeface = face
        }



    }
}