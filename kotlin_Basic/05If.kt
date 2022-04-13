fun main() {

    val a1:Int = 10
    // 기분 if 문 : if문의 조건식(변수의값)이 true인 경우에만 내부에 코드 실행

    if(a1 == 10){
        println("a1은 10임")

    }

    if(a1 != 10){
        println("a1은 10아님")
    }

    // if else

    if ( a1 == 10) {
        println("a1은 10임다")
    } else {
        println("a1은 10 아님다")
    }

    if ( a1 == 20) {
        println("a1은 20임다")
    } else {
        println("a1은 20 아님다")
    }

    //모든조건을 만족해야할 경우

    val a2:Int = 10
    val a3:Int = 20
    if(a2==10 && a3==20){
        println("a2 $a2 이고 a3 $a3 이다")
    }

    val a5:Int = 10
    // 코틀린에서 if문 짧을때 간략히 쓰는 법

    val a6:String = if(a5==10) "10이에요" else "10이 아니에요"
    println(a6)


    // 여러줄 if문, 근데 마지막은 무조건 넣을 값을 코딩해줘야함함
    val a7:String = if(a5==10) {
        println("히히히")
        "10이에요"
    } else {
        println("호호호")
        "10이 아니에요"
    }
    println(a7)



}