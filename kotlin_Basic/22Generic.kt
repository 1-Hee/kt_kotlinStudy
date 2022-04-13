fun main() {

    val t1 = TestClass1<Int>();
    t1.testMethod1(100);

    val t2 = TestClass1<String>();
    t2.testMethod1("hello")

    val t22 = TestClass1<Double>()
    t22.testMethod1(31.55)

    println("-------------------")

    val t3 = TestClass2<Int>(100)
    t3.testMethod2(200);

    val t4 = TestClass2<String>("String1")
    t4.testMethod2("String2")

    println("-------------------")

    val t5 = TestClass3<Int, String>()
    t5.testMethod(100, "hello")

    println("-------------------")

    val t6 = TestClass4<Int, Double, String, Boolean>(100, 11.11)
    t6.testMethod4("문자열", true)

    println("-------------------")

    val t7:TestClass5<SubClass1> = TestClass5<SubClass1>() //
    // 상속이 되더라도 같은 제네릭에만 담을수 있다. 아래와 같이 부모 클래스로 자료타입 대체 불가
    //val t8:TestClass5<SubClass2> = TestClass5<SubClass1>()
    //val t9:SuperClass1<SuperClass1> = TestClass5<SubClass1>()

    val t10:TestClass6<SubClass1> = TestClass6<SubClass1>()
//    val t11:TestClass6<SubClass2> = TestClass6<SubClass1>() // 자식은 안됌
    val t12:TestClass6<SuperClass1> = TestClass6<SubClass1>() // 공변성, 부모는 됨

    val t13:TestClass7<SubClass1> = TestClass7<SubClass1>()
    val t14:TestClass7<SubClass2> = TestClass7<SubClass1>() // 자식이 됌
//    val t15:TestClass7<SuperClass1> = TestClass7<SubClass1>()  //부모가 안됌, 반공변성



}

class TestClass1<T>{
    fun testMethod1(a1:T){
        println("a1 $a1")
    }
}

class TestClass2<T>(var a1: T){
    fun testMethod2(a2:T){
        println("a1 $a1")
        println("a2 $a2")
    }
}

class TestClass3<A, B>{
    fun testMethod(a1:A, a2:B){
        println("a1 $a1")
        println("a2 $a2")
    }
}

class TestClass4<A, B, C, D>(var a1:A, var a2:B){
    fun testMethod4(a3:C, a4:D){
        println("a1 $a1")
        println("a2 $a2")
        println("a3 $a3")
        println("a4 $a4")
    }
}

open class SuperClass1

open class SubClass1 : SuperClass1()

class SubClass2 :SubClass1()

class TestClass5<A>() // 불변성

class TestClass6<out A>() // 공변성

class TestClass7<in A>() // 반공변성
