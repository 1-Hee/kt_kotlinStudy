package co.kr.notofication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import co.kr.notofication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        // 안드로이드 api 8.0 이전 버전에서만 가능함 현재는 안됌
//        b.button.setOnClickListener {
//            val builder = NotificationCompat.Builder(this)
//
//            builder.setSmallIcon(android.R.drawable.ic_menu_search)
//
//            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
//            builder.setLargeIcon(bitmap)
//
//            builder.setContentTitle("Content Title")
//            builder.setContentText("Content Text")
//
//            val notification = builder.build()
//
//            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            manager.notify(10, notification)
//
//        }

        b.button.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫번째 채널")
            //작은 아이콘(메세지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰아이콘(메세지 본문에 표시할 메시지, Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정(설정 안해도 되는데 알림 메세지 안에 숫자를 표시해줌, 메세지 개수 표시 등, 미확인 메세지 숫자)
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title")
            // 메세지 설정
            builder1.setContentText("Content Text1")
            // 메세지 객체를 생성
            val notification = builder1.build()
            // 알림 메세지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메세지를 출력한다
            manager.notify(10, notification)

        }

        b.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫번째 채널")
            //작은 아이콘(메세지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰아이콘(메세지 본문에 표시할 메시지, Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정(설정 안해도 되는데 알림 메세지 안에 숫자를 표시해줌, 메세지 개수 표시 등, 미확인 메세지 숫자)
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 2")
            // 메세지 설정
            builder1.setContentText("Content Text2")
            // 메세지 객체를 생성
            val notification = builder1.build()
            // 알림 메세지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메세지를 출력한다
            manager.notify(20, notification)

        }

        b.button3.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "두번째 채널")
            //작은 아이콘(메세지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰아이콘(메세지 본문에 표시할 메시지, Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정(설정 안해도 되는데 알림 메세지 안에 숫자를 표시해줌, 메세지 개수 표시 등, 미확인 메세지 숫자)
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 3")
            // 메세지 설정
            builder1.setContentText("Content Text 3")
            // 메세지 객체를 생성
            val notification = builder1.build()
            // 알림 메세지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메세지를 출력한다
            manager.notify(30, notification)
        }

        b.button4.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "두번째 채널")
            //작은 아이콘(메세지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰아이콘(메세지 본문에 표시할 메시지, Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정(설정 안해도 되는데 알림 메세지 안에 숫자를 표시해줌, 메세지 개수 표시 등, 미확인 메세지 숫자)
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 4")
            // 메세지 설정
            builder1.setContentText("Content Text 4")
            // 메세지 객체를 생성
            val notification = builder1.build()
            // 알림 메세지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메세지를 출력한다
            manager.notify(40, notification)
        }


    }

    // 안드로이드 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder{
        // os 버전별로 분기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {// 안드로이드 8.0 이상이라면
            // 알림 메세지를 관리하는 객체를 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 채널 객체를 생성한다
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            // 메세지 출력 시 단말기 LED를 사용할 것인가
            channel.enableLights(true)
            // LED 색상 설정
            channel.lightColor = Color.GREEN
            // 진동 사용 여부
            channel.enableVibration(true)
            // 알림 메세지를 관리하는 채널을 등록한다.
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            return builder


        } else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }
    }

}