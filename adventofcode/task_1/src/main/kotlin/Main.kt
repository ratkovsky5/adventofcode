import java.io.File

//https://www.baeldung.com/kotlin/read-file
//https://kotlinandroid.org/kotlin/kotlin-reverse-string/

//answers:
//first: 54916
//second: 54728

fun main() {
    println(first())
    println(second())
}

fun first() : Int {
    var result = 0
    File("D:\\adventofcode\\task_1\\src\\main\\kotlin\\input.txt").forEachLine {
        val firstNumber = it.find { it1 -> it1.isDigit() }.toString()
        val lastNumber = it.findLast { it2 -> it2.isDigit()}.toString()
        result += ((firstNumber + lastNumber).toInt())
    }
    return result
}

fun second(): Int {
    var result = 0
    val wordsToNumbers = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9, "0" to 0, "1" to 1, "2" to 2, "3" to 3, "4" to 4, "5" to 5, "6" to 6, "7" to 7, "8" to 8, "9" to 9)
    File("D:\\adventofcode\\task_1\\src\\main\\kotlin\\input.txt").forEachLine {
        var line = it
        line = line.replace("one", "o1e")
        line = line.replace("two", "t2o")
        line = line.replace("three", "t3e")
        line = line.replace("four", "f4r")
        line = line.replace("five", "f5e")
        line = line.replace("six", "s6x")
        line = line.replace("seven", "s7n")
        line = line.replace("eight", "e8t")
        line = line.replace("nine", "n9e")
        val firstNumber = line.find { it1 -> it1.isDigit() }.toString()
        val lastNumber = line.findLast { it2 -> it2.isDigit()}.toString()
        result += ((firstNumber + lastNumber).toInt())
    }
    return result
}
