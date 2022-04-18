package co.kr.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.dialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val subFragment = SubFragment()
            subFragment.show(supportFragmentManager, "tag")
        }


    }
}