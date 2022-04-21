package co.kr.actionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import co.kr.actionview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    val data1 = arrayOf("aaaa", "bbbb", "cccc", "aabb", "ccdd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        r.list1.adapter = adapter

        // 검색어 기준으로 필터링 될 수 있도록 섲렁
        r.list1.isTextFilterEnabled =true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        //SearchView를 가지고 있는 메뉴 아이템 객체를 추출
        val item = menu?.findItem(R.id.item1)
        //SearchView 객체를 가지고 온다
        val search1 = item?.actionView as SearchView
        // 안내문구를 설정
        search1.queryHint = "검색어 입력"
        // 메뉴 아이템에 배치된 뷰가 접히거나 펼쳐질 때 반응하는 리스너
        val listener1 = object : MenuItem.OnActionExpandListener{
            // 접혔을 때 호출되는 메서드
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                r.textView.text = "접혀졌습니다"
                return true;
            }
            // 펼쳐졌을 때 호출
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                r.textView.text = "펼쳐졌습니다"
                return true;
            }
        }
        item.setOnActionExpandListener(listener1)

        //SearchView의 리스너
        val ls2 = object : SearchView.OnQueryTextListener{
            // 키보드 돋보기 버튼을 눌렀을 때 호출되는 메서드
            override fun onQueryTextSubmit(p0: String?): Boolean {
                r.textView.text =" 문자열 입력완료 "
                r.textView2.text ="입력완료 : $p0 "
                search1.clearFocus()
                return true

            }

            // SearchView 에 문자열을 입력할 때마다 호출되는 메서드
            override fun onQueryTextChange(p0: String?): Boolean {
                r.textView.text =" 문자열 입력중 "
                r.textView2.text ="입력 : $p0 "

                // SearchView에 입력한 내용을 ListView의 필터 문자열로 설정
                r.list1.setFilterText(p0)
                // 만약 설정한 문자열의 길이가 0이라면 문자열을 제거한다
                if(p0?.length==0) r.list1.clearTextFilter()

               return false

            }

        }

        search1.setOnQueryTextListener(ls2)

        return true
    }
}