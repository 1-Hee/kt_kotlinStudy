package co.kr.activitycontoller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activitycontoller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }
    // 프래그먼트들이 사용할 변수
    var value1 = ""
    var value2 = ""

    val inputFragment = InputFragment()
    val resultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setFragment("input")

    }

    fun setFragment(name:String){
        val tran = supportFragmentManager.beginTransaction()
        when(name){
            "input" -> {
                tran.replace(R.id.container1, inputFragment)
            }
            "result" ->{
                tran.replace(R.id.container1, resultFragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}