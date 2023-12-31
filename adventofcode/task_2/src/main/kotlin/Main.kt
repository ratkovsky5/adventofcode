import java.io.File

//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/slice.html

//answers:
//first: 2716
//second: 72227

fun main() {
    println(first())
    println(second())
}

fun second(): Int {
    var result = 0
    File("D:\\adventofcode\\task_2\\src\\main\\kotlin\\input.txt").forEachLine {
        val colors = mutableMapOf("blue" to 0, "green" to 0, "red" to 0)
        var stringGame = ""
        var index = 0
        for (i in 5 until it.length)
        {
            if (it[i].toString() == ":")
            {
                index = i+2
                break
            }
            stringGame += it[i].toString()
        }
        val sets : List<String> = (it.slice(index until it.length)).split("; ")
        for (element in sets)
        {
            val cubes : List<String> = element.split(", ")
            for (element2 in cubes)
            {
                val pairs: List<String> = element2.split(" ")
                if (colors[pairs[1]]!! < pairs[0].toInt())
                {
                    colors[pairs[1]] = pairs[0].toInt()
                }
            }
        }
        result += (colors["blue"]!! * colors["green"]!! * colors["red"]!!)
    }
    return result
}

fun first(): Int {
    var result = 0
    val colors = mapOf("blue" to 14, "green" to 13, "red" to 12)
    File("D:\\adventofcode\\task_2\\src\\main\\kotlin\\input.txt").forEachLine {
        var stringGame = ""
        var index = 0
        var possible = true
        for (i in 5 until it.length)
        {
            if (it[i].toString() == ":")
            {
                index = i+2
                break
            }
            stringGame += it[i].toString()
        }
        val gameNumber : Int = stringGame.toInt()
        val sets : List<String> = (it.slice(index until it.length)).split("; ")
        for (element in sets)
        {
            val cubes : List<String> = element.split(", ")
            for (element2 in cubes)
            {
                val pairs: List<String> = element2.split(" ")
                if (colors[pairs[1]] != null && colors[pairs[1]]!! < pairs[0].toInt())
                {
                    possible = false
                }
                if (!possible) break
            }
            if (!possible) break
        }
        if (possible) result += gameNumber
    }
    return result
}