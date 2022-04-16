package co.kr.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityobject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val b by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(b.root)

        val obj1 = intent.getParcelableExtra<TestClass>("obj1")

        b.textView2.text = "obj1.data1 ${obj1?.data1}\n"
        b.textView2.append("obj1.data2 ${obj1?.data2}")

        b.button2.setOnClickListener {

            val t2 = TestClass()
            t2.data1 = 200
            t2.data2 = "문자열2"
            val res_int = Intent()
            res_int.putExtra("obj2", t2)
            setResult(RESULT_OK, res_int)


            finish()
        }
    }
}