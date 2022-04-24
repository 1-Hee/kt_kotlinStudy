import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket

fun main() {

    // 서버 역할을 하기 위한 객체를 생성
    val server = ServerSocket(55555)
    println("사용자 접속 대기")
    val socket = server.accept()
    println(socket)

    // 클라이언트로 데이터를 보낸다.
    val outputStream = socket.getOutputStream()
    val dos = DataOutputStream(outputStream)

    dos.writeInt(100)
    dos.writeDouble(11.11)
    dos.writeBoolean(true)
    dos.writeUTF("서버가 보낸 문자열")

    // 클라이언트로부터 데이터를 수신한다.
    val inputStream = socket.getInputStream()
    val dis = DataInputStream(inputStream)

    val v1 = dis.readInt()
    val v2 = dis.readDouble()
    val v3 = dis.readBoolean()
    val v4 = dis.readUTF()

    println("v1 : $v1")
    println("v2 : $v2")
    println("v3 : $v3")
    println("v4 : $v4")


    //서버를 종료한다.
    socket.close()

}