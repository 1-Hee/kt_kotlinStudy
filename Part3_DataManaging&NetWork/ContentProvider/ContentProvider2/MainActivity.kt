package co.kr.contentprovider2

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.contentprovider2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            // Content Provider의 이름을 가지고 있는 uri 객체 생성
            val uri = Uri.parse("content://kr.co.dbprovider")
            // 첫번째 매개변수 : 접속할 프로바이더 uri
            // 두번째 매개변수 : 가져올 컬럼 목록 배열, null이면 모두
            // 셋째 : 조건절
            // 넷째 : 조건절 ? 에 바인딩 될 값 배열
            // 다섯번째 : 정렬 기준
            val c1 = contentResolver.query(uri, null, null, null, null)

            r.textView.text = ""
            while(c1?.moveToNext()!!){
                val idx1 = c1?.getColumnIndex("idx")
                val idx2 = c1?.getColumnIndex("textData")
                val idx3 = c1?.getColumnIndex("intData")
                val idx4 = c1?.getColumnIndex("floatData")
                val idx5 = c1?.getColumnIndex("dateData")

                val idx = c1?.getInt(idx1)
                val textData = c1?.getString(idx2)
                val intData = c1?.getInt(idx3)
                val floatData = c1?.getFloat(idx4)
                val dateData = c1?.getString(idx5)

                r.textView.append("idx : $idx \n")
                r.textView.append("textData : $textData \n")
                r.textView.append("intData : $intData \n")
                r.textView.append("floatData : $floatData \n")
                r.textView.append("dateData : $dateData \n")
            }
        }

        r.button2.setOnClickListener {
            val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val cv1 = ContentValues()
            cv1.put("textData", "문자열3")
            cv1.put("intData", 300)
            cv1.put("floatData", 33.33)
            cv1.put("dateData", now)

            val cv2 = ContentValues()
            cv2.put("textData", "문자열4")
            cv2.put("intData", 400)
            cv2.put("floatData", 44.44)
            cv2.put("dateData", now)

            val uri = Uri.parse("content://kr.co.dbprovider")

            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

            r.textView.text = "저장완료"

        }

        r.button3.setOnClickListener {
            val cv = ContentValues()
            cv.put("textData", "문자열100")
            val where = "idx = ?"
            val args = arrayOf("1")

            val uri = Uri.parse("content://kr.co.dbprovider")

            contentResolver.update(uri, cv, where, args)

            r.textView.text = "수정완료"
        }

        r.button4.setOnClickListener {
            val where = "idx = ?"
            val args = arrayOf("1")

            val uri = Uri.parse("content://kr.co.dbprovider")

            contentResolver.delete(uri, where, args)

            r.textView.text = "삭제완료"
        }
    }
}