package advent2023

private const val COLON_DELIMITER = ":"

class Day06(private val input: List<String>) {

    fun solvePart1(): Int {
        val times =
            input.first().split(COLON_DELIMITER).last().split(" ").filter { it.isNotBlank() }.map { it.toLong() }
        val distances =
            input.last().split(COLON_DELIMITER).last().split(" ").filter { it.isNotBlank() }.map { it.toLong() }

        val timeToDistance = times.mapIndexed { index, time ->
            time to distances[index]
        }.toMap()

        val numberOfWays = computeNumberOfWaysToWin(timeToDistance)
        return numberOfWays.reduce { acc, element -> acc * element }
    }

    fun solvePart2(): Int {
        val time = input.first().split(COLON_DELIMITER).last().filter { it.isDigit() }.toLong()
        val distance =
            input.last().split(COLON_DELIMITER).last().filter { it.isDigit() }.toLong()
        val timeToDistance = mapOf(time to distance)
        val numberOfWays = computeNumberOfWaysToWin(timeToDistance)
        return numberOfWays.reduce { acc, element -> acc * element }
    }

    private fun computeNumberOfWaysToWin(timeToDistance: Map<Long, Long>): List<Int> {
        return timeToDistance.keys.map { time ->
            (0..time).map { buttonHoldTime ->
                buttonHoldTime * (time - buttonHoldTime)
            }.count { distanceTravelled ->
                distanceTravelled > (timeToDistance[time] ?: 0)
            }
        }
    }
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2023/day06.txt")
    val day06 = Day06(input = input)
    println("Part 1 Solution: ${day06.solvePart1()}")
    println("Part 2 Solution: ${day06.solvePart2()}")
}