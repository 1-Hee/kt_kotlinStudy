package co.kr.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import co.kr.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //PopUpMenu 객체 생성
            val pop = PopupMenu(this, binding.textView)

            // 메뉴를 구성한다
            menuInflater.inflate(R.menu.menu1, pop.menu)

            pop.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.Item1 -> binding.textView.text ="메뉴 1을 누름"
                    R.id.Item2 -> binding.textView.text ="메뉴 2을 누름"
                    R.id.Item3 -> binding.textView.text ="메뉴 3을 누름"

                }

                true
            }

            pop.show()
        }
    }
}