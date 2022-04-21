package co.kr.toolbarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import co.kr.toolbarnavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val r by lazy{ActivitySecondBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(r.root)

        setSupportActionBar(r.toolbar2)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}