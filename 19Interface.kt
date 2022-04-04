fun main() {
    val obj1 = TestClass0001()
    val obj2 = TestClass0002()
    tsFunc1(obj1)
    tsFunc2(obj2)

    println("------------------")

    val obj3 = TC3()
    val obj4 = TC4()

    tsfFunc3(obj3)
    tsfFunc4(obj4)

    println("------------------")

    val obj5 = TC5()
    tsfFunc3(obj5)
    tsfFunc4(obj5)
}

open abstract class AbsClass1{
    open abstract fun absMethod1()
}

open abstract class AbsClass2{
    open abstract fun absMethod2()
}

fun tsFunc1(obj1:AbsClass1){
    obj1.absMethod1()
}

fun tsFunc2(obj2:AbsClass2){
    obj2.absMethod2()
}

class TestClass0001 : AbsClass1(){
    override fun absMethod1() {
        println("TestClass0001의 absmethod1")
    }
}

class TestClass0002 : AbsClass2(){
    override fun absMethod2() {
        println("TestClass0002의 absmethod2")

    }
}

interface Inter1 {
    fun Intermethod2()
    fun Intermethod1(){
        println("intermethod2")
    }
}

interface Inter2{
    fun Inter2Method1(){
        println("Inter2의 Method2")
    }

    fun Inter2Method2()
}


class TC3 : Inter1 {
    override fun Intermethod2() {
        println("TC3의 intermethod2")
    }
}

class TC4 : Inter2 {
    override fun Inter2Method2() {
        println("TC4의 intermethod2")
    }
}


fun tsfFunc3(obj1:Inter1){
    obj1.Intermethod1()
    obj1.Intermethod2()
}

fun tsfFunc4(obj2:Inter2){
    obj2.Inter2Method1()
    obj2.Inter2Method2()
}

class TC5 : Inter1, Inter2 {
    override fun Inter2Method2() {
        println("TC5의 Inter2Method2")
    }

    override fun Intermethod2() {
        println("TC5의 InterMethod2")
    }
}