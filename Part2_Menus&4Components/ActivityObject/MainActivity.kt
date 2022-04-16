package co.kr.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val sec_int = Intent(this, SecondActivity::class.java)

            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "문자열1"

            sec_int.putExtra("obj1", t1)


//            startActivity(sec_int)
            startActivityForResult(sec_int, SECOND_ACTIVITY)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SECOND_ACTIVITY){
            if(resultCode== RESULT_OK){
                // 객체를 추출
                val obj2 = data?.getParcelableExtra<TestClass>("obj2")
                b.textView.text = "obj2.data1 : ${obj2?.data1} \n "
                b.textView.append("obj2.data2 : ${obj2?.data2}")
            }
        }
    }
}