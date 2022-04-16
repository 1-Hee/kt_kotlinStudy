package co.kr.activityapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityapp2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val b by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(b.root)

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getStringExtra("data2")

        b.textView.text = "data1 : $data1 \n"
        b.textView.append("data2 : $data2")

        b.button.setOnClickListener {

            val res_intent = Intent()
            res_intent.putExtra("value1", 200)
            res_intent.putExtra("value2", "문자열2")
            setResult(RESULT_OK, res_intent)

            finish()
        }
    }
}