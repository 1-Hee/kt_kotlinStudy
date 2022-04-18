package co.kr.fragmentview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.fragmentview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val frag = SubFragment()

        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, frag)
        tran.commit()


    }
}