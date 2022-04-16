package co.kr.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activitydata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val secint = Intent(this, SecondActivity::class.java)

            secint.putExtra("data1", 100)
            secint.putExtra("data2", 11.11)
            secint.putExtra("data3", true)
            secint.putExtra("data4", "문자열1")

//            startActivity(secint)
            startActivityForResult(secint, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                val value1 = data?.getIntExtra("value1", 0)
                val value2 = data?.getDoubleExtra("value2", 0.0)
                val value3 = data?.getBooleanExtra("value3", false)
                val value4 = data?.getStringExtra("value4")

                b.textView.text = "value1 : $value1 \n"
                b.textView.append("value2 : $value2 \n")
                b.textView.append("value3 : $value3 \n")
                b.textView.append("value4 : $value4 \n")

            }
        }
    }
}