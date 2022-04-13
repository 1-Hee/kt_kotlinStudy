package co.kr.sf.jo.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            txtv1.text = textinputlayout.editText?.text
            textinputlayout.editText?.clearFocus()

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textinputlayout.editText?.windowToken, 0)
        }

        textinputlayout.editText?.addTextChangedListener(ls1)
    }
    val ls1 = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if(p0 != null){
                if(p0.length >8){
                    textinputlayout.error = "8글자 이내로 작성해 주세요"
                } else {
                    textinputlayout.error = null
                }
            }
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}