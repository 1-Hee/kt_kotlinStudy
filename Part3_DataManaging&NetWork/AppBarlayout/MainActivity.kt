package co.kr.appbarlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.widget.Toolbar
import co.kr.appbarlayout.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setSupportActionBar(r.toolbar)

        r.toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        r.toolbarLayout.setExpandedTitleColor(Color.GREEN)
        r.toolbarLayout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
        r.toolbarLayout.expandedTitleGravity = Gravity.RIGHT + Gravity.TOP

        r.imageView.setImageResource(R.drawable.img_android)

        supportActionBar?.title = "타이틀 입니다"



    }
}