package advent2023

import advent2023.shared.Point2D

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        val coordinates = mutableSetOf<Point2D>()
        val grid = input.map { line -> line.map { char -> char } }

        grid.forEachIndexed { rowIndex, line ->
            line.forEachIndexed { colIndex, char ->
                // If valid symbol
                if (!char.isDigit() && char != '.') {
                    // Check adjacent box for a digit
                    ((rowIndex - 1)..(rowIndex + 1)).forEach { r ->
                        ((colIndex - 1)..(colIndex + 1)).forEach { c ->
                            // Boundary conditions
                            if (r >= 0 && r < grid.size && c >= 0 && c < grid[r].size) {
                                if (grid[r][c].isDigit()) {
                                    // We have a number! Find the point of its first digit
                                    var temp = c
                                    while (temp > 0 && grid[r][temp - 1].isDigit()) {
                                        temp -= 1
                                    }
                                    coordinates.add(Point2D(r, temp))
                                }
                            }
                        }
                    }
                }
            }
        }
        val partNumbers = coordinates.map { coord -> coord.determineNumber(grid) }
        return partNumbers.sum()
    }

    fun solvePart2(): Int {
        val coordinates = mutableListOf<Pair<Point2D, Point2D>>()
        val grid = input.map { line -> line.map { char -> char } }

        grid.forEachIndexed { rowIndex, line ->
            line.forEachIndexed { colIndex, char ->
                // Condition for identifying a Gear
                if (char == '*') {
                    val gearSet = mutableSetOf<Point2D>()
                    // Check adjacent box for a digit
                    ((rowIndex - 1)..(rowIndex + 1)).forEach { r ->
                        ((colIndex - 1)..(colIndex + 1)).forEach { c ->
                            if (r >= 0 && r < grid.size && c >= 0 && c < grid[r].size) {
                                if (grid[r][c].isDigit()) {
                                    // We have a number! Find the point of its first digit
                                    var temp = c
                                    while (temp > 0 && grid[r][temp - 1].isDigit()) {
                                        temp -= 1
                                    }
                                    gearSet.add(Point2D(r, temp))
                                }
                            }
                        }
                    }
                    if (gearSet.size == 2) {
                        coordinates.add(Pair(gearSet.first(), gearSet.last()))
                    }
                }
            }
        }
        val partNumbers = coordinates.map { gearSet ->
            val first = gearSet.first.determineNumber(grid)
            val second = gearSet.second.determineNumber(grid)
            first * second
        }
        return partNumbers.sum()
    }

    private fun Point2D.determineNumber(grid: List<List<Char>>): Int {
        val stringBuilder = StringBuilder()
        var temp = y
        while (temp < grid[x].size && grid[x][temp].isDigit()) {
            stringBuilder.append(grid[x][temp])
            temp += 1
        }
        return stringBuilder.toString().toInt()
    }
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2023/day03.txt")
    val day03 = Day03(input = input)
    println("Part 1 Solution: ${day03.solvePart1()}")
    println("Part 2 Solution: ${day03.solvePart2()}")
}