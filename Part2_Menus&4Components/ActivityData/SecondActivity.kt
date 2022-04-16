package co.kr.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activitydata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val b by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(b.root)

        // 현재 액티비티를 싱행하기 위핸 인텐트로부 데이터를 추출

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data2", 0.0)
        val data3 = intent.getBooleanExtra("data3", false)
        val data4 = intent.getStringExtra("data4") // null 값이 기본값으로 반환되므로 작성 안해줘도 됌

        b.textView2.text = "data1 : $data1 \n"
        b.textView2.append("data2 : $data2 \n")
        b.textView2.append("data3 : $data3 \n")
        b.textView2.append("data4 : $data4 \n")

        b.button2.setOnClickListener {
            val resIntent = Intent()
            resIntent.putExtra("value1", 200)
            resIntent.putExtra("value2", 22.22)
            resIntent.putExtra("value3", false)
            resIntent.putExtra("value4","문자열2")

            setResult(RESULT_OK, resIntent)
            finish()
        }
    }
}