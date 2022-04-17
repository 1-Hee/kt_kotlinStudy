package co.kr.messagenotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import co.kr.messagenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                val builder1 = getNotificationBuilder("message", "message Style")
                builder1.setContentTitle("Message Style")
                builder1.setContentText("Message Style Notification")
                builder1.setSmallIcon(android.R.drawable.ic_input_delete)

                //채팅하듯 표현하는 알림을 구성하려면 여러 사용자(객체)가 필요함.
                val personBuilder1 = Person.Builder()
                val icon1 = IconCompat.createWithResource(this, android.R.drawable.ic_media_next)
                personBuilder1.setIcon(icon1)
                personBuilder1.setName("홍길동")
                val person1 = personBuilder1.build();

                val personBuilder2 = Person.Builder()
                val icon2 = IconCompat.createWithResource(this, android.R.mipmap.sym_def_app_icon)
                personBuilder1.setIcon(icon2)
                personBuilder1.setName("최길동")
                val person2 = personBuilder1.build();

                //

                val messageStyle = NotificationCompat.MessagingStyle(person1)

                messageStyle.addMessage("첫 번째 메세지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("두 번째 메세지", System.currentTimeMillis(), person2)
                messageStyle.addMessage("세 번째 메세지", System.currentTimeMillis(), person1)
                messageStyle.addMessage("네 번째 메세지", System.currentTimeMillis(), person2)

                builder1.setStyle(messageStyle)




                val notification = builder1.build()
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.notify(10, notification)
            }
        }


    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
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
            return builder
        }

    }
}