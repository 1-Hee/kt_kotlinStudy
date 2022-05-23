package co.kr.to_it

import android.R
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.os.SystemClock
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import co.kr.to_it.databinding.ActivityMemoEditBinding
import java.text.SimpleDateFormat
import java.util.*


class MemoEditActivity : AppCompatActivity() {
    lateinit var b : ActivityMemoEditBinding

    var myCalendar: Calendar = Calendar.getInstance()

    var myDatePicker =
        OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(b.root)
        // toolbar 설정
        setSupportActionBar(b.editToolbar)
        title = "To do 생성하기"

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 화면 구성과 동시에 키보드가 올라오기 때문에 키보드가 안 올라옴
        // 화면 구 성할 시간을 ㅂㄹ어주기 위해 쓰레드에서 시간을 약간 주고 처리함.

        b.closeBtn.setOnClickListener {
            finish()
        }

        b.inputDate.setOnClickListener {
            DatePickerDialog(
                this@MemoEditActivity,
                myDatePicker,
                myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()
        }

        Thread {
            SystemClock.sleep(800)
            runOnUiThread {

                b.editSubject1.requestFocus()
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(b.editSubject1, InputMethodManager.SHOW_IMPLICIT)

                /*
                rec_idx integer primary key autoincrement,
                rec_subject text not null,
                rec_time date not null,
                rec_stars integer not null,
                rec_memo text)

                 */

                b.saveBtn.setOnClickListener {
                    val rec_subject = b.editSubject1.text
                    val rec_date = b.inputDate.text
                }


            }
        }.start()





    }


    // To do List 매니저의 날짜를 업데이트 하는 메서드(사용자 정의)
    fun updateLabel() {
        val myFormat = "yyyy/MM/dd" // 출력형식   2018/11/28
        val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
        b.inputDate.setText(sdf.format(myCalendar.time))
    }

    // 툴바의 홈버튼 누르면 홈으로 돌아가게 하는 메서드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}