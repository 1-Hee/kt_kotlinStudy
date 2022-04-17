package co.kr.ipc

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import co.kr.ipc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 접속한 서비스 객체
    var ipcService:TestService? = null

    // 서비스 접속을 관리하는 객체 생성
    val connection = object : ServiceConnection {

        //서비스에 접속 성공 시 호출되는 메서드
        // 두번째 : 서비스의 onBind 메소드가 반환하는 객체를 받음
       override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            //서비스를 추출한다.
            val binder = p1 as TestService.LocalBinder
           ipcService = binder.getService()
        }


        // 서비스 접속 해제 시 호출되는 메서드
        override fun onServiceDisconnected(p0: ComponentName?) {
            ipcService = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // 서비스가 가동중이 아니라면 서비스를 가동
        val chk = isServiceRunning("co.kr.ipc.TestService")
        val serviceIntent = Intent(this, TestService::class.java)

        if(chk==false){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        // 서비스에 접속한다
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        r.button.setOnClickListener {
            val value = ipcService?.getNumber()
            r.textView.text = "value $value"
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // 접속한 서비스에 접속을 해제한다.
        unbindService(connection)
    }

    // 서비스 실행 여부를 검사하는 메서드
    fun isServiceRunning(name:String) : Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        // 현재 실행중인 서비스들을 가져온다.
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)
        // 원래 모든 서비스의 목록을 가져왔는데, deprecated됨
        // 사용 불가는 아니나 이 메서드를 사용하면 현재 가동중인 어플 범위에서만 가져옴
        for(serviceInfo in serviceList){
            //서비스 이름이 원하는 이름인가..?
            if(serviceInfo.service.className == name){
                return true
            }
        }
        return false
    }
}