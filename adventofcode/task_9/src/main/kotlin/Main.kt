import java.io.File

//answers:
//first: 1702218515
//second: 925

fun main() {
    println(first())
    println(second())
}

fun first() : Int {
    var result = 0
    val history : MutableList<MutableList<Int>> = mutableListOf()
    File("D:\\adventofcode\\task_9\\src\\main\\kotlin\\input.txt").forEachLine {
        history.add(it.split(" ").map { it1 -> it1.toInt()}.toMutableList())
        while (history[history.size-1].any { it1 -> it1 != 0 })
        {
            val newLine = mutableListOf<Int>()
            for (i in 0..history[history.size-1].size-2)
            {
                newLine.add(history[history.size-1][i+1] - history[history.size-1][i])
            }
            history.add(newLine)
        }
        var add = 0
        for (i in history.indices.reversed())
        {
            add += history[i][history[i].size-1]
        }
        result += add
        history.clear()
    }
    return result
}


fun second(): Int {
    var result = 0
    val history : MutableList<MutableList<Int>> = mutableListOf()
    File("D:\\adventofcode\\task_9\\src\\main\\kotlin\\input.txt").forEachLine {
        history.add(it.split(" ").map { it1 -> it1.toInt()}.toMutableList())
        while (history[history.size-1].any { it1 -> it1 != 0 })
        {
            val newLine = mutableListOf<Int>()
            for (i in 0..history[history.size-1].size-2)
            {
                newLine.add(history[history.size-1][i+1] - history[history.size-1][i])
            }
            history.add(newLine)
        }
        var prev = 0
        for (i in history.indices.reversed())
        {
            prev = (history[i][0] - prev)
        }
        result += prev
        history.clear()
    }
    return result
}
