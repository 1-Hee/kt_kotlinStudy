package co.kr.sf.jo.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            radiobtn3.isChecked = true;
            radiobtn6.isChecked = true;
        }

        btn2.setOnClickListener {
            when(radiogroup.checkedRadioButtonId){
                R.id.radiobtn1 -> txtv1.text = "radiobtn1"
                R.id.radiobtn2 -> txtv1.text = "radiobtn2"
                R.id.radiobtn3 -> txtv1.text = "radiobtn3"
            }
            when(radiogroup2.checkedRadioButtonId){
                R.id.radiobtn4 -> txtv2.text = "radiobtn4"
                R.id.radiobtn5 -> txtv2.text = "radiobtn5"
                R.id.radiobtn6 -> txtv2.text = "radiobtn6"
            }
        }

        radiogroup.setOnCheckedChangeListener(ls1)
        radiogroup2.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radiobtn4 -> txtv2.text = "radiobtn4 (ls)"
                R.id.radiobtn5 -> txtv2.text = "radiobtn5 (ls)"
                R.id.radiobtn6 -> txtv2.text = "radiobtn6 (ls)"
            }

        }

        
    }

    val ls1 = object : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
             when(p0?.id){
                 R.id.radiogroup ->{
                     when(p1){
                         R.id.radiobtn1 -> txtv1.text = "radiobtn1 (ls)"
                         R.id.radiobtn2 -> txtv1.text = "radiobtn2 (ls)"
                         R.id.radiobtn3 -> txtv1.text = "radiobtn3 (ls)"

                     }
                 }
             }
        }
    }
}