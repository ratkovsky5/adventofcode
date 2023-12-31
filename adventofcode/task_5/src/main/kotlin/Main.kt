import java.io.File
import kotlin.math.min

//answers:
//first: 579439039
//second: 7873084

fun main() {
    println(first())
    println(second())
}

fun first() : Long {
    var result : Long = 0
    val lines: List<String> = File("D:\\\\adventofcode\\\\task_5\\\\src\\\\main\\\\kotlin\\\\input.txt").readLines()
    val seeds: MutableList<Long> = mutableListOf()
    val seedToSoil: MutableList<Long> = mutableListOf()
    val soilToFertilizer: MutableList<Long> = mutableListOf()
    val fertilizerToWater: MutableList<Long> = mutableListOf()
    val waterToLight: MutableList<Long> = mutableListOf()
    val lightToTemperature: MutableList<Long> = mutableListOf()
    val temperatureToHumidity: MutableList<Long> = mutableListOf()
    val humidityToLocation: MutableList<Long> = mutableListOf()
    var actualMap = 0
    for (i in lines.indices)
    {
        if (i == 0)
        {
            val regex = Regex("\\d+")
            val matches = regex.findAll(lines[i])
            seeds.addAll(matches.map { it.value.toLong() }.toList())
        }
        if (lines[i].isEmpty())
        {
            actualMap += 1
            continue
        }
        else if (!lines[i][0].isDigit()) continue
        val regex = Regex("\\d+")
        val matches = regex.findAll(lines[i])
        val range = matches.map { it.value.toLong() }.toList()
        if (actualMap == 1)
        {
            seedToSoil.addAll(range)
        }
        else if (actualMap == 2)
        {
            soilToFertilizer.addAll(range)

        }
        else if (actualMap == 3)
        {
            fertilizerToWater.addAll(range)
        }
        else if (actualMap == 4)
        {
            waterToLight.addAll(range)
        }
        else if (actualMap == 5)
        {
            lightToTemperature.addAll(range)
        }
        else if (actualMap == 6)
        {
            temperatureToHumidity.addAll(range)
        }
        else if (actualMap == 7)
        {
            humidityToLocation.addAll(range)
        }
    }
    for (i in seeds.indices)
    {
        var soil : Long = -1
        var fertilizer : Long = -1
        var water : Long = -1
        var light : Long = -1
        var temperature : Long = -1
        var humidity : Long = -1
        var location : Long = -1
        for (j in seedToSoil.indices step 3)
        {
            if (seedToSoil[j+1] <= seeds[i] && seeds[i] < (seedToSoil[j+1] + seedToSoil[j+2]))
            {
                soil = seeds[i] - seedToSoil[j+1] + seedToSoil[j]
                break
            }
        }
        if (soil == (-1).toLong()) soil = seeds[i]
        for (j in soilToFertilizer.indices step 3)
        {
            if (soilToFertilizer[j+1] <= soil && soil < (soilToFertilizer[j+1] + soilToFertilizer[j+2]))
            {
                fertilizer = soil - soilToFertilizer[j+1] + soilToFertilizer[j]
                break
            }
        }
        if (fertilizer == (-1).toLong()) fertilizer = soil
        for (j in fertilizerToWater.indices step 3)
        {
            if (fertilizerToWater[j+1] <= fertilizer && fertilizer < (fertilizerToWater[j+1] + fertilizerToWater[j+2]))
            {
                water = fertilizer - fertilizerToWater[j+1] + fertilizerToWater[j]
                break
            }
        }
        if (water == (-1).toLong()) water = fertilizer
        for (j in waterToLight.indices step 3)
        {
            if (waterToLight[j+1] <= water && water < (waterToLight[j+1] + waterToLight[j+2]))
            {
                light = water - waterToLight[j+1] + waterToLight[j]
                break
            }
        }
        if (light == (-1).toLong()) light = water
        for (j in lightToTemperature.indices step 3)
        {
            if (lightToTemperature[j+1] <= light && light < (lightToTemperature[j+1] + lightToTemperature[j+2]))
            {
                temperature = light - lightToTemperature[j+1] + lightToTemperature[j]
                break
            }
        }
        if (temperature == (-1).toLong()) temperature = light
        for (j in temperatureToHumidity.indices step 3)
        {
            if (temperatureToHumidity[j+1] <= temperature && temperature < (temperatureToHumidity[j+1] + temperatureToHumidity[j+2]))
            {
                humidity = temperature - temperatureToHumidity[j+1] + temperatureToHumidity[j]
                break
            }
        }
        if (humidity == (-1).toLong()) humidity = temperature
        for (j in humidityToLocation.indices step 3)
        {
            if (humidityToLocation[j+1] <= humidity && humidity < (humidityToLocation[j+1] + humidityToLocation[j+2]))
            {
                location = humidity - humidityToLocation[j+1] + humidityToLocation[j]
                break
            }
        }
        if (location == (-1).toLong()) location = humidity
        result = if (result == 0.toLong()) location else min(result, location)
    }
    return result
}

