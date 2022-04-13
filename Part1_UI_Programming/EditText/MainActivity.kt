package co.kr.sf.jo.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            txtv1.text = edit.text
            // edit text focus off
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(edit.windowToken, 0) // flag 매개변수는 구분자의 역할
            edit.clearFocus()
        }
        edit.addTextChangedListener(ls1)
        edit.setOnEditorActionListener { textView, i, keyEvent ->
            txtv1.text ="엔터 감지"
            false }
        // true로 하면 키보드 안내려감, 대신 값도 그대로유지
    }

    val ls1 = object : TextWatcher{
        //문자열이 변경되기 전
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            txtv1.text = "before + $p0"
        }

        // 문자열 변경이 종료된 후
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            txtv1.text = "changed + $p0"

        }
        //문자열이 변경된 것이 화면에 반영되었을 때
        override fun afterTextChanged(p0: Editable?) {
            txtv1.text = "after + $p0"

        }

    }

}