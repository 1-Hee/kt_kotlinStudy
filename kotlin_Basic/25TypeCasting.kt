import Inter1 as Inter1

fun main() {

    val obj1:SubClass1 = SubClass1()
    val obj2:SubClass2 = SubClass2()

    // 부모클래스 타입 참조변수에 담기
    val super1:SuperClass1 = obj1 // superclass를 상속했으므로 자식 클래스로 스마트캐스팅 성공
    // 스마트 캐스팅 발생
    val inter1: Inter1 = obj2

//    val obj3:SubClass1 = super1 // 경우의 수가 두가지인데 컴퓨터는 "추론"으로 스마트 캐스팅을 하지 못함!
//    val obj4:SubClass2 = inter1

    println("-------------------")
    // as : 지정된 클래스 타입으로 강제 형변환 연산자
    super1 as SubClass1
    inter1 as SubClass2
    super1.subM1()
    inter1.subM2()

//    inter1 as SubClass1 // 오류남, 전혀 관계없는(상속관계가 아닌) 경우에는 오류 발생시킴

    println("-------------------")

    val obj5:SubClass1 = SubClass1()
    val chk1 = obj5 is SuperClass1
//    val chk2 = obj5 is Inter1 // is 연산자는 전혀 관계없는(상속관계가 아닌) 경우의 참 거짓을 판단 하는 것이 아님
    println("chk : $chk1")

    // 아래처럼 is 연산자는 상속관계가 있을 때,
    // 해당 변수 수준에서 부모클래스라면 자식클래스, 자식클래스라면 부모클래스와의 관계를 따져 값을 리턴
    val super3:SuperClass1 = obj5
    val chk3 = super3 is SubClass1
    println("chk3 : $chk3")

    if(super3 is SubClass1){
        // super3 as SubClass1
            // is 연산자 값이 true라면 형변환이 가능한 상황이므로 자동으로 스마트 캐스팅이 됨 따라서 38번줄에서 이미 39번줄의 기능을 함
        super3.subM1()
    }
//    super3.subM1() // if문 내부가 아니므로 형변환 불가, 스마트캐스팅 x 이므로 오류 발생

    println("---------------------")
    val obj10:SubClass1 = SubClass1()
    val obj11:SubClass2 = SubClass2()
    anyMethod(obj10)
    anyMethod(obj11)
    anyMethod(11)
    anyMethod("문자열")

    println("---------------------")

    val number1:Int =100
    val number2:Long = number1.toLong()
    println(number2)

    val str1:String = "100"
    val number3:Int = str1.toInt()
    println(number3)

//    val str2:String = "안녕하세요" // 형변환 불가!
//    val number4:Int = str2.toInt()
//    println(number4)

}

open class SuperClass1
interface Inter1

class SubClass1 : SuperClass1(){
    fun subM1(){
        println("subM1")
    }
}
class SubClass2 : Inter1 {
    fun subM2(){
        println("subM2")
    }

}

fun anyMethod(obj:Any){
    if (obj is SubClass1){
        obj.subM1()
        println(obj.javaClass) // 클래스 타입을 확인
    } else if (obj is SubClass2){
        obj.subM2()

    } else if (obj is Int){
        println("obj에 정수 값이 입력")

    } else if (obj is String){
        println("obj에 문자열이 입력")
    }



}