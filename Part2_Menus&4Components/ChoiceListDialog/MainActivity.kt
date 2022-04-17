package co.kr.choicelistdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import co.kr.choicelistdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        b.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Single Choice List")

            builder.setSingleChoiceItems(data1, 3){dialogInterface, i ->
                val t1 = Toast.makeText(this, data1[i], Toast.LENGTH_SHORT)
                t1.show()
            }
            builder.setNegativeButton("취소", null)
            builder.setPositiveButton("확인"){dialogInterface, i ->
                val alert = dialogInterface as AlertDialog
                val idx = alert.listView.checkedItemPosition
                b.textView.text = "선택된 항목 : ${data1[idx]}"
            }
            builder.show()
        }

        b.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val boolArray = booleanArrayOf(true,false,false,true,false,false,false,false)
            builder.setMultiChoiceItems(data1, boolArray){dialogInteface, i, b ->

                if(b == true ){
                    val t1 = Toast.makeText(this, "${data1[i]} 가 체크됨", Toast.LENGTH_SHORT)
                    t1.show()
                } else {
                    val t2 = Toast.makeText(this, "${data1[i]} 가 체크 해제됨", Toast.LENGTH_SHORT)
                    t2.show()

                }

            }

            builder.setNegativeButton("취소", null)
            builder.setPositiveButton("확인"){dialoginteface, i ->
                val alert = dialoginteface as AlertDialog

                b.textView.text =""

                val positions = alert.listView.checkedItemPositions
                for(i in 0 until positions.size()){
                    //체크 상태가 변경된 항목의 인덱스 번호를 추출
                    var index = positions.keyAt(i)
                    if(positions.get(index)==true){
                        b.textView.append("${data1[index]}, ")
                    }

                }
            }

            builder.show()

        }


    }
}