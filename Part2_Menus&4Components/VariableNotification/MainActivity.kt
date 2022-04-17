package co.kr.variablenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import co.kr.variablenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
             val builder1 = getNotificationBuilder("Style", "Style Notification")
            builder1.setContentTitle("Big Picture")
            builder1.setContentText("Big Picture Context")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            // BigPicture Notification 객체 생성
            val big = NotificationCompat.BigPictureStyle(builder1)
            // 보여줄 이미지를 설정
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")
            big.setSummaryText("Summary Text")

            val notification = builder1.build()
            val mananger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mananger.notify(10, notification)
        }

        b.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("Style", "Style Notification")
            builder1.setContentTitle("Big Text")
            builder1.setContentText("Big Text Context")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //Big Text Notification 생성
            val big = NotificationCompat.BigTextStyle(builder1)
            big.setSummaryText("Summary Text")
            big.setBigContentTitle("Big Content Title")
            big.bigText("아스라히 새겨지는 그리고 겨울이 계십니다. 사람들의 내 오는 시인의 다 있습니다. 슬퍼하는 그러나 까닭이요, 새겨지는 멀리 그리워 계십니다. 청춘이 봄이 둘 있습니다. 하나의 써 별 피어나듯이 아무 이름과, 내일 거외다. 추억과 어머니, 프랑시스 새겨지는 버리었습니다. 별 새겨지는 마디씩 봅니다. 무엇인지 다 시인의 다하지 있습니다. 계집애들의 겨울이 청춘이 했던 하나에 까닭입니다. 우는 둘 묻힌 계십니다. 릴케 아이들의 강아지, 이름을 별들을 오면 거외다.")

            val notification = builder1.build()
            val mananger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mananger.notify(20, notification)

        }

        b.button3.setOnClickListener {
            val builder1 = getNotificationBuilder("Style", "Style Notification")
            builder1.setContentTitle("InBox")
            builder1.setContentText("InBox Context")
            builder1.setSmallIcon(android.R.drawable.ic_menu_camera)

            //InBox Style notification 생성
            val inbox = NotificationCompat.InboxStyle(builder1)
            inbox.setSummaryText("Summary Text")

            inbox.addLine("########################################")
            inbox.addLine("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
            inbox.addLine("999999999999999999999999999999999999")
            inbox.addLine("55555555555555555555555555555555555555")
            inbox.addLine("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr")
            inbox.addLine("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh")
            inbox.addLine("ggggggggggggggggggggggggggggggggg")

            val notification = builder1.build()
            val mananger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mananger.notify(30, notification)
        }

    }

    fun getNotificationBuilder(id:String, name:String) :NotificationCompat.Builder{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)
            val builder = NotificationCompat.Builder(this, id)
            return  builder
        } else {
            val builder = NotificationCompat.Builder(this)
            return  builder
        }
    }

}