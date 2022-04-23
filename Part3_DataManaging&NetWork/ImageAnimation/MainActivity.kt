package co.kr.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.imageanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

//        r.imageView.setImageResource(R.drawable.ani_data)

        val drawable = getDrawable(R.drawable.ani_data)
        r.imageView.setImageDrawable(drawable)

        // 애니메이션 객체 추출
        val ani = r.imageView.drawable as AnimationDrawable
        r.button.setOnClickListener {
            ani.start()
        }

        r.button2.setOnClickListener {
            ani.stop()
        }


    }
}