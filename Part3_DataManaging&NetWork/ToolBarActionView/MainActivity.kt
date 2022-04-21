package co.kr.toolbaractionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import co.kr.toolbaractionview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    val datalist = arrayOf("aaaa", "bbbb", "cccc", "dddd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setSupportActionBar(r.toolbar)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist)
        r.list1.adapter = adapter
        r.list1.isTextFilterEnabled = true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val item = menu?.findItem(R.id.item1)
        val search1 = item?.actionView as SearchView
        search1.queryHint = "검색어 입력"

        // 액션뷰가 접혀지거나 펼쳐졌을 때 반응할 리스너
        val ls1 = object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                r.textView.text = "접혀졌습니다"
                return true
            }

            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                r.textView.text = "펴졌습니다"
                return true

            }
        }
        item.setOnActionExpandListener(ls1)

        val ls2 = object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(p0: String?): Boolean {
                r.textView.text = "입력 중입니다"
                r.textView2.text = "입력중 : $p0"
                r.list1.setFilterText(p0)
                if(p0?.length ==0) r.list1.clearTextFilter()
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                r.textView.text = "입력 완료"
                r.textView2.text = "입력완료 : $p0"
                search1.clearFocus()
                return true

            }
        }
        search1.setOnQueryTextListener(ls2)

        return true
    }
}