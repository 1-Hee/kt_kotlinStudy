fun main() {

    val s1 = sbClass()
    println(s1.sbM1)
    s1.sbMM()

    println(s1.SM1)
    s1.SMM()


}

open class SuperClass1(){
    var SM1 = 100
    fun SMM() {
        println("SMM")
    }
}

class sbClass:SuperClass1(){

    val sbM1= 200
    fun sbMM() {
        println("sbMM")
    }

}

open class SuperClass2(val a1:Int)

class sbClass2:SuperClass2{
    constructor():super(100)


}