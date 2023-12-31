import java.io.File

//answers:
//first: 245794640
//second: 247899149

fun main() {
    println(first())
    println(second())
}

fun sortCards (card1 : String, card2 : String) : Int
{
    //7 values, highest - 7, lowest - 1
    val values = mapOf(
        'A' to 13,
        'K' to 12,
        'Q' to 11,
        'J' to 10,
        'T' to 9,
        '9' to 8,
        '8' to 7,
        '7' to 6,
        '6' to 5,
        '5' to 4,
        '4' to 3,
        '3' to 2,
        '2' to 1,
    )
    var first = 0
    var second = 0
    val lettersOfCard1 = mutableMapOf<Char, Int>()
    for (i in card1.indices)
    {
        if (!lettersOfCard1.containsKey(card1[i])) lettersOfCard1[card1[i]] = 0
        lettersOfCard1[card1[i]] = lettersOfCard1[card1[i]]!! + 1
    }
    val lettersOfCard2 = mutableMapOf<Char, Int>()
    for (i in card2.indices)
    {
        if (!lettersOfCard2.containsKey(card2[i])) lettersOfCard2[card2[i]] = 0
        lettersOfCard2[card2[i]] = lettersOfCard2[card2[i]]!! + 1
    }
    if (lettersOfCard1.keys.size == 1) first = 7
    else if (lettersOfCard1.keys.size == 2 && lettersOfCard1.values.contains(4)) first = 6
    else if (lettersOfCard1.keys.size == 2) first = 5
    else if (lettersOfCard1.keys.size == 3 && lettersOfCard1.values.contains(3)) first = 4
    else if (lettersOfCard1.keys.size == 3) first = 3
    else if (lettersOfCard1.keys.size == 4) first = 2
    else if (lettersOfCard1.keys.size == 5) first = 1
    if (lettersOfCard2.keys.size == 1) second = 7
    else if (lettersOfCard2.keys.size == 2 && lettersOfCard2.values.contains(4)) second = 6
    else if (lettersOfCard2.keys.size == 2) second = 5
    else if (lettersOfCard2.keys.size == 3 && lettersOfCard2.values.contains(3)) second = 4
    else if (lettersOfCard2.keys.size == 3) second = 3
    else if (lettersOfCard2.keys.size == 4) second = 2
    else if (lettersOfCard2.keys.size == 5) second = 1
    if (first > second) return 1
    else if (first < second) return -1
    else
    {
        for (i in card1.indices)
        {
            if (values[card1[i]]!! > values[card2[i]]!!) return 1
            else if (values[card1[i]]!! < values[card2[i]]!!) return -1
        }
    }
    return 0
}

fun sortCards2 (card1 : String, card2 : String) : Int
{
    //7 values, highest - 7, lowest - 1
    val values = mapOf(
        'A' to 13,
        'K' to 12,
        'Q' to 11,
        'T' to 10,
        '9' to 9,
        '8' to 8,
        '7' to 7,
        '6' to 6,
        '5' to 5,
        '4' to 4,
        '3' to 3,
        '2' to 2,
        'J' to 1,
    )
    var first = 0
    var second = 0
    val lettersOfCard1 = mutableMapOf<Char, Int>()
    for (i in card1.indices)
    {
        if (!lettersOfCard1.containsKey(card1[i])) lettersOfCard1[card1[i]] = 0
        lettersOfCard1[card1[i]] = lettersOfCard1[card1[i]]!! + 1
    }
    val lettersOfCard2 = mutableMapOf<Char, Int>()
    for (i in card2.indices)
    {
        if (!lettersOfCard2.containsKey(card2[i])) lettersOfCard2[card2[i]] = 0
        lettersOfCard2[card2[i]] = lettersOfCard2[card2[i]]!! + 1
    }

    if (!lettersOfCard1.keys.contains('J'))
    {
        if (lettersOfCard1.keys.size == 1) first = 7
        else if (lettersOfCard1.keys.size == 2 && lettersOfCard1.values.contains(4)) first = 6
        else if (lettersOfCard1.keys.size == 2) first = 5
        else if (lettersOfCard1.keys.size == 3 && lettersOfCard1.values.contains(3)) first = 4
        else if (lettersOfCard1.keys.size == 3) first = 3
        else if (lettersOfCard1.keys.size == 4) first = 2
        else if (lettersOfCard1.keys.size == 5) first = 1
    }
    else if (lettersOfCard1.keys.contains('J'))
    {
        if (lettersOfCard1.keys.size == 1 || lettersOfCard1.keys.size == 2 ) first = 7
        else if (lettersOfCard1.keys.size == 3 && lettersOfCard1['J'] == 1 && lettersOfCard1.values.contains(2)) first = 5
        else if (lettersOfCard1.keys.size == 3 ) first = 6
        else if (lettersOfCard1.keys.size == 4) first = 4
        else if (lettersOfCard1.keys.size == 5) first = 2
    }
    if (!lettersOfCard2.keys.contains('J'))
    {
        if (lettersOfCard2.keys.size == 1) second = 7
        else if (lettersOfCard2.keys.size == 2 && lettersOfCard2.values.contains(4)) second = 6
        else if (lettersOfCard2.keys.size == 2) second = 5
        else if (lettersOfCard2.keys.size == 3 && lettersOfCard2.values.contains(3)) second = 4
        else if (lettersOfCard2.keys.size == 3) second = 3
        else if (lettersOfCard2.keys.size == 4) second = 2
        else if (lettersOfCard2.keys.size == 5) second = 1
    }
    else if (lettersOfCard2.keys.contains('J'))
    {
        if (lettersOfCard2.keys.size == 1 || lettersOfCard2.keys.size == 2) second = 7
        else if (lettersOfCard2.keys.size == 3 && lettersOfCard2['J'] == 1 && lettersOfCard2.values.contains(2)) second = 5
        else if (lettersOfCard2.keys.size == 3) second = 6
        else if (lettersOfCard2.keys.size == 4) second = 4
        else if (lettersOfCard2.keys.size == 5) second = 2
    }
    if (first > second) return 1
    else if (first < second) return -1
    else
    {
        for (i in card1.indices)
        {
            if (values[card1[i]]!! > values[card2[i]]!!) return 1
            else if (values[card1[i]]!! < values[card2[i]]!!) return -1
        }
    }
    return 0
}

fun first() : Int {
    var result = 0
    val setsOfCards = mutableMapOf<String, Int>()
    File("D:\\adventofcode\\task_7\\src\\main\\kotlin\\input.txt").forEachLine {
        val values = it.split(" ")
        setsOfCards[values[0]] = values[1].toInt()
    }
    val cards = setsOfCards.keys.toList()
    val sortedCards = cards.sortedWith(::sortCards)
    for (i in sortedCards.indices)
    {
        result += ((i+1) * setsOfCards[sortedCards[i]]!!)
    }
    return result
}


fun second(): Long { // 247514854, 247467999, 247106980 too low, wrong: 247967442
    var result: Long = 0
    val setsOfCards = mutableMapOf<String, Int>()
    File("D:\\adventofcode\\task_7\\src\\main\\kotlin\\input.txt").forEachLine {
        val values = it.split(" ")
        setsOfCards[values[0]] = values[1].toInt()
    }
    val cards = setsOfCards.keys.toList()
    val sortedCards = cards.sortedWith(::sortCards2)
    for (i in sortedCards.indices) {
        result += ((i + 1) * setsOfCards[sortedCards[i]]!!).toLong()
    }
    return result
}