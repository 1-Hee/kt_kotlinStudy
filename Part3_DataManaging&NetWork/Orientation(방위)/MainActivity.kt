package co.kr.orientation

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.kr.orientation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        val ls = object : SensorEventListener {

            // 가속도 센서로부터 측정된 값을 담을 배열
            var accValue = FloatArray(3)
            // 자기장 센서로부터 측정된 값을 담을 배열
            var magValue =FloatArray(3)

            // 두 센서로 부터 값을 담아온 적 있는지 판단하는 변수
            var isGetAcc = false
            var isGetMag = false



            override fun onSensorChanged(p0: SensorEvent?) {

                when(p0?.sensor?.type){
                    Sensor.TYPE_ACCELEROMETER -> {
                        accValue[0] = p0?.values[0]
                        accValue[1] = p0?.values[1]
                        accValue[2] = p0?.values[2]
                        isGetAcc = true
                    }
                    Sensor.TYPE_MAGNETIC_FIELD ->{
                        magValue[0] = p0?.values[0]
                        magValue[1] = p0?.values[1]
                        magValue[2] = p0?.values[2]
                        isGetMag = true

                    }
                }

                if(isGetAcc==true && isGetMag == true){
                    //행렬 계산을 위해 사용할 배열
                    val R = FloatArray(9)
                    val I = FloatArray(9)
                    //행렬 계산을 한다
                    SensorManager.getRotationMatrix(R, I, accValue, magValue)
                    // 계산된 결과에서 방위 값을 추출한다.
                    val values = FloatArray(3)
                    SensorManager.getOrientation(R, values)
                    // 라디안 값을 각도 값으로 변경
                    var azimuth = Math.toDegrees(values[0].toDouble()).toFloat()
                    val pitch = Math.toDegrees(values[1].toDouble()).toFloat()
                    val roll = Math.toDegrees(values[2].toDouble()).toFloat()
                    if(azimuth<0){
                        azimuth += 360f
                    }
                    r.textView.text ="방위 값 : $azimuth"
                    r.textView2.text ="좌우 기울기 : $pitch"
                    r.textView3.text ="앞뒤 기울기 : $roll"

                    r.imageView.rotation = 360 - azimuth

                }

            }

            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            }
        }

        r.button.setOnClickListener {
            val sensor1 = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            val sensor2 = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

            manager.registerListener(ls, sensor1, SensorManager.SENSOR_DELAY_UI)
            manager.registerListener(ls, sensor2, SensorManager.SENSOR_DELAY_UI)

        }

        r.button2.setOnClickListener {
            manager.unregisterListener(ls)
        }



    }
}