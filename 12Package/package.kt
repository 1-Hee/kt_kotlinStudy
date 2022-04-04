import kr.co.pkg1.jo.TestClass2
import kr.co.pkg1.jo.tsFunc2
import kr.co.pkg2.jo.*

fun main() {

    val obj1 = kr.co.pkg1.jo.TestClass1();
    obj1.testMethod();

    val obj2 = kr.co.pkg1.jo.tsFunc1()
    obj2

    val obj3: TestClass2 = TestClass2()
    obj3.testMethod2();

    tsFunc2()

    val obj6 = TestClass3()
    val obj7 = TestClass4()

    obj6.testMethod3()
    obj7.testMethod4()



}

