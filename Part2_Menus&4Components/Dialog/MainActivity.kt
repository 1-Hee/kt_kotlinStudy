package co.kr.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import co.kr.dialog.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그 입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            builder.setPositiveButton("Positive"){ dialogInterface, i ->
                b.textView.text = "Pos 버튼누름"
            }
            builder.setNeutralButton("Neutral"){ dialogInterface, i ->
                b.textView.text = "Neu 버튼누름"
            }
            builder.setNegativeButton("Nagative"){ dialogInterface, i ->
                b.textView.text = "Nag 버튼누름"
            }

            builder.show()
        }

        b.button3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val custom_view = layoutInflater.inflate(R.layout.custom_dialog, null)
            builder.setView(custom_view)

            builder.setPositiveButton("OK"){dialogInterface, i ->
                custom_view.run {
                    b.textView.text = "${custom_view.findViewById<EditText>(R.id.custom_edit1).text} \n"
                    b.textView.append("${custom_view.findViewById<EditText>(R.id.custom_edit2).text}")
                }
            }

            builder.setNegativeButton("Cancel", null)
            builder.show()

        }

        b.button4.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)


            val ls1 = DatePickerDialog.OnDateSetListener { p0, p1, p2, p3 ->
                b.textView.text = "$p1 년 ${p2+1} 월 $p3 일"
            }

            val picker = DatePickerDialog(this, ls1, year,month,day)
            picker.show()
        }

        b.button5.setOnClickListener {
            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR)
            val min = calendar.get(Calendar.MINUTE)

            val ls2 = TimePickerDialog.OnTimeSetListener{timePicker, i, i2 ->
                b.textView.text = "현재시간 $i : $i2 "
            }
            val picker = TimePickerDialog(this, ls2, hour, min, true)
            picker.show()

        }





    }
}