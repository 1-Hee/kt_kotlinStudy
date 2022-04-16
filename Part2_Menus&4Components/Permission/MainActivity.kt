package co.kr.permission

import android.app.ActivityManager
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    val permission_list = arrayOf(
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = ""
        for(permission in permission_list){
            // 권한 허용 여부 확인
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_GRANTED){
                textView.append("$permission : 허용 \n" )
            } else {
                textView.append("$permission : 거부 \n" )
            }
        }

        // requestPermissions에서 requestCode는 분기할때 사용 가능함.
        // onRequestPermissionsResult 메서드에서
        // super.onRequestPermissionsResult의 requestCode와 짝을 맞춰서 분기 가능
        button.setOnClickListener{
            // 거부 되어 있는 권한들을 사용자에게 확인 받음
            requestPermissions(permission_list, 0)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )  {
        for(idx in grantResults.indices) {//indices >> size와 비슷한 기능
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED){
                textView.append("${permissions[idx]} : 허용 \n ")
            } else if (grantResults[idx] == PackageManager.PERMISSION_DENIED){
                textView.append("${permissions[idx]} : 거부 \n ")
            }
        }
    }
}

