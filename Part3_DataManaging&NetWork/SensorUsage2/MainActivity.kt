package co.kr.sensorusage2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.sensorusage2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val mananger = getSystemService(SENSOR_SERVICE) as SensorManager

        val ls1 = object : SensorEventListener {
            override fun onSensorChanged(p0: SensorEvent?) {
                when(p0?.sensor?.type){
                    Sensor.TYPE_ACCELEROMETER -> {
                        r.textView.text = "x축 기울기 : ${p0.values[0]}"
                        r.textView2.text = "y축 기울기 : ${p0.values[1]}"
                        r.textView3.text = "z축 기울기 : ${p0.values[2]}"
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        r.textView.text = "x축 주변 자기장 : ${p0.values[0]}"
                        r.textView2.text = "y축 주변 자기장 : ${p0.values[1]}"
                        r.textView3.text = "z축 주변 자기장 : ${p0.values[2]}"
                    }
                }
            }

            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            }
        }

        r.button.setOnClickListener {
            val sensor = mananger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            val chk = mananger.registerListener(ls1 ,sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk==false){
                r.textView.text = " 가속도 센서를 지원하지 않습니다"
            }
        }

        r.button2.setOnClickListener {
            mananger.unregisterListener(ls1)
            r.textView.text =""
            r.textView2.text =""
            r.textView3.text =""
        }

        r.button3.setOnClickListener {
            val sensor = mananger.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
            val chk = mananger.registerListener(ls1, sensor, SensorManager.SENSOR_DELAY_UI)
            if(chk == false) r.textView.text ="마그네틱 필트 센서를 지원하지 않습니다"
        }

        r.button4.setOnClickListener {
            mananger.unregisterListener(ls1)
            r.textView.text =""
            r.textView2.text =""
            r.textView3.text =""
        }



    }
}