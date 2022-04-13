package co.kr.sf.jo.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            if(checkbox1.isChecked==true){
                txtv1.text = "체크"
            } else {
                txtv1.text = "해제"
            }

            if(checkbox2.isChecked==true){
                txtv2.text = "체크"
            } else {
                txtv2.text = "해제"
            }

            if(checkbox3.isChecked==true){
                txtv3.text = "체크"
            } else {
                txtv3.text = "해제"
            }
        }

        btn2.setOnClickListener {
            checkbox1.isChecked = true
            checkbox2.isChecked = true
            checkbox3.isChecked = true
        }

        btn3.setOnClickListener {
            checkbox1.isChecked = false
            checkbox2.isChecked = false
            checkbox3.isChecked = false
        }

        btn4.setOnClickListener {
            checkbox1.toggle()
            checkbox2.toggle()
            checkbox3.toggle()
        }

        checkbox2.setOnCheckedChangeListener(ls1)
        checkbox1.setOnCheckedChangeListener(ls1)

        checkbox3.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true){
                txtv3.text = "3번 check on \n"
            } else {
                txtv3.text = "3번 check off \n"
            }

        }


    }
    val ls1 = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id){
                R.id.checkbox1 -> {
                    if(p1 == true){
                        txtv1.text = "1번 check on \n"
                    } else {
                        txtv1.text = "1번 check off \n"
                    }               }
                R.id.checkbox2 -> {
                    if(p1 == true){
                        txtv2.text = "2번 check on \n"
                    } else {
                        txtv2.text = "2번 check off \n"
                    }
                }
            }
        }


    }
    }

}