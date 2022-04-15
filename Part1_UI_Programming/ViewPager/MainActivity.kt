package co.kr.viewpager

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //ViewPager를 통해 보여줄 View들을 담을 리스트
    val viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view1 = layoutInflater.inflate(R.layout.view1, null)
        val view2 = layoutInflater.inflate(R.layout.view2, null)
        val view3 = layoutInflater.inflate(R.layout.view3, null)
        val view4 = layoutInflater.inflate(R.layout.view1, null)
        val view5 = layoutInflater.inflate(R.layout.view2, null)
        val view6 = layoutInflater.inflate(R.layout.view3, null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)
        viewList.add(view5)
        viewList.add(view6)
        pager1.adapter = adapter

    }

    val adapter = object : PagerAdapter(){
        // ViewPager가 보여줄 뷰의 개수
        override fun getCount(): Int {
            return viewList.size
        }

        // ViewPager가 보여줄 화면 View를 반환하는 메서드
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            pager1.addView(viewList[position])
            return super.instantiateItem(container, position)
        }

        // instantiateItem이 반환한 객체를 화면으로 사용할 것인가를 검사하는 메서드
        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view == obj
        }

        // 사라지는 View 객체를 소멸하는 메서드

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pager1.removeView(obj as View)
        }
    }
}