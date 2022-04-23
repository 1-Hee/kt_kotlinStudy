package co.kr.rotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.kr.rotation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        Log.d("test", "$savedInstanceState")
        
        if(savedInstanceState == null){
            Log.d("test", "Activity가 처음 등장")
        } else {
            Log.d("test", "화면 회전이 발생")
            // 복원
            r.textView.text = savedInstanceState.getString("data1")
        }

        r.button.setOnClickListener {
            r.textView.text = r.edit1?.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //복원에 필요한 데이터 저장
        outState.putString("data1", r.textView.text.toString())
    }
}