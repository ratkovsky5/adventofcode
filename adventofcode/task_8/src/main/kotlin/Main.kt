import java.io.File
import java.math.BigInteger

//answers:
//first: 19667
//second: 19185263738117

fun main() {
    println(first())
    println(second())
}

fun first() : Int {
    var result = 0
    var instructions = ""
    val network = mutableMapOf<String, MutableList<String>>()
    var index = 0
    File("D:\\adventofcode\\task_8\\src\\main\\kotlin\\input.txt").forEachLine {
        when (index) {
            0 -> {
                index++
                instructions = it
            }
            1 -> index++
            else -> {
                val directions : MutableList<String> = mutableListOf()
                directions.add(it.substring(7..9))
                directions.add(it.substring(12..14))
                network[it.substring(0..2)] = mutableListOf()
                network[it.substring(0..2)]?.addAll(directions)
                directions.clear()
            }
        }
    }
    var key = "AAA"
    while (true)
    {
        if (key == "ZZZ") break
        for (i in instructions.indices)
        {
            if (key == "ZZZ") break
            key = if (instructions[i] == 'R') network[key]!![1] else network[key]!![0]
            result++
        }
    }
    return result
}


fun second(): BigInteger {
    var result = 0
    var instructions = ""
    val network = mutableMapOf<String, MutableList<String>>()
    val currentNodes = mutableListOf<String>()
    var index = 0
    File("D:\\adventofcode\\task_8\\src\\main\\kotlin\\input.txt").forEachLine {
        when (index) {
            0 -> {
                index++
                instructions = it
            }
            1 -> index++
            else -> {
                if (it[2] == 'A') currentNodes.add(it.substring(0..2))
                val directions : MutableList<String> = mutableListOf()
                directions.add(it.substring(7..9))
                directions.add(it.substring(12..14))
                network[it.substring(0..2)] = mutableListOf()
                network[it.substring(0..2)]?.addAll(directions)
                directions.clear()
            }
        }
    }
    val firstEnd = mutableMapOf<String, Int>()
    for (j in currentNodes.indices)
    {
        result = 0
        var key = currentNodes[j]
        while (true)
        {
            if (key.endsWith('Z'))
            {
                firstEnd[currentNodes[j]] = result
                break
            }
            for (i in instructions.indices)
            {
                if (key.endsWith('Z'))
                {
                    firstEnd[currentNodes[j]] = result
                    break
                }
                key = if (instructions[i] == 'R') network[key]!![1] else network[key]!![0]
                result++
            }
        }
    }
    return calculateLCM(firstEnd.values.toList())
}

fun calculateLCM(numbers: List<Int>): BigInteger {
    return numbers.fold(BigInteger.ONE) { acc, number ->
        acc.multiply(BigInteger.valueOf(number.toLong()))
            .divide(acc.gcd(BigInteger.valueOf(number.toLong())))
    }
}