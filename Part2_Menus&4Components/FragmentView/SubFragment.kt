package co.kr.fragmentview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.kr.fragmentview.databinding.ActivityMainBinding
import co.kr.fragmentview.databinding.ActivityMainBinding.inflate
import co.kr.fragmentview.databinding.FragmentSubBinding
import co.kr.fragmentview.databinding.FragmentSubBinding.inflate
import org.w3c.dom.Text

class SubFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, null)

        // 내부의 Veiw들의 주소값을 가져온다
        val text1 = view.findViewById<TextView>(R.id.frag_text1)
        val btn1 = view.findViewById<Button>(R.id.frag_btn1)

        btn1.setOnClickListener {
            text1.text = "fragment 문자열"
        }

        return view
    }

    // fragment가 관리하는 View 내부의 View의 주소값들이 세팅된 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fgbtn1 = view.findViewById<Button>(R.id.frag_btn1)
        val fgtxt1 = view.findViewById<TextView>(R.id.frag_text1)
        val fgbtn2 = view.findViewById<Button>(R.id.frag_btn2)

        fgbtn1.setOnClickListener {
            fgtxt1.text = "fragment 문자열"
        }


        fgbtn2.setOnClickListener {
            // MainActivity를 추출
            val parent = activity as MainActivity
            parent.r.activityText1.text = "Activity 문자열"
        }




    }
}