package co.kr.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class SubFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity

        val main_textView = view?.findViewById<TextView>(R.id.textView)

        val builder = AlertDialog.Builder(mainActivity)
        builder.setTitle("타이틀 입니다")
        builder.setMessage("메세지 입니다")
        builder.setPositiveButton("OK") {dialogInterface, i ->
            mainActivity.r.textView.text = "POS"
        }

        builder.setNeutralButton("PASS"){dialogInterface, i ->
            mainActivity.r.textView.text = "PASS"

        }

        builder.setNegativeButton("CANCEL"){dialogInterface, i ->
            mainActivity.r.textView.text = "CANCEL"

        }

        val alert = builder.create()

        return alert
    }


}