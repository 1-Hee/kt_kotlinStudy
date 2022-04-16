package co.kr.activityapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TEST_ACTIVITY = 0;
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val test_intent = Intent("co.kr.ActivityApp2")

            test_intent.putExtra("data1", 100)
            test_intent.putExtra("data2", "문자열1")

            // startActivity(test_intent)
            startActivityForResult(test_intent, TEST_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TEST_ACTIVITY){
            if(resultCode== RESULT_OK) {
                val value1 = data?.getIntExtra("value1", 0)
                val value2 = data?.getStringExtra("value2")

                b.textView.text = "value1 : $value1 \n"
                b.textView.append("value2 : $value2")
            }
        }
    }
}