package co.kr.sf.jo.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            if(switch1.isChecked == true){
                txtv1.text = "스위치 켜짐"
            } else {
                txtv2.text = "스위치 꺼짐"
            }
        }
        btn2.setOnClickListener {
            if(switch1.isChecked == true ){
                switch1.isChecked = false
            } else {
                switch1.isChecked = true
            }
        }

        switch2.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true) txtv2.text = "(higher) switch2 on" else txtv2.text = "(higher) switch2 off"
        }



    }

    val ls1 = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id){
                R.id.switch1 -> if(p1 == true) txtv1.text = "(ls1) switch1 on" else txtv1.text = "(ls1) switch1 off"
            }

        }

    }

}