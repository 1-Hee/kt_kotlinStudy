fun main() {
    val obj1 = TestClass1()
    println(obj1)

    val obj2 = TestClass1()
    println(obj2)

    val obj3 = obj1
    println(obj3)

    val obj4 = TestClass2()
    println(obj4)

    val obj5 = TestClass3()
    println("obj5.a : ${obj5.a}")
    println("obj5.b : ${obj5.b}")

    obj5.testmethod1()
    obj5.testmethod2()
    println("obj5.b : ${obj5.testmethod1()}")
    println("obj5.b : ${obj5.testmethod2()}")

}

class TestClass1{

}

class TestClass2

class TestClass3 {
    val a= 10;
    val b=12;

    fun testmethod1(){
        println("tm1")
    }
    fun testmethod2(){
        println("tm2")
    }

}