fun main() {
// list 생성

    val list1 = listOf(10,20,30,40,50) // 추론이 되면 제네릭을 삭제 가능
    val list2 = listOf("믄자열1", "믄자열2", "믄자열3")

    println(list1) // contentToString 안써도 값 보임
    println(list2)

    val list3 = mutableListOf<Int>()
    val list4 = mutableListOf("믄자열1", "믄자열2", "믄자열3")

    println(list3)
    println(list4)

    val list5 = emptyList<Int>() // 텅 비어있는 불변형 리스트
    println(list5)

    val list6 = listOfNotNull(10, 20, null, 30, 40, null, 50)
    println(list6)

    for(i in list1) println(i);
    println(list1.size)

    println("------------------------")
    println(list1.get(0))
    println(list1.get(1))
    println(list1[2])
    println(list1[3])

    println("------------------------")

    val list7 = listOf(10, 20, 30, 10, 20, 30)
    val index1 = list7.indexOf(20) // 좌측부터 시작해서 탐색함
    println(index1)

    val index2 = list7.lastIndexOf(20) // 우측부터 시작해서 탐색함
    println(index2)

    val list8 = list1.subList(1,3)
    println(list8)

    println("------------------------")

    println(list3)
    list3.add(10)
    list3.add(20)
    list3.add(30)
    println(list3)

    list3.addAll(listOf(40,50,60)) // 한꺼번에 여러값 넣기 가능
    println(list3)

    list3.add(1, 100)
    println(list3)
    list3.addAll(2, listOf(200, 300, 400)) // 2번위치에 배열 값 전채를 끼워넣음
    println(list3)

    list3.remove(100)
    println(list3)

    list3.removeAll(listOf(200,300))
    println(list3)

    list3.removeAt(1)
    println(list3)

    list3.set(1, 200)
    println(list3)

    list3[2] = 300
    println(list3)

    println("------------------------")

    val list100 = list1.toMutableList() // 기존의 배열을 복사해서 새로운 배열을 만들고 그배열을 가변형으로 만드는 것임
    list100.add(100)
    println(list100)

    val list200 = list100.toList() // 가변형 배열을 불변형 리스트로 변환


}