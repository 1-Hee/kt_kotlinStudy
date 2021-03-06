package co.kr.actionbarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //HomeButton 메뉴를 활성화한다
        supportActionBar?.setHomeButtonEnabled(true)
        //HomeButton을 노출시킨다
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //HomeButton의 아이콘을 설정
        // supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_launcher)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}