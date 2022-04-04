fun main() {

    val obj1 = TestClass1(100, 200)
    println(obj1.a1)
    println(obj1.a2)
    obj1.a1 = 1000
    println(obj1.a1)

    println("-------------------")
    val obj2 = TestClass2()
    obj2.v1 = 100

    println(obj2.v1)
    println(obj2.v2)

    obj2.v3 = 200
    println(obj2.v3)

    println("-------------------")





}


class TestClass1 (var a1:Int, var a2:Int){ // 주생성자에서 생성한 멤버변수는 보조생성자에서 생성 불가
//    constructor(a1:Int, a2:Int,)
}


class TestClass2 {
    var v1:Int = 0
    val v2:Int = 0
    var v3:Int = 0
    //    get() = field // 상위 변수 여기서는 v3를 의미, get과 같은 의미
        get(){
            println("get")
            return field
        }
        set(value){
            println("set")
            field = value
        }

}