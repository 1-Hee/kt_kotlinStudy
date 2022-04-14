package co.kr.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "SeekBar 1 : ${seekBar.progress}"
            textView2.text = "SeekBar 2 : ${seekBar2.progress}"
        }

        button2.setOnClickListener {
            seekBar.progress = 3
            seekBar2.progress = 8
        }

        button3.setOnClickListener {
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        button4.setOnClickListener {
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        seekBar.setOnSeekBarChangeListener(ls1)
        seekBar2.setOnSeekBarChangeListener(ls1)
    }
    val ls1 = object : SeekBar.OnSeekBarChangeListener{
        // progress bar의 값이 변경되었을 때 반응
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            when(p0?.id){
                R.id.seekBar -> {
                    textView.text = "첫번째 SeekBar1 : ${p1}\n"
                }
                R.id.seekBar2 ->{
                    textView.text = "두번째 SeekBar1 : ${p1}\n"
                }
            }

            if(p2 == true){
                textView.append("사용자에 의해 설정\n")
            } else {
                textView.append("코드에 의해 설정\n")
            }

        }

        // 사용자가 터치를 했을때 반응
        override fun onStartTrackingTouch(p0: SeekBar?) {
            when(p0?.id){
                R.id.seekBar -> textView2.text = "첫번째 seekbar 사용자 터치 시작"
                R.id.seekBar2 -> textView2.text = "두번째 seekbar 사용자 터치 시작"
            }
        }

        // 사용자가 터치를 종료시 반응
        override fun onStopTrackingTouch(p0: SeekBar?) {
            when(p0?.id){
                R.id.seekBar -> textView2.text = "첫번째 seekbar 사용자 터치 종료"
                R.id.seekBar2 -> textView2.text = "두번째 seekbar 사용자 터치 종료"
            }
        }

    }
}