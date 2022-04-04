// 단항 연산자

fun main() {
    // 단항연산자 : 항이 하나뿐인 연산자
    // + : 양수 => 양수, 음수 =? 음수
    val a1:Int = 10
    val a2:Int = -10

    val r1:Int = +a1
    val r2:Int = +a2
    println(r1)
    println(r2)

    // - : 양수 >> 음수 음수 >> 양수
    val r3:Int = -a1
    val r4:Int = -a2
    println(r3)
    println(r4)

    // ! : true > false
    val a3:Boolean = true
    val a4:Boolean = false

    val r5:Boolean = !a3
    val r6:Boolean = !a4

    println(r5)
    println(r6)

    // 증감연산자 a++ a--

    println("--------------------------")

    var a5:Int = 10
    var a6:Int = 10

    a5++
    a6--

    println(a5)
    println(a6)

    var a7:Int = 10
    var a8:Int = 10

    ++a7
    --a8
    println(a7)
    println(a8)

    println("--------------------------")

    // 산술연산자

    val r11 = 10 +3
    val r12 = 10-3
    val r13 = 10 * 3
    val r14 = 10/3
    val r15 = 10%3

    println("$r11, $r12, $r13, $r14, $r15")
    val r16 = 10..2

    println(r16)

    // 대입연산자

    var a9 = 1;
    a9+=1
    println(a9)

    a9-=1
    println(a9)

    a9*=2
    println(a9)

    a9/=2
    println(a9)

    a9%=2
    println(a9)

    println("--------------------------")

    // 비교연산자

    val a10 = 10
    val a11 = 10

    val r17 = a10 == a11
    val r18 = a10 != 20
    val r19 = a10 != a11

    println("$r17, $r18, $r19")

    println("--------------------------")

    val a15 = 10
    val r21 = a15 < 20
    val r22 = a15 <= 10
    val r23 = a15 >= 10

    println("$r21, $r22, $r23")







}