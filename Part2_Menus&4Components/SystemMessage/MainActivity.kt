package co.kr.systemmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.systemmessage.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val permissionList = arrayOf(
        android.Manifest.permission.RECEIVE_BOOT_COMPLETED,
        android.Manifest.permission.READ_PHONE_STATE,
        android.Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        requestPermissions(permissionList, 0)





    }
}