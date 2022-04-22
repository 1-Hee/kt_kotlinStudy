package co.kr.rawfileread

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.rawfileread.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var mp:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            val inputStream = resources.openRawResource(R.raw.data)
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)

            var str:String? = null
            val sb= StringBuffer()
            do{
                str = br.readLine()
                if(str != null){
                    sb.append("$str\n")
                }
            } while(str != null)

            br.close()

            r.textView.text = sb.toString()
        }

        r.button2.setOnClickListener {
            if(mp == null){
                mp = MediaPlayer.create(this, R.raw.song)
                mp?.start()
            }
        }

        r.button3.setOnClickListener {
            if(mp != null){
                mp?.stop()
                mp = null
            }
        }

        r.button4.setOnClickListener {
            if(r.videoView.isPlaying == false){
//                val Web = "https://www.youtube.com/watch?v=1jh8YZlKIIs"
//                val uri = Uri.parse(Web)
                val uri = Uri.parse("android.resource://${packageName}/raw/news")
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