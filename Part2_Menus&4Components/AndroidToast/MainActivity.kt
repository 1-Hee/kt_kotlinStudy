package co.kr.androidtoast

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import co.kr.androidtoast.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)


        b.button.setOnClickListener {
            // 토스트 객체 생성
            val t1 = Toast.makeText(this, "기본 토스트 입니다", Toast.LENGTH_SHORT)

            //callback 객체 생성
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                val callback = object : Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        b.textView.text = "Toast 메세지가 사라짐"
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        b.textView.text  = "Toast 메세지가 나타남"
                    }
                }
                t1.addCallback(callback)
            }

            t1.show()
        }

        b.button2.setOnClickListener {
            // Toast에 보여줄 객체를 생성
            val toastView = layoutInflater.inflate(R.layout.custom_toast, null)
            
            toastView.run {
                toastView.findViewById<ImageView>(R.id.toastImage).setImageResource(R.drawable.img_android)
                toastView.findViewById<TextView>(R.id.toastText).text = "커스텀 토스트 입니다"
            }

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            // toast 객체를 생성한다
            val t2 = Toast(this)
            t2.view = toastView
            t2.setGravity(Gravity.CENTER, 0, 300)
            t2.duration = Toast.LENGTH_LONG
            t2.show()

         }

    }
}