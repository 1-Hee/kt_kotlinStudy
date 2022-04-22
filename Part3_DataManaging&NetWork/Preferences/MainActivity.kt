package co.kr.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            // preferences 객체를 추출
            var pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            // 데이터 저장을 위한 객체 추출
            var editer = pref.edit()

            editer.putBoolean("data1", true)
            editer.putFloat("data2", 11.11f)
            editer.putInt("data3", 100)
            editer.putLong("data4", 10000L)
            editer.putString("data5", "문자열 데이터")

            val set = HashSet<String>()
            set.add("문자열1")
            set.add("문자열2")
            set.add("문자열3")
            editer.putStringSet("data6", set)

            editer.commit()

            r.textView.text  = "저장완료"

        }

        r.button2.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            // 저장된 데이터를 가져온다
            val data1 = pref.getBoolean("data1", false)
            val data2 = pref.getFloat("data2", 0.0f)
            val data3 = pref.getInt("data3", 0)
            val data4 = pref.getLong("data4", 0L)
            val data5 = pref.getString("data5", "초기값")
            val data6 = pref.getStringSet("data6", null)

            r.textView.text = "data1 : $data1 \n"
            r.textView.append("data2 : $data2 \n")
            r.textView.append("data3 : $data3 \n")
            r.textView.append("data4 : $data4 \n")
            r.textView.append("data5 : $data5 \n")

            for(str in data6!!){
                r.textView.append("data6 : $str \n")
            }



        }
    }
}