fun main() {
    val map1 = mapOf<String, Int>("key1" to 10, "key2" to 20,"key3" to 30) // 이름 to 값, 불변형 선언
    println(map1)

    val map2 = mutableMapOf<String, Int>() // map은 중괄호로 출력됌 배열이나 리스트는 대괄호
    println(map2)

    val map3 = mapOf<String, Any>("key1" to 10, "key2" to 21.21,"key3" to true) // 저장값의 자료형이 여러개일 경우(비추천), Any 타입을 제네릭에 써주면 됌
    println(map3)

    println(map1.get("key1"))
    println(map1["key1"]) // key값으로 실제 값을 가져옴, 더 자주 사용

    println("--------------------")
    println("map1.size : ${map1.size}")
    println("map1.keys ${map1.keys}")
    println("map1.values ${map1.values}")

    println("map1.containsKey ${map1.containsKey("Key1")}")
    println("map1.containsKey ${map1.containsKey("Key100")}")

    println("map1.containsValue ${map1.containsValue(10)}")
    println("map1.containsValue ${map1.containsValue(100)}")
    println("--------------------")

    println("map2 : $map2")
    map2.put("key1", 100)
    println("map2 : $map2")

    map2["key2"]=200 // 없는 값을 넣으면 새로 생성
    println("map2 : $map2")

    map2.put("key1", 1000)
    map2["key2"] = 2000
    println("map2:  $map2")

    map2.remove("key1")
    println("map2:  $map2")

    println("-------------------")

    val map100 = map1.toMutableMap() // map1은 불변형
    map100["key100"] = 1000 // 기존의 맵이 변경되는게 아니라 새로운 변수 속에 새 배열이 만들어지고 그 배열이 수정되는 것
    println(map100)

    val map200 = map100.toMap()
    // map200["key200"]=300 // 불변형으로 되서 수정 불가



}