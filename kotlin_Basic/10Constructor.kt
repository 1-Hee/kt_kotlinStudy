fun main() {

    val tc1 = TC1()

    println(tc1.a)
    println(tc1.b)

    println("----------------")

    val obj1 = TC2()
    println(obj1)
    println(obj1.v1)
    println(obj1.v1)

    val obj3 = TC2(100, 200)
    println(obj3)
    println(obj3.v1)
    println(obj3.v2)

    println("----------------")

    val obj4 = TC4(100 , 200)
    val obj5 = TC5(500, 100)
    println(obj4.a1)
    println(obj4.b1)
    println(obj5.a1)
    println(obj5.b1)

    println("----------------")
    val obj6 = TC6(100, 200)
    println(obj6.a)
    println(obj6.b)

    println("----------------")
    val obj7 = TC6(100)
    println(obj7.a)



}

//kotlin은 init이 있음
// 객체를 생성할때 자동동작 >> init
// 값을 초기화 >> constructor

class TC1{
    init {
        println("자동으로 동작합니다람쥐")
    }

    val a = 15
    var b = 16
}

class TC2 {
    var v1 = 0
    var v2 = 0
    constructor(){
        println("매개변수가 없는 생성자")
    }

    constructor(a:Int, b:Int){
        println("매개변수 두개지요")
        v1 = a
        v2 = b
    }
}

class TC4(var a1:Int, val b1:Int)
class TC5 constructor(var a1:Int, val b1:Int)

class TC6 (var a:Int, val b:Int){
    init {
        println("init")
        println(a)
        println(b)
    }

    constructor(a1:Int):this(a1, 100){ // 주생성자(67번줄)가 선언되어 있으면 보조생성자(constructor)에서 반드시 매개변수 가져와야함
        println("보조생성자 호출스")
    }
}