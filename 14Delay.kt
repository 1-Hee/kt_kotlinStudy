fun main() {

    val obj1 = TestClassone()
    println(obj1.a1)

    //println(obj1.a3), lateinit을 하면 그 자체는 변수에 값을 넣은게 아니므로
    // "초기화" 되지 못해서 컴파일 에러가 남. 그래서 변수를 초기화해주는 작업 이후에 사용해야 오류 없음

    obj1.testMethod1()
}

class TestClassone(){
    var a1:Int =100
    lateinit var a3:String

    val a4:String by lazy{
        println("a4 layz")
        "문자열"
    }


    var a2:Int
    init {
        a2 = 200
    }

    fun testMethod1(){
        if(::a3.isInitialized==false){
            a3="문자열"
        }
        println(a3)
    }
}


