package co.kr.gpsusage

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import co.kr.gpsusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val permission_list = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        requestPermissions(permission_list, 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // 하나라도 권한이 거절되면 바로 종료
        for (r1 in grantResults) {
            if (r1 == PackageManager.PERMISSION_DENIED) {
                return
            }
        }
        // 위치 정보를 관리하는 매니저 추출함

        val manager = getSystemService(LOCATION_SERVICE) as LocationManager

        // 저장되어 있는 위치 정보 값을 가져옴
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) return


        val location1 = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val location2 = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        if(location1!=null) {
            showInfo(location1)
        } else if (location2!=null){
            showInfo(location2)
        }

        val ls = LocationListener{
            showInfo(it)
        }

        r.button.setOnClickListener {
            if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER) == true){
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, ls)
            }
            if(manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true){
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, ls)
            }
        }

        r.button2.setOnClickListener {
            manager.removeUpdates(ls)
        }

    }
    fun showInfo(location: Location){
        if(location!=null){
            r.textView.text = "Provider : ${location.provider}"
            r.textView2.text = "위도 : ${location.latitude}"
            r.textView3.text = "경도 : ${location.longitude}"

        }
    }

}