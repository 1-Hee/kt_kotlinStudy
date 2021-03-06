package co.kr.pendingintent

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import co.kr.pendingintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val builder1 = getNotificationBuilder("pending", "pending intent")
            builder1.setContentTitle("Notification 1")
            builder1.setContentText("알림 메세지1 입니다")

            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)

            //메세지를 터치하면 자동으로 메세지를 제거한다.
            builder1.setAutoCancel(true)

            // 메세지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this, NotificationActivity1::class.java)
            intent1.putExtra("data1", 100)
            intent1.putExtra("data2", 200)

            // Action 설정
            val intent2 = Intent(this, NotificationActivity3::class.java)
            val pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action1", pending2)
            val action2 = builder2.build()
            builder1.addAction(action2)

            val intent3 = Intent(this, NotifiactionActivity4::class.java)
            val pending3 = PendingIntent.getActivity(this, 100, intent3, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder3 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_agenda, "Action2", pending3)
            val action3 = builder3.build()
            builder1.addAction(action3)

            val pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.notify(10, notification)

        }

        b.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("pending", "pending intent")
            builder1.setContentTitle("Notification 2")
            builder1.setContentText("알림 메세지2 입니다")

            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)

            // 메세지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this, NotificationActivity2::class.java)
            val pending1 = PendingIntent.getActivity(this, 20, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending1)


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.notify(20, notification)
        }

    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val Channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            Channel.enableLights(true)
            Channel.lightColor = Color.RED
            Channel.enableVibration(true)
            manager.createNotificationChannel(Channel)
            val builder1 = NotificationCompat.Builder(this, id)
            return builder1
        } else {
            val builder2 = NotificationCompat.Builder(this)
            return builder2

        }

    }
}