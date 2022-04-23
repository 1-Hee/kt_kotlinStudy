package co.kr.androidsensor

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.androidsensor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // 센서를 관리하는 매니저를 추출
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        // 단말기에 있는 센서 리스트를 가져온다.
        val sensor_list = manager.getSensorList(Sensor.TYPE_ALL)

        r.textView.text = ""
        //센서 수 만큼 반복한다.
        for(s in sensor_list){
            r.textView.append("센서 이름 : ${s.name} \n")
            r.textView.append("센서 종류 : ${s.name} \n\n")
        }



    }
}