package advent2021

import Resources
import advent2021.shared.Point2d

class Day05(input: List<String>) {

    private val instructions = input.map { parseRow(it) }

    fun solvePart1(): Int =
        solve { it.first sharesAxisWith it.second }

    fun solvePart2(): Int =
        solve { true }

    private fun solve(lineFilter: (Pair<Point2d, Point2d>) -> Boolean) =
        instructions
            .filter { lineFilter(it) }
            .flatMap { it.first lineTo it.second }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }

    private fun parseRow(input: String): Pair<Point2d, Point2d> =
        Pair(
            input.substringBefore(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) },
            input.substringAfterLast(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) }
        )
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2021/day05.txt")
    val day = Day05(input = input)
    println("Part 1: ${day.solvePart1()}")
    println("Part 2: ${day.solvePart2()}")
}