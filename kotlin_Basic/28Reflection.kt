import kotlin.reflect.KClass

fun main() {

    //클래스 타입


    val a1: KClass<String> = String::class
    val a2: Class<String> = String::class.java

    println(String::class)
    println(String::class.java)

    println("------------------------")

    println(a1)
    println(a2)
    println("------------------------")
    val str1: String = "Hello"
    val a3: KClass<out String> = str1::class
    val a4: Class<out String> = str1::class.java
    println(a3)
    println(a4)
    println("------------------------")

    val a5: KClass<*> = str1::class
    val a6: Class<*> = str1::class.java
    println(a5)
    println(a6)
    println("------------------------")

    val test1: TestClass = TestClass()
    val a7: KClass<*> = test1::class
    val a8: Class<*> = test1::class.java
    println(a7)
    println(a8)

    // 클래스 정보 분석
    println("추상클래스 인가 ${test1::class.isAbstract}")
    println("Companion ${test1::class.isCompanion}")
    println("data? : ${test1::class.isData}")
    println("final? : ${test1::class.isFinal}")
    println("open? : ${test1::class.isOpen}")
    println("Inner? : ${test1::class.isInner}")
    println("Sealed? : ${test1::class.isSealed}")

    val constructors = test1::class.constructors
    println(constructors)

    for (con in constructors) {
        println("constructors : $con")

        for (param in con.parameters) {
            println("pararmeter index : ${param.index}")
            println("pararmeter type : ${param.type}")
            println("pararmeter name : ${param.name}") // 변수 이름
        }
    }

    /*
    val primaryCon = test1::class.primaryConstructor
    if (primaryCon != null) {
        println(primaryCon)

        for (param in primaryCon.parameters) {
            println("parameter index : ${param.index}")
            println("parameter type : ${param.type}")
            println("parameter name : ${param.name}")

        }
    }

    // 프로퍼티
    val properties = test1::class.declareMemberProperties
    for(prop in properties){
        println(prop.name)
    }

    // 메서드 정보
    val method = test1::class.declareMemberFunctions

    for (met in method){
        println(met.name)
    }

     */




    // 지금 코틀린 메인 파일이 하나가 아니라 그런지 코틀린 리플렉션이 사용이 안됨
    // 그냥 코드 받아적었으므로 나중에 필요하면 다른 파일에 복붙해서 확인해보기기

}

class TestClass() {
    val number1 = 100;
    val number2 = 200

    constructor(a1:Int) :this() {

    }

    fun testMethod1(){

    }


}