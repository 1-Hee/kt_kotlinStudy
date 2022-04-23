package co.kr.resourcemanange

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.resourcemanange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}
    var nums = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
//            r.textView.text = "반갑습니다"
//            r.textView.setText(R.string.str2)

//            val str2 = resources.getString(R.string.str2)
            val str2 = getString(R.string.str2)
            r.textView.text = str2
        }

        r.button2.setOnClickListener {
            val str3 = getString(R.string.str3)
            val str4 = String.format(str3, "김길동", 34)
            r.textView.text = str4

        }

        r.button3.setOnClickListener {
            val data_list = resources.getStringArray(R.array.data_array)
            r.textView.text = ""

            var n = 0
            for(i in data_list){
                n++
                r.textView.append("$n : $i \n")
            }
        }

        r.button4.setOnClickListener {
            // r.textView.setTextColor(Color.BLUE)
            val color = Color.rgb(26, 106, 129)
            val color2 = Color.argb(50, 26, 106, 129)
            val color3 = getColor(R.color.color2)
            val color4 = getColor(R.color.color3)
            val color5 = getColor(R.color.color4)

            nums++
            when(nums%5){
                0 -> r.textView.setTextColor(color)
                1 -> r.textView.setTextColor(color2)
                2 -> r.textView.setTextColor(color3)
                3 -> r.textView.setTextColor(color4)
                4 -> r.textView.setTextColor(color5)
            }

        }
        // ppi -> pixel per inch -> 가로세로 1인치 안에 몇개의 픽셀
        // dpi -> dot per inch -> 가로 1인치 안에 점을 몇개를 표현할 수 있는가
        // 점 1개를 표현하기 위해 픽셀 하나씩 소모됨

        r.button5.setOnClickListener {
            val px = resources.getDimension(R.dimen.px)
            val dp = resources.getDimension(R.dimen.dp)
            val sp = resources.getDimension(R.dimen.sp)
            val inch = resources.getDimension(R.dimen.inch)
            val mm = resources.getDimension(R.dimen.mm)
            val pt = resources.getDimension(R.dimen.pt)

            r.textView.text = "px $px \n"
            r.textView.append("dp $dp \n")
            r.textView.append("sp $sp \n")
            r.textView.append("inch $inch \n")
            r.textView.append("mm $mm \n")
            r.textView.append("pt $pt \n")

            r.textView.textSize = 20 * sp
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        nums = 0;
        finish()
    }
}
