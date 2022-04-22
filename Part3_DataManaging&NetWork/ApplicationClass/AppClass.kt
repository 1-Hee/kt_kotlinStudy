package co.kr.applicationclass

import android.app.Application
import android.util.Log

class AppClass : Application() {
    var value1 = 0
    var value2 = ""

    fun method1() {
        Log.d("test", "메서드 1을 호출")
    }

}