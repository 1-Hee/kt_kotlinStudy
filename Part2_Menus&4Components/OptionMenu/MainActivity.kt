package co.kr.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.kr.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //xml로 메뉴를 구성
        //menuInflater.inflate(R.menu.main_menu, menu)

        menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴1")
        //menu?.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드 메뉴2")
        val sub = menu?.addSubMenu("코드 메뉴2")
        sub?.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "코드 메뉴 2-1")
        sub?.add(Menu.NONE, Menu.FIRST+20, Menu.NONE, "코드 메뉴 2-2")

        menu?.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "코드 메뉴3")



        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //메뉴의 아이디별로 분기(xml에서 만든후 분기)
//        when(item.itemId){
//            R.id.item1 -> {binding.textView.text = "메뉴1을 눌렀습니다"}
////            R.id.item2 -> {binding.textView.text = "메뉴2를 눌렀습니다"}
//
//            R.id.item2_1 -> {binding.textView.text = "메뉴2-1을 눌렀습니다"}
//            R.id.item2_2 -> {binding.textView.text = "메뉴2-2을 눌렀습니다"}
//
//
//            R.id.item3 -> {binding.textView.text = "메뉴3를 눌렀습니다"}
//        }


        // 코드로 메뉴 생성한 것을 분기하는 법
        when(item.itemId) {
            Menu.FIRST -> {binding.textView.text = "코드메뉴1을 눌렀음"}
            Menu.FIRST+10 -> {binding.textView.text = "코드메뉴2-1을 눌렀음"}
            Menu.FIRST+20 -> {binding.textView.text = "코드메뉴2-2을 눌렀음"}
            Menu.FIRST+2 -> {binding.textView.text = "코드메뉴3을 눌렀음"}
        }

        return super.onOptionsItemSelected(item)
    }
}