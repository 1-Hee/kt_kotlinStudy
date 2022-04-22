package co.kr.preferencesscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import co.kr.preferencescreen.R

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, null)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = context?.let { PreferenceManager.getDefaultSharedPreferences(it) }
        val data1 = pref?.getString("data1", null) // 여기서 data1은 pref.xml 파일의 key 값임
        val txt = view.findViewById<TextView>(R.id.textView2)
        txt.text = "data1 : $data1 \n"

        val data2 = pref?.getBoolean("data2", false)
        txt.append("data2 : $data2 \n")

        val data3 = pref?.getBoolean("data3", false)
        txt.append("data3 : $data3 \n")

        val data4 = pref?.getString("data4", null)
        txt.append("data4 : $data4 \n")

        val data5 = pref?.getStringSet("data5", null)
        for(str in data5!!){
            txt.append("data5 : $str \n")
        }

    }
}