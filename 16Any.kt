fun main() {

    val obj1 = TestClass01()
    println(obj1)

    val obj2 = TestClass02()
    val obj3 = TestClass03()

    testFunc1(obj1)
    testFunc1(obj2)
    testFunc1(obj3)

}

class TestClass01 {
    override fun toString(): String {
        return "TestClass1의 객체입니다"
    }
}

class TestClass02 {
    override fun toString(): String {
        return "TestClass2의 객체입니다"
    }
}

class TestClass03{
    override fun toString(): String {
        return "TestClass3의 객체입니다"
    }
}

fun testFunc1(a1:Any){
    println("a1 : $a1")
}