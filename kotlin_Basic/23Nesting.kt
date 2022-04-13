fun main() {

    val obj1 = Outer1()
    val obj2 = obj1.Inner1()

    obj2.innerMethod2()
    obj1.outerMethod2()

    println("--------------")
    val t1= TestClass2()
    t1.testMethod1()

    val t2= TestClass3()
    t2.interMethod1()

    val t3 = object : TestClass1(){
        override fun testMethod1() {
            println("익명 중첩 클래스의 testMethod1")
        }
    }

    t3.testMethod1()

    val t4 = object : TestInter1 {
        override fun interMethod1() {
            println("익명 중첩 클래스의 interMethod1")
        }
    }
    t4.interMethod1()




}

class Outer1 {

    val OuterMember1 = 100

    fun outerMethod(){
        println("Outer Method")
    }

    fun outerMethod2(){
//        println($innerMember1)
        // innerMethod1()

        val obj3 = Inner1()
        println(obj3.innerMember1)
        obj3.innerMethod1()
    }

    inner class Inner1{
        val innerMember1 = 200

        fun innerMethod1(){
            println("inner Method1")
        }
        fun innerMethod2(){
            println("$OuterMember1")
            outerMethod()
        }

    }
}

abstract class TestClass1{
    abstract fun testMethod1()
}

interface TestInter1{
    fun interMethod1()
}

class TestClass2 : TestClass1() {
    override fun testMethod1() {
        println("TestClass2 의 testMethod1")
    }
}

class TestClass3 : TestInter1 {
    override fun interMethod1() {
        println("TestClass3의 interMethod1")
    }
}