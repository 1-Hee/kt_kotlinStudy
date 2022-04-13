fun main() {

    tsFunc1("문자열")
//    tsFunc1(null)

    println("-----------------")
    tsFunc2("문자열2")
    tsFunc2(null)
    println("-----------------")
    tsFunc3("문자열3")
    tsFunc3(null)

}

fun tsFunc1(str:String?){
    val value1:String = str!!
    println(value1)
}

fun tsFunc2(str:String?){
    val value1:String = str ?: "기본문자열"
    println("value1 : $value1")
}

fun tsFunc3(str:String?){
    println("str : $str")

    println("str length : ${str?.length}")
}