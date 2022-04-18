package co.kr.activitycontoller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.kr.activitycontoller.databinding.FragmentInputBinding

class InputFragment :Fragment() {
    val r by lazy { FragmentInputBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.input_btn1)
        val input_text1 = view.findViewById<TextView>(R.id.input_edit1)
        val input_text2 = view.findViewById<TextView>(R.id.input_edit2)


        btn.setOnClickListener {
            val mainActivity = activity as MainActivity

            mainActivity.value1 = input_text1.text.toString()
            mainActivity.value2 = input_text2.text.toString()


            mainActivity.setFragment("result")
        }
    }

    override fun onResume() {
        super.onResume()

        val input_text1 = view?.findViewById<TextView>(R.id.input_edit1)
        val input_text2 = view?.findViewById<TextView>(R.id.input_edit2)

        input_text1?.setText("")
        input_text2?.setText("")


    }

}