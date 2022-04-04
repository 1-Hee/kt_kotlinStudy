fun main() {

    // val obj1 = Super1() // 추상클래스는 직집 상속 불가
    // tf1(obj1)

    val obj2 = Sub1()
    tf1(obj2)

    val obj3 = Sub2()
    tf1(obj3)

}


open abstract class Super1 {
    fun mt1(){
        println("sp1 mt1")
    }

    open abstract fun mt2()
}

class Sub1 : Super1() {
    override fun mt2(){
        println("sub1 mt2")
    }

}

class Sub2 : Super1(){
    override fun mt2() {
        println("sub2의 mt2")
    }

}


fun tf1(obj1:Super1){
    obj1.mt1()
    obj1.mt2()
}