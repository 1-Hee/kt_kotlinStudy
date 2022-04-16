package co.kr.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.kr.contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    val data1 = arrayOf("항목1","항목2","항목3","항목4","항목5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list1.adapter = adapter

        binding.list1.setOnItemClickListener { adapterView, view, i, l ->
            binding.textView.text = "리스트뷰의 항목 클릭 : ${data1[i]}"
        }

        // ContextMenu를 View에 등록
        registerForContextMenu(binding.textView)
        registerForContextMenu(binding.list1)


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when(v?.id){
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트 뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1, menu)
            }
            R.id.list1 -> {
                //사용자가 길게 누른 항목 인덱스 번호를 파악하기 위해
                val info = menuInfo as AdapterView.AdapterContextMenuInfo

                menu?.setHeaderTitle("리스트 뷰의 메뉴 : ${info.position}")
                menuInflater.inflate(R.menu.menu2, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        // 리스트 항목의 인덱스 번호를 받을 변수
        var position = 0;
        when(item.itemId){
            R.id.list_item1, R.id.list_item2 ->{
                //MenuInfo 객체를 추출
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                position = info.position
           }
        }

        // 메뉴의 id값으로 분기
        when(item.itemId){
            R.id.text_item1 -> binding.textView.text = "텍스트뷰의 메뉴1을 누름"
            R.id.text_item2 -> binding.textView.text = "텍스트뷰의 메뉴2을 누름"

            R.id.list_item1 -> binding.textView.text = "리스트뷰의 메뉴1 누름 : ${position}"
            R.id.list_item2 -> binding.textView.text = "리스트뷰의 메뉴2 누름 : ${position}"

        }

        return super.onContextItemSelected(item)
    }
}