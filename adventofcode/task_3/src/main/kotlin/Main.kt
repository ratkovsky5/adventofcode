import java.io.File
import java.lang.Integer.max
import java.lang.Integer.min

//answers:
//first: 540212
//second: 87605697

fun main() {
    println(first())
    println(second())
}

fun first() : Int {
    var result = 0
    val regex = Regex("\\d+")
    val lines : MutableList<String> = mutableListOf()
    File("D:\\adventofcode\\task_3\\src\\main\\kotlin\\input.txt").forEachLine {
        lines.add(it)
    }
    for (i in lines.indices)
    {
        val results = regex.findAll(lines[i])
        val numbers = results.map { it.value }.toList()
        var start = 0
        var end = 0
        for (j in numbers.indices)
        {
            var isNextToSymbol = false
            start = lines[i].indexOf(numbers[j], startIndex = end)
            end = start + numbers[j].length - 1
            if (start > 0 && lines[i][start-1] != '.') isNextToSymbol = true
            if (end < lines[i].length-1 && lines[i][end+1] != '.') isNextToSymbol = true
            if (i > 0) //check line above
            {
                val checkThisPart = lines[i-1].substring(max(0, start-1)..min(end+1, lines[i-1].length-1))
                if ((checkThisPart.count(Char::isDigit) + checkThisPart.count{it == '.'}) < checkThisPart.length) isNextToSymbol = true
            }
            if (i < lines.size - 1) //check line below
            {
                val checkThisPart = lines[i+1].substring(max(0, start-1)..min(end+1, lines[i+1].length-1))
                if ((checkThisPart.count(Char::isDigit) + checkThisPart.count{it == '.'}) < checkThisPart.length) isNextToSymbol = true
            }
            if (isNextToSymbol)
            {
                result += numbers[j].toInt()
            }
        }
    }
    return result
}


fun second(): Int {
    var result = 0
    val test = 8
    val lines : MutableList<String> = mutableListOf()
    File("D:\\adventofcode\\task_3\\src\\main\\kotlin\\input.txt").forEachLine {
        lines.add(it)
    }
    for (i in lines.indices) //rows
    {
        val stars = lines[i].indices.filter { lines[i][it] == '*' } //indices of stars
        for (j in stars.indices)
        {
            val numbers : MutableList<String> = mutableListOf()
            val regex = Regex("\\d+")
            var lineAbove : MutableList<String> = mutableListOf()
            var thisLine : MutableList<String> = mutableListOf()
            var lineBelow : MutableList<String> = mutableListOf()
            if (i > 0)
            {
                val results = regex.findAll(lines[i-1])
                lineAbove = results.map { it.value }.toMutableList()
            }
            val results = regex.findAll(lines[i])
            thisLine = results.map { it.value }.toMutableList()
            if (i < lines.size-1)
            {
                val results2 = regex.findAll(lines[i+1])
                lineBelow = results2.map { it.value }.toMutableList()
            }
            var start : Int
            var end = 0
            for (k in lineAbove.indices)
            {
                start = lines[i-1].indexOf(lineAbove[k], startIndex = end)
                end = start + lineAbove[k].length - 1
                val star = ((max(0, stars[j]-1))..(min(stars[j]+1, lines[i-1].length-1))).toSet()
                val number = (start..end).toSet()
                if (star.intersect(number).isNotEmpty()) numbers.add(lineAbove[k])
            }
            end = 0
            for (k in thisLine.indices)
            {
                start = lines[i].indexOf(thisLine[k], startIndex = end)
                end = start + thisLine[k].length - 1
                val star = ((max(0, stars[j]-1))..(min(stars[j]+1, lines[i].length-1))).toSet()
                val number = (start..end).toSet()
                if (star.intersect(number).isNotEmpty()) numbers.add(thisLine[k])
            }
            end = 0
            for (k in lineBelow.indices)
            {
                start = lines[i+1].indexOf(lineBelow[k], startIndex = end)
                end = start + lineBelow[k].length - 1
                val star = ((max(0, stars[j]-1))..(min(stars[j]+1, lines[i+1].length-1))).toSet()
                val number = (start..end).toSet()
                if (star.intersect(number).isNotEmpty()) numbers.add(lineBelow[k])
            }
            if (numbers.size == 2) result += (numbers[0].toInt() * numbers[1].toInt())
        }
    }
    return result
}
