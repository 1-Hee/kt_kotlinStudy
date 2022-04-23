package co.kr.imageresouce

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.imageresouce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.imageView2.setImageResource(R.drawable.img_android)

        //Bitamp : JPG, PNG, GIF 파일로부터 얻어온 이미지 데이터를 관리
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
        r.imageView3.setImageBitmap(bitmap)

        //Drawable : Bitmap을 포함한 다양한 타입으로 부터 이미지 데이터를 관리
        val drawable = getDrawable(R.drawable.img_android)
        r.imageView4.setImageDrawable(drawable)

        // 배경 타일 이미지를 생성한다.
//        r.container.setBackgroundResource(R.drawable.tile) // 로컬에 있을 때

        val drawable2 = getDrawable(R.drawable.tile) // 원격, 온라인 등에서 불러올 때
        r.container.background = drawable2

        // 레이어 이미지를 사용한다.
        val drawable3 = getDrawable(R.drawable.layer)
        r.imageView5.setImageDrawable(drawable3)

        // 상태 이미지를 사용한다
        val drawable4 = getDrawable(R.drawable.btn_image)
        r.button.background = drawable4

    }
}