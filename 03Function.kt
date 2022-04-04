fun main() {
    test1();
    test2(3, 3.14)

    val k1: Int = 100
    val k2: Double = 11.11
    test2(k1, k2)

    test2(50, 500.2)
    test2(a2 = 66.6, a1 = 600)

    println("----------------")

    test3(100, 100.1)
    test3(100)
    test3(a2 = 33.3)

    var r1: Int = test4(100, 200)
    var r2: Int = test4(1000, 2000)

    println("r1 : $r1")
    println("r2 : $r2")

    test5()
    test6()

    println("----------------")
    test7()
    test7(1)
    test7(3.1)
    test7(1, 3)

    println("----------------")

    test8()

}


fun test1() {
    println("test1 is called")
}

fun test2(a1:Int, a2:Double){
    println(a1)
    println(a2)
    println("this value comes from test2")
}

fun test3 (a1:Int=0, a2:Double=0.00) {
    println(a1)
    println(a2)
    println("this value comes from test3")
}

fun test4 (a1:Int=0, a2:Int) : Int {

    return a1 + a2

}

fun test5() :Unit { // unit은 생략 가능
    println("-")
    println("this value comes from test5")

}

fun test6(){
    println("-")
    println("this value comes from test6")

}

// overloading, 매개변수의 형태를 다르게 하여 같은 이름으로 여러 함수를 정의
fun test7(){
    println("매개변수 없음")
}

fun test7(a1:Int){
    println("매개변수 있음 : $a1")
}

fun test7(a1:Double){
    println("매개변수  : $a1")
}

fun test7(a1:Int, a2:Int){
    println("매개변수 있음 : $a1 , $a2")
}

// 지역변수, 지역함수
fun test8() {
    println("test8")
    fun test9(){ // 메인에서 호출 불가
        println("test9")
    }
    test9()
}