package co.kr.chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        chip1.setOnClickListener{
            txt1.text = "첫번째 chip"
            if(chip2.isChecked == true){
                txt1.append("\n두번째 칩 선택")
            } else {
                txt1.append("\n두번째 칩 선택 안됌")
            }

            if(chip6.isChecked == true){
                txt1.append("세번째 chip(엔트리)를 선택함")
            } else {
                txt1.append("세번째 chip(엔트리)를 선택안함")
            }

            if(chip7.isChecked == true){
                txt1.append("네번째 chip을 선택함")
            } else {
                txt1.append("네번째 chip을 선택안함")
            }

            when(chipgroup1.checkedChipId){
                R.id.chip8 -> txt1.append("칩 그룹 1번 칩")
                R.id.chip9 -> txt1.append("칩 그룹 2번 칩")
                R.id.chip10 -> txt1.append("칩 그룹 3번 칩")
            }
        }

        chip6.setOnClickListener {
            txt1.text = "버튼 누름"
        }

        chip6.setOnCloseIconClickListener {
            txt1.text = "닫기 버튼 누름"
        }

        chip7.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true){
                txt1.text = "네 번째 chip 체크"
            } else {
                txt1.text = "네 번째 chip 체크 해제"
            }
        }


    }
}