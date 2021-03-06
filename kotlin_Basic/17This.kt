fun main() {

    var obj1 = TestClass001()
    obj1.testMethod1()

    var obj2 = subClass()
    obj2.subMethod()




}


class TestClass001(var a2:Int) {
    constructor() : this(100){

    }
    var a1 = 100
    fun testMethod1(){

        var a1 = 200
        println("a1 : $a1")
        println("a1(this) : ${this.a1}")

        fun testMethod2(){
            println("inside testMethod2")
        }

        testMethod2()
        this.testMethod2()
    }

    fun testMethod2(){
        println("Outside testMethod2")
    }

}

open class SuperClass01(var a2:Int) {
    open var a1 = 100

    open fun superMethod1(){
        println("superClass의 supermethod1")
    }
}

class subClass :SuperClass01(100){

    override var a1 = 1000

    fun subMethod(){
        println("a1 : $a1")
        println("a1(super): ${super.a1}")

        superMethod1()
        super.superMethod1()
    }

    override fun superMethod1(){
        println("subClass의 superMethod1")

    }
}

class SubClass02 : SuperClass01 {

    constructor(a1:Int) :super(a1) {

    }

    constructor(a1:Int, a2:Int) :super(a1) {

    }

}