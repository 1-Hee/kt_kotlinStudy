fun main() {

    testMethod1("안녕하세요")
    println("-----------------")
    testMethod1(null)


    println("-----------------")
    testMethod2("안녕하세요")
    testMethod2(null)
}

fun testMethod1(str:String?){
    println(str?.length);

    if(str is String){
        println(str.length)
    }

    // println(str.length)

    if (str != null){
        // 스마트캐스팅 발생
        println(str.length)
    }
}

fun testMethod2(str:Any?){

    if(str is String){
        println(str.length)
    }

    if(str != null){
//        println(str.length) // Any?로 널을 받긴하는데, 1번 메서드랑 다르게 null을 받아줄 메서드가 부재하므로 오류 발생
    }
}


