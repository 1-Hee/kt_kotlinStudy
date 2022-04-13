fun main() {

    // 정수리터럴
    println(100);

    println(1000000000000000000); // 20억이 넘는 숫자여도 L 안붙여도 됨.
    println(1000000000000000000L) // 붙여도 됌
    println(938_492_334_823)

    // 실수 리터럴
    println(11.11)
    println(22.22F)

    // 문자리터럴
    println('A')
    println('가')

    // 문자열 리터럴
    println("문자열")
    println("문자열2")

    // 불리언 리터럴
    println(true)
    println(false)

    // Row String : """ """ // 여러 문자
    // Nothing // 함수가 정상적으로 끝나지 않음을 의미
    // Unit : void를 의미

    //Row String
    println("동해물과 백두산이 \n마르고닳도록 \n하느님이 보우하사 \n우리나라 만세")

    println("""동해물과
        |백두산이
        |하느님이
        |우리나라 만쉐이
    """.trimMargin())

    // 정수형은 같은데
    // 부호 없는 양수만 쓰는 건 U ~~~ 이렇게 사용

    // var 선언후 값 다시 저장 가능
    // val 선언후 값 다시 저장 불가

    println("--------------------")

    val a1:Int = 100
    println("a1 : ${a1}");
    println("a1 : "+a1);
    println("a1 : $a1");

    val a2 = 100
    println("a2 : $a2")

    println("--------------------")

    var a3:Int = 100
    val a4:Int = 100

    println("a3 : $a3")
    println("a4 : $a4")

    a3 = 200

    println("a3 : $a3")
    // val로 하면 값 변경 불가함
    // a4 = 150;

    println("--------------------")

    // null 허용 변수 ? 면 허용 ?없으면 허용 x
    // ex) a = 100, a= null (허용x)
    //      a:Int? = null (허용)

    var a5 = 100
    // a5 = null // 불가

    var a6:Int? = 100
    a6 = null // 허용

    println(a5)
    println(a6)

    // var a7:Int = a6!! // !!연산자로 강제로 null 못받는 a7에 null 이 있는 a6를 대입시킬수는 있음 근데 오류남
    


}