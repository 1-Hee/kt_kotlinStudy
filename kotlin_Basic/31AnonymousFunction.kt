fun main() {
    tsf1()

    // val tsf2 = tsf1 // 함수의 이름이 함수 객체의 주솟값을 담는 변수로 취급하는 언어, 대표적으로 파이썬 같은 언어에서 이런 문법이 허용
    val tsf2 = fun(){
        println("tsf2임")
    }
    tsf2() // 함수의 이름이 없으므로 변수를 통해서 함수 호출 가능

}

fun tsf1(){
    println("tsf1임")
}