package co.kr.activityaction

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.activityaction.databinding.ActivityMainBinding
import java.net.URI
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val permissionList = arrayOf(
        android.Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(b.root)

        requestPermissions(permissionList, 0)

        b.button.setOnClickListener {
/*            val uri = Uri.parse("geo:37.243243, 131.861601")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

            // 버전이 안맞는지 구글 지도가 실행이 안됨, 다른 방법을 찾아서 수정하던지 해야할듯...
 */
        }

        b.button2.setOnClickListener {
            val uri = Uri.parse("http://www.naver.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        b.button3.setOnClickListener {
            val uri = Uri.parse("tel:01233509918")
            val intent =Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        b.button4.setOnClickListener {
            val uri = Uri.parse("tel:01233509918")
            val intent =Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }
}