fun main() {
    testfunc1()
    testfunc1()
    testfunc2()
    testfunc2()
}

fun testfunc1(){
    println("--------------")
    println("testfunc1")
    println("--------------")
}

inline fun testfunc2(){
    println("--------------")
    println("testfunc2")
    println("--------------")

}