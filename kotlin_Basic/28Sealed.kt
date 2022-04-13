fun main() {

    val v1 = Number2.TWO
    checkNumber(v1)


    println("-------------------")
    val v2 = Number22.SealedTwo(1)
    val v3 = Number22.SealedTwo(2)
    val v4 = Number22.SealedOne(100 ,200)
    val v5 = Number22.SealedThree(100, 11.11)

    checkNumber2(v2)
    checkNumber2(v3)
    checkNumber2(v4)
    checkNumber2(v5)

}

enum class Number2(val num:Int){
    ONE(1), TWO(2), THREE(3)
}

fun checkNumber(a1:Number2){
    when(a1){
        Number2.ONE -> println("ONE")
        Number2.TWO -> println("TWO")
        Number2.THREE -> println("THREE")
    }

    when(a1.num){
        1 -> println("1")
        2 -> println("2")
        3 -> println("3")
    }

}

sealed class Number22 {
    class SealedOne(val a1:Int, val a2:Int) :Number22()
    class SealedTwo(val a1:Int) :Number22(){
        fun sealedFun2(){
            println("Sealed Two의 meThod")
        }
    }
    class SealedThree(val a1:Int, val a2:Double) :Number22()
}

fun checkNumber2(a1:Number22){
    when(a1){
        is Number22.SealedOne -> {
            println("SONE")
            println(a1.a1)
            println(a1.a2)
        }
        is Number22.SealedTwo -> {
            println("STWO")
            println(a1.a1)
            when(a1.a1){
                1 -> println("1입니다")
                2 -> println("2입니다")
            }
            a1.sealedFun2()

        }
        is Number22.SealedThree -> {
            println("STHREE")
            println(a1.a1)
            println(a1.a2)

        }
    }

}