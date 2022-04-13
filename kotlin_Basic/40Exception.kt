import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException

fun main() {
    try{
        // val a1 =10/0
        //val str:String? = null
        // println(str!!.length)

        val str2 = "안녕하세요"
        val a2:Int = str2.toInt()
        println("a2: $a2")
    }catch (e:ArithmeticException){
        println("수학적 오류가 발생")
    }catch (e:NullPointerException){
        println("null 오류 발생")
    }catch (e:Exception){
        println("예외 발생")
        // 예외에 대한 자세한 정보를 보고 싶으면 아래의 코드를 작성하면 됌
        e.printStackTrace()
    }

    println("이 부분이 수행될까요?")

}