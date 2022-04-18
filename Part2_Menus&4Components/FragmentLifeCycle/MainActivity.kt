package co.kr.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.fragmentlifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val frag1 = SubFragment()

        r.button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1, frag1)
            tran.addToBackStack(null)
            tran.commit()
        }

        r.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.remove(frag1)
            tran.commit()
        }


    }
}