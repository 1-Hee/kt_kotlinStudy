package co.kr.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.listfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val subFragment = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, subFragment)
        tran.commit()


    }
}