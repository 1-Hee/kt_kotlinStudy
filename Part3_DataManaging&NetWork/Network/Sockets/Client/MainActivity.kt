package co.kr.socketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.kr.socketclient.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val r by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        r.button.setOnClickListener {
            thread {
                //서버에 접속한다.
                val socket = Socket("192.168.0.5", 55555)
                Log.d("test", "$socket")


                // 서버로부터 데이터를 수신한다.
                val inputStream = socket.getInputStream()
                val dis = DataInputStream(inputStream)

                val v1 = dis.readInt()
                val v2 = dis.readDouble()
                val v3 = dis.readBoolean()
                val v4 = dis.readUTF()

                runOnUiThread{
                    r.textView.text = "v1 : $v1 \n"
                    r.textView.append("v2 : $v2 \n")
                    r.textView.append("v3 : $v3 \n")
                    r.textView.append("v4 : $v4 \n")
                }

                //서버로 데이터를 보낸다.
                val outputStream = socket.getOutputStream()
                val dos = DataOutputStream(outputStream)

                dos.writeInt(200)
                dos.writeDouble(22.22)
                dos.writeBoolean(false)
                dos.writeUTF("클라이언트가 보낸 문자열")


                socket.close()
            }
        }



    }
}