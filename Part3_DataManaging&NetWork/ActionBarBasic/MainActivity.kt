package co.kr.actionbarbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.kr.actionbarbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> r.textView.text = "첫번째 메뉴"
            R.id.item2 -> r.textView.text = "두번째 메뉴"
            R.id.item3 -> r.textView.text = "세번째 메뉴"
            R.id.item4 -> r.textView.text = "네번째 메뉴"
        }


        return super.onOptionsItemSelected(item)
    }
}