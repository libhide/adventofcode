package advent2021

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int = input
        .zipWithNext()
        .count { it.first < it.second }

    fun solvePart2(): Int = input
        .windowed(3, 1)
        .map { it.sum() }
        .zipWithNext()
        .count { it.first < it.second }
}

fun main() {
    val input = Resources.resourceAsListOfInt("advent2021/day01.txt")
    val day01 = Day01(input = input)
    println("Part 1 Solution: ${day01.solvePart1()}")
    println("Part 2 Solution: ${day01.solvePart2()}")
}