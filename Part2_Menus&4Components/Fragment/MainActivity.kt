package co.kr.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        r.button.setOnClickListener{
        //Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
        // Fragment를 세팅한다
        //    tran.add(R.id.container1, frag1)
        // 여러 Frag를 add 하면 그위에 중첩되므로 replace를 사용하는게 더 깔끔함
            tran.replace(R.id.container1, frag1)

            // Frag는 Activity가 아니므로 Back 버튼을 누르면 액티비티 전체가 종료되버림
            // Frag를 Activity처럼 사용하고자 하면 아래의 기능 필요
            tran.addToBackStack(null)
            // 단 addToBackStack은 commit 이전에 작성해야함
            tran.commit()
        }

        r.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
//            tran.add(R.id.container1, frag2)
            tran.replace(R.id.container1, frag2)
            tran.addToBackStack(null)

            tran.commit()
        }




    }
}