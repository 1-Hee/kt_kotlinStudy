fun main() {

    // when, switch case와 비슷함

    val a1 = 2
    when(a1){
        1-> println("1")
        2-> {
            println("수행되는 블럭스")
            println("2")
        }
        3-> println("3")
        else -> println("Default")
    }

    val a2 = 3
    when(a2) {
        1,2 -> println("1이거나 2임")
        3,4 -> println("3이거나 4임")
        5,6 -> println("5거나 6임")
        else -> println("암시렁도 아님")
    }

    val a3 = 55.55
    when(a3){
        33.33 -> println("33.33")
        55.55 -> println("55.55")
        77.77 -> println("77.77")
        else -> println("default")
    }

    val a4 = "문자열"
    when(a4){
        "문자열" -> println(1)
        "문자열2" -> println(2)
        "문자열3" -> println(3)
        else -> println(0)
    }

    val a5 = 5
    when(a5) {
        in 1..3 -> println(33)
         // 1~3
        in 1..6 -> println(16)
        in 4..6 -> println(55)
        else -> println("else")
    }

    val str = setValue(1)
    val str2 = setValue(2)
    val str3 = setValue(3)

    println("$str, $str2, $str3")


}

fun setValue(a1:Int) = when(a1){
    1 -> "String1"
    2 -> "String2"
    else -> "else"
}