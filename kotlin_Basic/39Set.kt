fun main() {
    // Set
    // 순서도 없이 그냥 중복되지 않는 값을 저장할 용도로만 사용 가능
    // 순서도 없고, 오로지 Set안의 값이 있는지만 처음부터 끝까지 탐색하는 선형탐색으로 탐색함
    // for문을 이용해서 값을 순회해서 찾아야함

    val set1 = setOf(1,5,10,1,5,10) // 선언과정에서 값을 중복해서 넣을 순 있지만 결과값은 중복을 자동으로 제거해버림
    println("set1 : $set1")

    val set2 = mutableSetOf<Int>()
    println("set2 : $set2")

    println("----------------------")
//    println(set1.get(0)) //index로 값 탐색 불가
    for(i in set1) println(i)

    println("size : ${set1.size}")

    println("----------------------")

    println(set2)
    set2.add(10)
    set2.add(20)
    set2.addAll(listOf(30,40,50))
    set2.add(20)
    println("set2 : $set2")
    set2.addAll(listOf(40,50,60,70))
    println("set2 : $set2")

    set2.remove(30) // index로 값 삭제 불가, 따라서 삭제할 값을 알아야함함
    println("set2 : $set2")
    println("----------------------")

    // list와 set 간에 변환 지원 역의 경우도 지원
    // 단 list의 순서는 set으로 변환하는 과정에서 섞일 수 있으므로(순서 보존 보장 x) 주의해야함

    val set3 = set1.toMutableSet() // set1은 변함이 없음
    set3.add(1000)
    println("set3: $set3")

    val set4 = set3.toSet()
//    set4.add()  불가
    println(set4)

    val list100 = listOf(10, 20, 30, 10, 20, 30)
    println("list100 : $list100")

    val set5 = list100.toSet()
    val set6 = list100.toMutableSet()

    println("set5" + set5)
    println("set6" + set6)

    val set7 = set5.toList()
    val set8 = set5.toMutableList()

    println(set7[0])
    println(set8[1])




}