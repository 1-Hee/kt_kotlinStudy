fun main() {
    val str1 = "안녕하세요"
    println(str1[0])
    println(str1[1])

    // str1[0] = 'a' // 이런건 안됌
    println("----------------------------")
    val str2 = str1.substring(1..3)
    println(str2)
    println("----------------------------")
    val str3  = "Hello world"
    val str4  = "hello world"
    println(str3.compareTo(str4))
    println(str3.compareTo(str4, true))
    println(str3.contentEquals(str4))
    println("----------------------------")

    val str5 = "ab cd ef gh"
    val r1 = str5.split(" ")
    println(r1)

    println("----------------------------")
    val str6 = "abc"
    val str7 = str6+"def"
    println(str6)
    println(str7)

    val buffer = StringBuffer()
    buffer.append("abc")
    buffer.append(100)
    buffer.append(11.11)
    println("buffer : $buffer")

    buffer.insert(3, "테스트")
    println("buffer $buffer")

    buffer.delete(3,6)
    println("buffer : $buffer")

}