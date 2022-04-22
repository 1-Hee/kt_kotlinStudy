package co.kr.filedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import co.kr.filedata.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    val r by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 내부저장소의 앱 데이터 디렉토리의 경로
    lateinit var file_path: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(r.root)

        // null : 앱 데이터 폴더의 경로를 얻어오고
        // Environment.DIRECTORY_종류 : 해당 종류의 경로 얻어옴

        file_path = getExternalFilesDir(null).toString()
        Log.d("test", file_path)



        r.button2.setOnClickListener {
            // MODE_PRIVATE 덮어쓰기
            // MODE_APPEND 이어쓰기
            val fos = openFileOutput("data1.dat", Context.MODE_PRIVATE)
            val dos = DataOutputStream(fos)
            //데이터를 쓴다
            dos.writeInt(100)
            dos.writeDouble(11.11)
            dos.writeBoolean(true)
            dos.writeUTF("문자열1")

            dos.flush()
            dos.close()

            r.textView.text = "내부 저장소 쓰기 완료"
        }

        r.button3.setOnClickListener {
            val fis = openFileInput("data1.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()
            dis.close()

            r.textView.text = "data1 : $data1 \n"
            r.textView.append("data2 : $data2 \n")
            r.textView.append("data3 : $data3 \n")
            r.textView.append("data4 : $data4 ")
        }

        r.button4.setOnClickListener {
            var fos = FileOutputStream("$file_path/data2.dat")
            val dos = DataOutputStream(fos)
            dos.writeInt(200)
            dos.writeDouble(22.22)
            dos.writeBoolean(false)
            dos.writeUTF("문자열2")

            dos.flush()
            dos.close()

            r.textView.text = "외부저장소의 앱 데이터 폴더에 저장"
        }

        r.button5.setOnClickListener {
            val fis = FileInputStream("$file_path/data2.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()
            dis.close()

            r.textView.text = "data1 : $data1 \n"
            r.textView.append("data2 : $data2 \n")
            r.textView.append("data3 : $data3 \n")
            r.textView.append("data4 : $data4 ")

        }

        r.button6.setOnClickListener {
            // 파일 관리 앱의 액티비티를 실행
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT) // 파일 생성
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE) // 파일 열기
            fileIntent.type = "*/*"
//            fileIntent.type = "image/*"
            startActivityForResult(fileIntent, 100)

        }

        r.button7.setOnClickListener {
            // 파일 관리 앱의 액티비티 실행
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent, 200)
        }

    }

    // 6개의 버튼 중에서 5번째 여섯번째 버튼은 기능이 정상적으로 안됨
    // 오류1 : 버튼 5에서 파일 저장후 앱으로 돌아오면 텍스트뷰 안변함
    // 오류2 : 버튼 6에서 파일 읽어오면 텍스트뷰 안변함
    // 아마 onActivityResult를 대체할 방법이 있으면 그걸로 시도해봐야할듯
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == 100){
            if(resultCode == RESULT_OK){
                val des1 = contentResolver.openFileDescriptor(data?.data!!, "w")
                val fos = FileOutputStream(des1?.fileDescriptor)
                val dos = DataOutputStream(fos)

                dos.writeInt(300)
                dos.writeDouble(33.33)
                dos.writeBoolean(true)
                dos.writeUTF("문자열3")

                dos.flush()
                dos.close()

                r.textView.text = "다운로드 폴더에 저장"

            }
        } else if(resultCode == 200) {
            if (resultCode == RESULT_OK) {
                val des2 = contentResolver.openFileDescriptor(data?.data!!, "r")
                val fis = FileInputStream(des2?.fileDescriptor)
                val dis = DataInputStream(fis)

                val data1 = data?.getIntExtra("data3.dat", 0)
//                val data2 = dis.readDouble()
//                val data3 = dis.readBoolean()
//                val data4 = dis.readUTF()
                dis.close()

                r.textView.text = "data1 : $data1 \n"
//                r.textView.append("data2 : $data2 \n")
//                r.textView.append("data3 : $data3 \n")
//                r.textView.append("data4 : $data4 ")

            }
        }

    }
}
