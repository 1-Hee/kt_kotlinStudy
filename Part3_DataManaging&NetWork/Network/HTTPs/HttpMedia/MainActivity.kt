package co.kr.httpmedia

import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.httpmedia.databinding.ActivityMainBinding
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    var mp:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {

            thread {
                val url = URL("http://192.168.0.5:8080/img_android.jpg")
                val conn = url.openConnection() as HttpURLConnection

                val bitmap = BitmapFactory.decodeStream(conn.inputStream)
                runOnUiThread{
                    r.imageView.setImageBitmap(bitmap)
                }
            }
        }

        r.button2.setOnClickListener {
            if(mp==null){
                val uri = Uri.parse("http://192.168.0.5:8080/song.mp3")
                mp = MediaPlayer.create(this, uri)
                mp?.start()
            }
        }

        r.button3.setOnClickListener {
            if(mp!=null){
                mp?.stop()
                mp = null
            }
        }

        r.button4.setOnClickListener {
            if(r.videoView.isPlaying == false){
                val uri = Uri.parse("http://192.168.0.5:8080/video.mp4")
                r.videoView.setVideoURI(uri)
                r.videoView.start()
            }

        }

        r.button5.setOnClickListener {
            if(r.videoView.isPlaying == true){
                r.videoView.stopPlayback()
            }

        }



    }
}