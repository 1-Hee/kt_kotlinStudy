fun main() {
    val r1 = testfunc1(100, 200)
    println("r1 :$r1")

    val r2 = testfunc2(100,200)
    println("r1 :$r1")

    val r3= testfunc3(100,200)
    println("r3 $r3")

    val lamda1 : (Int, Int) -> Int = {a1:Int, a2:Int -> a1+a2}
    var r4 = lamda1(100,200)
    println("r4 : $r4")

    val lamda2 = {a1:Int, a2:Int -> a1+a2} // 11번줄처럼 자료형을 생략하고 작성 가능 (자료형이 추론이 가능하기 때문)
    val r5 = lamda2(100,200)
    println("r5 $r5")

    val lamda3 : (Int, Int) -> Int = {a1,a2 -> a1+a2}
    val r6 = lamda3(100,200)
    println("r6 : $r6")

    val r7 = testfunc4(100,200)
    println("r7 : $r7")

    val lamda4 = {a1:Int, a2:Int ->
        val r1 = a1 + a2
        val r2 = a1-a2
        r1 * r2
        // 함수에서는 최종적으로 리턴값을 주어야 하지만, 람다에서는 최종 으로 수행한 연산의 값을 자동으로 리턴값인양 처리함
    }

    val r8 = lamda4(100,200)
    println("r8 $r8")

}

fun testfunc1(a1:Int, a2:Int):Int{ // 중괄호로 여러줄 하는 경우에는 반환타입 생략 불가
    return a1 + a2
}

fun testfunc2(a1:Int, a2:Int):Int = a1+a2; // 한줄로 줄여쓸 때에는 반환타입 생략 가눙
fun testfunc3(a1:Int, a2:Int) = a1+a2;

fun testfunc4(a1:Int, a2:Int): Int {
    val r1= a1+a2
    val r2 = a1-a2
    val r3 = r1*r2
    return  r3
}
