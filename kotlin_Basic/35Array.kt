fun main() {
    val array1 = arrayOf(10,20,30,40, 50)
    println("array1 : ${array1.contentToString()}")

    val array2 =arrayOf(100, 11.11, "문자열", true)
    println("array2 : ${array2.contentToString()}")

    val array3 = intArrayOf(10,20,30,40,50)
    val array4 = doubleArrayOf(11.11,22.22,33.33,44.44)
    val array5 = arrayOf<String>("문자열","문자열2", "문자열3")

    println("array3 : ${array3.contentToString()}")
    println("array4 : ${array4.contentToString()}")
    println("array5 : ${array5.contentToString()}")

    val array6 = Array(5, {0})
    println("array6 : ${array6.contentToString()}")

    val array7 = Array(5){it*2}
    println("array7 : ${array7.contentToString()}")

    println("----------------------")

    for(item in array1){
        print("array1 $item")
    }

    println("----------------------")

    val array8 = arrayOf(arrayOf(10, 20, 30), arrayOf(40, 50, 60), arrayOf(70, 80, 90))
    println(array8)
    println("array8 : ${array8.contentToString()}")
    println("array8 : ${array8.contentDeepToString()}")

    for(item1 in array8){
        for(item2 in item1){
            println(item2)
        }
    }

    println("----------------------")

    println("array1[0] ${array1[0]}")
    println("array1[1] ${array1[1]}")
    println("array1[2] ${array1.get(2)}")
    println("array1[3] ${array1.get(3)}")

    println("----------------------")

    println("array1 : ${array1.contentToString()}")

    array1[0] = 100
    array1.set(1, 200)
    println("array1 : ${array1.contentToString()}")

    println("----------------------")

    println("array1 size : ${array1.size}")
    println("----------------------")

    // 추가 메서드
    // plus : 요소를 추가한 새로운 배열을 만들어 반환
    // sliceArray : 지정된 범위의 요소를 관리하는 배열을 만들어 반환
    // first : 제일 앞의 값을 반환
    // last : 제일 마지막의 값을 반환
    // indexOf : 지정된 값의 index를 반환
    // average : 평균 값을 반환
    // count : 요소의 개수를 반환
    // contains : 지정된 값이 포함되어 있는지 반환
    // sortedArray : 오름차순으로 정렬된 배열을 반환
    // sortedArrayDescending : 내림차순으로 정렬된 배열을 반환
    // 이 메서드들은 변수에 담아서 호출하는 식으로 사용해야 함

    println("array1 : ${array1.contentToString()}")
    val array10 = array1.plus(60)
    // 단순히 plus로 한다고 기존의 배열이 변경되지 못함, Array.plus(x) 이런게 안된다는 뜻.
    // 그래서 별도로 배열을 복사하는 형태로 해야지 되는 듯
    println("array10 : ${array10.contentToString()}")

    val array11 = array1.sliceArray(1..3)
    println("array11 : ${array11.contentToString()}")

    println(array1.first())
    println(array1.last())
    println(array1.indexOf(30))
    println(array1.average())
    println(array1.sum())
    println(array1.count())
    println(array1.size)
    println(array1.contains(30)) // boolean 값들
    println(array1.contains(1000))
    println(1000 in array1)

    val array12 = arrayOf(5,1,3,7,10,8)
    val array13 = array12.sortedArray()
    val array14 = array12.sortedArrayDescending()

    println(array13.contentToString())
    println(array14.contentToString())





}