package co.kr.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            textView.text  = "Rating 1 : ${ratingBar.rating}\n"
            textView.append("Rating 2 : ${ratingBar2.rating}\n")
            textView.append("Rating 3 : ${ratingBar3.rating}\n")
            textView.append("Rating 4 : ${ratingBar4.rating}\n")

        }

        button2.setOnClickListener {
            ratingBar.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.0f
            ratingBar4.rating = 4.0f
        }

        ratingBar2.setOnRatingBarChangeListener(ls1)
        ratingBar3.setOnRatingBarChangeListener(ls1)

        ratingBar4.setOnRatingBarChangeListener { ratingBar, fl, b ->
            textView3.text = "R4 : ${fl}\n"
            if(b == true){
                textView3.append("사용자에 의해 설정")
            } else {
                textView3.append("코드에 의해 설정")            }
        }

    }
    ////

    var ls1 = object : RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
            when(p0?.id){
                R.id.ratingBar2 -> {
                    textView2.text = "Rating2 : ${p1}"
                    if (p2 == true){
                        textView.append("사용자에 의해 편집")
                    } else {
                        textView.append("코드에 의해 편집")
                    }
                }
                R.id.ratingBar3 -> {
                    textView2.text = "Rating2 : ${p1}"
                    if (p2 == true){
                        textView.append("사용자에 의해 편집")
                    } else {
                        textView.append("코드에 의해 편집")
                    }

                }
            }


        }

    }
}