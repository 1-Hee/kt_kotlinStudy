package co.kr.preferencescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.preferencescreen.databinding.ActivityMainBinding
import co.kr.preferencesscreen.ResultFragment
import co.kr.preferencesscreen.SettingFragment

class MainActivity : AppCompatActivity() {
    val settingFragment = SettingFragment()
    val resultFragment = ResultFragment()

    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container, settingFragment)
            tran.commit()

        }

        r.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container, resultFragment)
            tran.commit()
        }

    }
}