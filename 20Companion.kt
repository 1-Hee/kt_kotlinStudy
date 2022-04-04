fun main() {

    val obj1 = TestClass()
    println(obj1.a1)
    obj1.testFunc1()


    val obj2 = TestClass()
    println(obj2.a1)
    obj2.testFunc1()

    obj1.a1 = 200;
    println(obj1.a1)
    println(obj2.a1)

    //println(obj1.a2); // 자바에서는 이런식으로 static이 사용 가능한데 코틀린에서는 엄격하게 금지됨
    //obj1.testFunc2();

    println(TestClass.a2)
    TestClass.testFunc2()

    println("--------------------")
    val object3 = JavaMain()
    println("obj3.javaA1:${object3.javaA1}")

    object3.javaMethod1()

    println("javaMain.javaA1 : ${JavaMain.javaA2}")
    JavaMain.javaMethod2()


}

class TestClass{
    var a1:Int = 100

    companion object {
        var a2 = 1000

        @JvmStatic var a3 = 2000;

        fun testFunc2(){
            println("testFunc2")
            //println(a1)
            println(a2)

        }

        @JvmStatic fun testFunc3(){
            println("testFunc3")
        }
    }

    fun testFunc1(){
        println("testFunc1")
        println(a1)
        println(a2)
        testFunc2()
    }
}