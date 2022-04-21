package co.kr.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.kr.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    // ViewPager에 세팅하기 위한 Fragment들을 가지고 있는 ArrayList
    val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setActionBar(r.toolbar)

        r.toolbar.setTitleTextColor(Color.WHITE)
        r.tabs.setTabTextColors(Color.LTGRAY, Color.BLACK)

        for(i in 0..9){
            val sub = SubFragment("$i 번째 프로그먼트")
            fragmentList.add(sub)
        }

        val adpater1 = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return  fragmentList[position]
            }
        }

        r.pager2.adapter = adpater1

        // tab과 View Pager를 연결한다.
        // TabLayoutMediator 메서드는 반드시 File  -> project structure에서 라이브러리 등록해야함
        // 라이브러리는 material이라고 검색해서 구글닷컴 메터리얼 뜨는거로 하면 됌
        TabLayoutMediator(r.tabs, r.pager2){tab, position ->
            tab.text = "탭 $position"
        }.attach()





    }
}