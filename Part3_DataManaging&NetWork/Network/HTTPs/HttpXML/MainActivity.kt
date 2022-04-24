package co.kr.httpxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.httpxml.databinding.ActivityMainBinding
import org.w3c.dom.Element
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            thread {
                val site = "http://192.168.0.5:8080/xml.jsp"
                val url = URL(site)
                val conn = url.openConnection() as HttpURLConnection

                // DOM 방식으로 XML 문서를 분석할 객체를 생성
                val factory = DocumentBuilderFactory.newInstance()
                val builder = factory.newDocumentBuilder()
                val doc = builder.parse(conn.inputStream)

                // 최상위 태그를 얻어 온다.
                val root = doc.documentElement
                //item 태그들을 가져온다
                val item_list = root.getElementsByTagName("item")

                runOnUiThread{
                    r.textView.text = ""
                }

                // item 태그의 수 만큼 반복한다.
                for(i in 0 until item_list.length){
                    // i번째 아이템 태그 객체
                    val item_tag = item_list.item(i) as Element

                    // item 태그 안의 태그들을(리스트형식으로) 가져오기
                    val data1_list = item_tag.getElementsByTagName("data1")
                    val data2_list = item_tag.getElementsByTagName("data2")
                    val data3_list = item_tag.getElementsByTagName("data3")

                    // 0번째 태그를 가져옴
                    val data1_tag = data1_list.item(0) as Element
                    val data2_tag = data2_list.item(0) as Element
                    val data3_tag = data3_list.item(0) as Element

                    // 태그 내의 문자열 데이터를 가져온다.
                    val data1 = data1_tag.textContent
                    val data2 = data2_tag.textContent
                    val data3 = data3_tag.textContent

                    val v2 = data2.toInt()
                    val v3 = data3.toDouble()

                    runOnUiThread{
                        r.textView.append("data1 : $data1\n")
                        r.textView.append("data2 : $v2\n")
                        r.textView.append("data3 : $v3\n\n")
                    }
                }
            }
        }
    }
}