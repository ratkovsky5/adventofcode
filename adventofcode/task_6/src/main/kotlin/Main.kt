import java.io.File

//answers:
//first: 741000
//second: 38220708

fun main() {
    println(first())
    println(second())
}

fun first() : Int {
    var result = 0
    val regex = Regex("\\d+")
    var times : MutableList<String> = mutableListOf()
    var distances : MutableList<String> = mutableListOf()
    var first = true
    File("D:\\adventofcode\\task_6\\src\\main\\kotlin\\input.txt").forEachLine {
        val matches = regex.findAll(it)
        if (first)
        {
            first = false
            times = matches.map { it1 -> it1.value }.toMutableList()
        }
        else distances = matches.map { it1 -> it1.value }.toMutableList()
    }
    for (i in times.indices)
    {
        var ways = 0
        for (j in 0..times[i].toInt())
        {
            val distance = j * (times[i].toInt() - j)
            if (distance > distances[i].toInt()) ways++
        }
        result = if (result == 0) ways else result * ways
    }
    return result
}


fun second(): Long {
    val regex = Regex("\\d+")
    var times : MutableList<String> = mutableListOf()
    var distances : MutableList<String> = mutableListOf()
    var first = true
    var time = ""
    var record = ""
    File("D:\\adventofcode\\task_6\\src\\main\\kotlin\\input.txt").forEachLine {
        val matches = regex.findAll(it)
        if (first)
        {
            first = false
            times = matches.map { it1 -> it1.value }.toMutableList()
        }
        else distances = matches.map { it1 -> it1.value }.toMutableList()
    }
    for (i in times.indices)
    {
        time += times[i]
        record += distances[i]
    }
    var ways : Long = 0
    for (j in 0..time.toLong())
    {
        val distance : Long = j * (time.toLong() - j)
        if (distance > record.toLong()) ways++
    }
    return ways
}
