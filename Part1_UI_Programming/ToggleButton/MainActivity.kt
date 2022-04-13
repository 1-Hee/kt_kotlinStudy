package co.kr.sf.jo.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle.setOnClickListener{
            if(toggle.isChecked==true){
                txtv2.text = "ON상태"
            } else {
                txtv2.text = "OFF상태"
            }
        }

        btn1.setOnClickListener {
            if(toggle.isChecked==true){
                txtv1.text = "ON상태"
            } else {
                txtv1.text = "OFF상태"
            }
        }

        btn2.setOnClickListener {
            toggle.isChecked = true
        }

        btn3.setOnClickListener {
            toggle.isChecked = false
        }
        btn4.setOnClickListener {
            toggle.toggle()
        }



    }
    val ls1 = object : View.OnClickListener{
        override fun onClick(p0: View?) {
            if(toggle.isChecked == true){
                txtv1.text = "ON상태(btn4)"
            } else {
                txtv1.text = "OFF상태(btn4)"
            }

        }
    }

}