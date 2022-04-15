package ko.CustomListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView1, data1)
        list1.adapter = adapter1

        list1.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "${data1[i]} 를 터치함"
        }
    }
}