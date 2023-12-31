import java.io.File

//answers:
//first: 28750
//second: 10212704


fun main() {
    println(first())
    println(second())
}

fun first() : Int
{
    var result = 0
    File("D:\\adventofcode\\task_4\\src\\main\\kotlin\\input.txt").forEachLine {
        val splitCards = it.substring(it.indexOf(":")+2).split(" | ")
        val winningCards = splitCards[0].split(" ").filter{ it1 -> it1 != "" && it1 != " "}
        val myCards = splitCards[1].split(" ").filter{ it1 -> it1 != "" && it1 != " "}
        val number = winningCards.intersect(myCards.toSet()).count()
        if (number > 0) {
            var actual = 1
            for (i in 1 until number)
            {
                actual *= 2
            }
            result += actual
        }
    }
    return result
}

fun second() {
    val input = File("D:\\adventofcode\\task_4\\src\\main\\kotlin\\input.txt").readLines()
    val cardCount = IntArray(input.size) { 1 }

    for (cardId in input.indices) {
        val line = input[cardId]
        val card = parseLine(line)

        val matchCount = card.winningNumbers.intersect(card.myNumbers.toSet()).count()

        for (i in 0 until matchCount) {
            cardCount[cardId + 1 + i] += cardCount[cardId]
        }
    }

    println(cardCount.sum())
}

data class Card(val winningNumbers: IntArray, val myNumbers: IntArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (!winningNumbers.contentEquals(other.winningNumbers)) return false
        if (!myNumbers.contentEquals(other.myNumbers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = winningNumbers.contentHashCode()
        result = 31 * result + myNumbers.contentHashCode()
        return result
    }
}

fun parseLine(line: String): Card {
    val parts = line.split(':')
    val numbers = parts[1].split('|')
    val winningNumbers = extractNumbers(numbers[0])
    val myNumbers = extractNumbers(numbers[1])

    return Card(winningNumbers, myNumbers)
}

fun extractNumbers(input: String): IntArray {
    return input.split(' ', '\t')
        .filter { it.isNotBlank() }
        .map(String::toInt)
        .toIntArray()
}
