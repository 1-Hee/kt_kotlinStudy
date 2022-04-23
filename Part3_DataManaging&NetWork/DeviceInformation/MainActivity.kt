package co.kr.deviceinformation

import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import co.kr.deviceinformation.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    val permission_list = arrayOf(
        android.Manifest.permission.READ_PHONE_STATE,
        android.Manifest.permission.READ_SMS,
        android.Manifest.permission.READ_PHONE_NUMBERS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        requestPermissions(permission_list, 0)

        r.button.setOnClickListener {
            // TelephonyManager를 추출한다.
            val manager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_SMS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_PHONE_NUMBERS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) { r.textView.text = "권한을 허용해주세요"
            } else {
                r.textView.text =  "전화번호 : ${manager.line1Number} \n"
                r.textView.append("SIM 국가 코드 : ${manager.simCountryIso} \n")
                r.textView.append("모바일 국가 코드 + 모바일 네트워크 코드 : ${manager.simOperator} \n")
                r.textView.append("서비스 이름 : ${manager.simOperatorName} \n")
                r.textView.append("SIM 상태(통신 가능 여부, PIN LOCK 여부) ${manager.simState} \n")
                r.textView.append("음성 메일 번호(우리나라X) : ${manager.voiceMailNumber}")

            }
        }

        r.button2.setOnClickListener {
            r.textView.text = "보드이름 : ${Build.BOARD} \n"
            r.textView.append("소프트웨어를 커스터마이징한 회사 : ${Build.BRAND} \n")
            r.textView.append("제조사 디자인 명 : ${Build.DEVICE} \n")
            r.textView.append("사용자에게 표시되는 빌드 ID : ${Build.DISPLAY} \n")
            r.textView.append("빌드 고유 ID : ${Build.FINGERPRINT} \n")
            r.textView.append("ChangeList 번호 : ${Build.ID} \n")
            r.textView.append("제품/하드웨어 제조업체 : ${Build.MANUFACTURER} \n")
            r.textView.append("제폼 모델명 : ${Build.MODEL} \n")
            r.textView.append("제품명 : ${Build.PRODUCT} \n")
            r.textView.append("빌드 구분 : ${Build.TAGS} \n")
            r.textView.append("빌드 타입 : ${Build.TYPE} \n")
            r.textView.append("안드로이드 버전 : ${Build.VERSION.RELEASE} \n")
        }

        r.button3.setOnClickListener {
            val wm = getSystemService(WINDOW_SERVICE) as WindowManager
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                val matrix = wm.currentWindowMetrics
                val width = matrix.bounds.width()
                val height = matrix.bounds.height()

                r.textView.text = "width : ${width} \n height ${height} \n"
            } else {
                val display = wm.defaultDisplay
                val point = Point()
                display.getSize(point)
                r.textView.text = "width : ${point.x} \n height : ${point.y}"
            }

        }

    }
}