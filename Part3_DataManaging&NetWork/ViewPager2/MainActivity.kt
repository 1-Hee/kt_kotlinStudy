package co.kr.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.kr.viewpager2.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    val r by lazy{ActivityMainBinding.inflate(layoutInflater)}

    val frag1 = SubFragment1()
    val frag2 = SubFragment2()
    val frag3 = SubFragment3()

    val fragList = arrayOf(frag1, frag2, frag3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        setActionBar(r.toolbar)

        val adapter1 = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragList[position]
            }
        }

        r.pager2.adapter = adapter1


    }
}