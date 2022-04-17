package co.kr.systemmessage

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        when(intent.action){
            "android.intent.action.BOOT_COMPLETED" -> {
                val t1 = Toast.makeText(context, "부팅완료", Toast.LENGTH_LONG)
                t1.show()
            }

            "android.provider.Telephony.SMS_RECEIVED" ->{
                if(intent.extras != null){
                    // 문자 메세지 정보 객체를 추출한다.
                    val pduObject = intent.extras?.get("pdus") as Array<Any?>
                    if(pduObject != null) {
                        // 문자 메세지는 짧은건 SMS, 긴건 MMS로 변환되서 오는데,
                            // 현재 MMS 지원 안하는 기기는 없음
                                // 그러나 값이 배열로 오기에 반복문이 필요하지만,
                                    // 경우에 따라서는 그냥 첫번째 요소 값만 추출해도 되긴 함
                        for (obj in pduObject){
                            // 문자 메세지 양식 객체를 추출한다.
                            val format = intent.extras?.getString("format")
                            // 문자 메세지 객체를 생성한다.
                            val currentSMS = SmsMessage.createFromPdu(obj as ByteArray?, format)
                            // 정보 추출
                            val showMessage = "전화번호 : ${currentSMS.displayOriginatingAddress}\n 내용 : ${currentSMS.displayMessageBody}"
                            val t1 = Toast.makeText(context, showMessage, Toast.LENGTH_SHORT)
                            t1.show()
                        }
                    }
                }
            }
        }

     }
}