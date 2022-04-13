fun main() {

    val r1 = testfun1(100)
    println(r1);

    val r2 = testfun2(2)
    println(r2)

    val r3 = testfun2(0)
    println(r3)

    testfun3(1)
    testfun3(0)

    for (item in 1..10){

        if (item > 5) break

        println(item)

    }

    println("-----------------")

    for (item in 1..10){

        if(item %2 ==0){
            continue
        }

        println(item)

    }


}

fun testfun1(a1:Int) : Int {
    println("testfunc1")
    return a1+100
}

fun testfun2(a2:Int) : Int {
    println("testfunc2")

    if(a2==0){
        return -1
    }

    println("이부분이 수행될까요?")

    return 100/a2
}

fun testfun3(a1:Int){
    if(a1 == 0){
        return
    }
    println("a1 0이 아님")
}
