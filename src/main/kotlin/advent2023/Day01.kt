package advent2023

class Day01(private val input: List<String>) {

    private val validNumberNames = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )

    fun solvePart1(values: List<String>): Int {
        return values.map { calibrationValue ->
            calibrationValue.filter { it.isDigit() }
        }.map { digits ->
            Pair(digits.first(), digits.last())
        }.sumOf { "${it.first}${it.second}".toInt() }
    }

    fun solvePart2(): Int {
        val regexPattern = validNumberNames.keys.joinToString("|") { Regex.escape(it) }.toRegex()
        val moddedInput = input.map { line ->
            var parsedLine = line.replace("twone", "twoone")
                .replace("eightwo", "eighttwo")
                .replace("oneight", "oneeight")
            parsedLine = regexPattern.replace(parsedLine) { matchResult ->
                validNumberNames[matchResult.value] ?: ""
            }
            parsedLine
        }
        return solvePart1(values = moddedInput)
    }
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2023/day01.txt")
    val day01 = Day01(input = input)
    println("Part 1 Solution: ${day01.solvePart1(input)}")
    println("Part 2 Solution: ${day01.solvePart2()}")
}