fun second(): Long {
    var result : Long = 0
    val lines: List<String> = File("D:\\\\adventofcode\\\\task_5\\\\src\\\\main\\\\kotlin\\\\input.txt").readLines()
    val seeds: MutableList<Long> = mutableListOf()
    val seedToSoil: MutableList<Long> = mutableListOf()
    val soilToFertilizer: MutableList<Long> = mutableListOf()
    val fertilizerToWater: MutableList<Long> = mutableListOf()
    val waterToLight: MutableList<Long> = mutableListOf()
    val lightToTemperature: MutableList<Long> = mutableListOf()
    val temperatureToHumidity: MutableList<Long> = mutableListOf()
    val humidityToLocation: MutableList<Long> = mutableListOf()
    var actualMap = 0
    for (i in lines.indices)
    {
        if (i == 0)
        {
            val regex = Regex("\\d+")
            val matches = regex.findAll(lines[i])
            seeds.addAll(matches.map { it.value.toLong() }.toList())
        }
        if (lines[i].isEmpty())
        {
            actualMap += 1
            continue
        }
        else if (!lines[i][0].isDigit()) continue
        val regex = Regex("\\d+")
        val matches = regex.findAll(lines[i])
        val range = matches.map { it.value.toLong() }.toList()
        if (actualMap == 1)
        {
            seedToSoil.addAll(range)
        }
        else if (actualMap == 2)
        {
            soilToFertilizer.addAll(range)

        }
        else if (actualMap == 3)
        {
            fertilizerToWater.addAll(range)
        }
        else if (actualMap == 4)
        {
            waterToLight.addAll(range)
        }
        else if (actualMap == 5)
        {
            lightToTemperature.addAll(range)
        }
        else if (actualMap == 6)
        {
            temperatureToHumidity.addAll(range)
        }
        else if (actualMap == 7)
        {
            humidityToLocation.addAll(range)
        }
    }
    for (i in seeds.indices step 2)
    {
        for (k in seeds[i] until seeds[i] + seeds[i+1])
        {
            var soil : Long = -1
            var fertilizer : Long = -1
            var water : Long = -1
            var light : Long = -1
            var temperature : Long = -1
            var humidity : Long = -1
            var location : Long = -1
            for (j in seedToSoil.indices step 3)
            {
                if (seedToSoil[j+1] <= k && k < (seedToSoil[j+1] + seedToSoil[j+2]))
                {
                    soil = k - seedToSoil[j+1] + seedToSoil[j]
                    break
                }
            }
            if (soil == (-1).toLong()) soil = k
            for (j in soilToFertilizer.indices step 3)
            {
                if (soilToFertilizer[j+1] <= soil && soil < (soilToFertilizer[j+1] + soilToFertilizer[j+2]))
                {
                    fertilizer = soil - soilToFertilizer[j+1] + soilToFertilizer[j]
                    break
                }
            }
            if (fertilizer == (-1).toLong()) fertilizer = soil
            for (j in fertilizerToWater.indices step 3)
            {
                if (fertilizerToWater[j+1] <= fertilizer && fertilizer < (fertilizerToWater[j+1] + fertilizerToWater[j+2]))
                {
                    water = fertilizer - fertilizerToWater[j+1] + fertilizerToWater[j]
                    break
                }
            }
            if (water == (-1).toLong()) water = fertilizer
            for (j in waterToLight.indices step 3)
            {
                if (waterToLight[j+1] <= water && water < (waterToLight[j+1] + waterToLight[j+2]))
                {
                    light = water - waterToLight[j+1] + waterToLight[j]
                    break
                }
            }
            if (light == (-1).toLong()) light = water
            for (j in lightToTemperature.indices step 3)
            {
                if (lightToTemperature[j+1] <= light && light < (lightToTemperature[j+1] + lightToTemperature[j+2]))
                {
                    temperature = light - lightToTemperature[j+1] + lightToTemperature[j]
                    break
                }
            }
            if (temperature == (-1).toLong()) temperature = light
            for (j in temperatureToHumidity.indices step 3)
            {
                if (temperatureToHumidity[j+1] <= temperature && temperature < (temperatureToHumidity[j+1] + temperatureToHumidity[j+2]))
                {
                    humidity = temperature - temperatureToHumidity[j+1] + temperatureToHumidity[j]
                    break
                }
            }
            if (humidity == (-1).toLong()) humidity = temperature
            for (j in humidityToLocation.indices step 3)
            {
                if (humidityToLocation[j+1] <= humidity && humidity < (humidityToLocation[j+1] + humidityToLocation[j+2]))
                {
                    location = humidity - humidityToLocation[j+1] + humidityToLocation[j]
                    break
                }
            }
            if (location == (-1).toLong()) location = humidity
            result = if (result == 0.toLong()) location else min(result, location)
        }
    }
    return result
}
