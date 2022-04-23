package co.kr.sensorusage1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.sensorusage1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // 단말기의 센서들을 관리하는 객체를 추출
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        //센서에서 값을 가져오면 반응하는 리스너
        val ls1 = object : SensorEventListener {

            //센서로부터 측정된 값이 변경되었을 때 호출
            override fun onSensorChanged(p0: SensorEvent?) {
                // 센서 타입에 따라 분기
                when(p0?.sensor?.type){
                    Sensor.TYPE_LIGHT -> r.textView.text ="주변 밝기 : ${p0?.values[0]} lux"
                    Sensor.TYPE_PRESSURE -> r.textView.text ="현재 기압 : ${p0?.values[0]} millibar"
                    Sensor.TYPE_PROXIMITY -> r.textView.text ="물체와의 거리 : ${p0?.values[0]} cm"
                    Sensor.TYPE_GYROSCOPE -> {
                        r.textView.text = "X축 각속도 : ${p0?.values[0]}"
                        r.textView2.text = "Y축 각속도 : ${p0?.values[1]}"
                        r.textView3.text = "Z축 각속도 : ${p0?.values[2]}"
                    }

                }
            }

            // 센서의 감도가 변경되었을 때 호출
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            }
        }

        r.button.setOnClickListener {
            // 조도 센서 객체를 얻어옴
            val sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)

            // 조도 센서와 리스너를 연결한다.
            val chk = manager.registerListener(ls1, sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk == false) {
                r.textView.text = "조도 센서를 지원하지 않습니다."
            }
        }

        r.button2.setOnClickListener {
            manager.unregisterListener(ls1)
            r.textView.text ="TextView"
        }

        r.button3.setOnClickListener {
            val sensor = manager.getDefaultSensor(Sensor.TYPE_PRESSURE)
            val chk = manager.registerListener(ls1, sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk == false) {
                r.textView.text = "기압 센서를 지원하지 않습니다"
            }
        }

        r.button4.setOnClickListener {
            manager.unregisterListener(ls1)
            r.textView.text ="TextView"
        }

        r.button5.setOnClickListener {
            val sensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            val chk = manager.registerListener(ls1, sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk==false) {
                r.textView.text = "근접 센서를 지원하지 않습니다"
           }
        }

        r.button6.setOnClickListener {
            manager.unregisterListener(ls1)
            r.textView.text ="TextView"
        }

        r.button7.setOnClickListener {
            val sensor = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
            val chk = manager.registerListener(ls1, sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk == false){
                r.textView.text = "자이로스코프 센서를 지원하지 않습니다"
            }
        }

        r.button8.setOnClickListener {
            manager.unregisterListener(ls1)
            r.textView.text ="TextView"
            r.textView2.text ="TextView"
            r.textView3.text ="TextView"
        }


    }
}