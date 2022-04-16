package co.kr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    // Activity가 생성될때 자동으로 호출된다.
    // 화면전황이 발생할때 자동으로 호출 됨


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("test1", "OnCreate")
    }

    // onCreate 메서드 호출 이후에 자동으로 호출
    // Activity가 정지 상태 되었다가 활동상태로 돌아올 때 호출
    override fun onStart() {
        super.onStart()
        Log.d("test1", "OnStart")
    }

    //onStart 메서드가 호출된 이후 자동으로 호출
    // 액티비티가 일시정지되었다가 다시 돌아올때 호출 됌
    override fun onResume() {
        super.onResume()
        Log.d("test1", "onResume")
    }

    // Activity가 정지 상태가 되었다가 활동 상태로 돌아갈때 onStart 전에 호출됨
    override fun onRestart() {
        super.onRestart()
        Log.d("test1", "onRestart")
    }

    // Activity가 일시 정지 살태가 될 때 호출
    // 화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝창이 나타날때 호출
    override fun onPause() {
        super.onPause()
        Log.d("test1", "OnPause")
    }

    // Activity가 화면에서 사라질 때 호출
    override fun onStop() {
        super.onStop()
        Log.d("test1", "OnStop")
    }


    // 현재 액티비티의 수행이 완전히 종료되어 메모리 상에서 제거될 때 호출출
   override fun onDestroy() {
        super.onDestroy()
        Log.d("test1", "OnDestroy")
    }

}