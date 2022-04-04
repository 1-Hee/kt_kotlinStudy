fun main() {

    var obj1:SubClass1 = SubClass1()
    println(obj1.subA1)
    obj1.subMethod1()

    println(obj1.superA1)
    obj1.subMethod1()

    println("----------------------")

    var obj2:SuperClass1 = obj1
    println(obj2.superA1)
    obj2.superMethod1()

//    println(obj2.subA1)
//    obj2.subMethod1()

    println("----------------------")
    val obj3:SubClass2 = SubClass2()
    obj3.superMethod2()

    val obj4:SuperClass2 = obj3
    obj4.superMethod2()
    println("----------------------")
    val obj5:SuperClass3 = SuperClass3()
    overrridngTest(obj5)

    val obj6:SubClass3 = SubClass3()
    overrridngTest(obj6)


}

open class SuperClass1{
    var superA1 = 100
    fun superMethod1(){
        println("superclass supermethod1")
    }
}

class SubClass1 : SuperClass1(){
    var subA1 = 200
    fun subMethod1(){
        println("submethod1")
    }
}

open class SuperClass2{
    open fun superMethod2(){
        println("sp2의 method2")
    }
}

class SubClass2 : SuperClass2(){
    override fun superMethod2(){
        println("SubClass2의 superMethod")
    }

}

open class SuperClass3 {
    open fun superMethod3(){
        println("super method의 sm3")
    }
}

class SubClass3: SuperClass3(){
    override fun superMethod3() {
        super.superMethod3()
        println("subClass의 super3")
     }
}

fun overrridngTest(obj1:SuperClass3){
    obj1.superMethod3()
}


