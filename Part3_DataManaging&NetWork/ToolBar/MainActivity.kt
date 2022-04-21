package co.kr.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.kr.toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // toolbar를 액션바 대신 사용하도록 설정
        setSupportActionBar(r.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> r.textView.text = "메뉴 1 누름"
            R.id.item2 -> r.textView.text = "메뉴 2 누름"
            R.id.item3 -> r.textView.text = "메뉴 3 누름"

        }


        return super.onOptionsItemSelected(item)
    }
}
