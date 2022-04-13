fun main() {

    var obj1 = TestClass1(100, 200)
    var obj2 = TestClass2(100, 200)

    println(obj1.a1)
    println(obj1.a2)

    println(obj2.a1)
    println(obj2.a2)

    var obj3 = TestClass1(
        100,
        200,
        300,
    )
    var obj4 = TestClass2(100, 200, 300)
    println(obj3.a1)
    println(obj3.a2)
    println(obj3.a3)

    println(obj4.a1)
    println(obj4.a2)
    println(obj4.a3)

    obj3.TestMethod1()
    obj4.TestMethod2()

    println("--------------------------")

    var obj5 = TestClass1(100, 200, 300)
    var obj6 = TestClass1(100, 200,300)
    if(obj5==obj6){
        println("obj5, obj6 두 객체는 같습니다")
    } else {
        println("obj5, obj6 두 객체는 다릅니다")
    }

    var obj7 = TestClass2(100, 200, 300)
    var obj8 = TestClass2(100, 200, 300)
    if(obj7==obj8){
        println("obj7, obj8 두 객체는 같습니다")
    } else {
        println("obj7, obj8 두 객체는 다릅니다")
    }

    println("--------------------------")
//    val obj9 = obj5.copy() // 클래스이므로 오버라이딩 되어 있지 않음
    val obj10 = obj7.copy()
    println("obj10.a1 : ${obj10.a1}")
    println("obj10.a1 : ${obj10.a2}")

    obj10.a1 = 1000;
    println(obj7.a1)
    println(obj10.a1)

    println("--------------------------")

    var str1 = obj5.toString();
    var str2 = obj7.toString()
    println(str1)
    println(str2)

    println("--------------------------")


    var num1 = obj7.component1()
    var num2 = obj7.component2()
    println(num1)
    println(num2)

    println("--------------------------")

    var obj11 = TestClass3(100, 200, 300)
    val num3= obj11.component1()
    val num4 = obj11.component2()
    val num5 = obj11.component3()

    println("$num3 \n$num4 \n$num5 ")
    println("--------------------------")

    val(num10, num11) = obj11;
    println("num10 : $num10, num11 : $num11")

    val(num12, num13, num14) = obj11
    println("num12 $num12 / num13 $num13 / num14 $num14")



}



class TestClass1(var a1:Int, var a2:Int){


   var a3:Int = 0;
    init{
        println("testClass1의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int):this(a1,a2){
        this.a3 = a3
    }

    fun TestMethod1(){
        println("TestClass1의 TestMethod1")
    }

}

data class TestClass2(var a1:Int, var a2:Int){

    var a3:Int = 0

    init{
        println("testClass2의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int):this(a1,a2){
        this.a3 = a3
    }
    fun TestMethod2(){
        println("TestClass2의 TestMethod2")
    }

}

data class TestClass3(var a1:Int, var a2:Int, var a3:Int)

