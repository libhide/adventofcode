package advent2023

internal const val MAX_RED_CUBES = 12
internal const val MAX_GREEN_CUBES = 13
internal const val MAX_BLUE_CUBES = 14

internal const val RED = "red"
internal const val GREEN = "green"
internal const val BLUE = "blue"

internal data class Game(
    val id: Int, val draws: List<Map<String, Int>>
)

class Day02(private val input: List<String>) {

    fun solvePart1(): Int {
        return input
            .map { gameData -> parseGameData(gameData = gameData) }
            .filter { game ->
                game.draws.all {
                    it[RED]!! <= MAX_RED_CUBES && it[GREEN]!! <= MAX_GREEN_CUBES && it[BLUE]!! <= MAX_BLUE_CUBES
                }
            }.sumOf { it.id }
    }

    fun solvePart2(): Int {
        val powers =
            input
                .asSequence()
                .map { gameData -> parseGameData(gameData = gameData) }
                .map { game -> game.draws }
                .map { gameDraws ->
                    val maxValues = mutableMapOf<String, Int>()
                    for (draws in gameDraws) {
                        for ((key, value) in draws) {
                            maxValues[key] = maxOf(maxValues[key] ?: Int.MIN_VALUE, value)
                        }
                    }
                    maxValues
                }.map { it.values.toList() }
                .map {
                    it.reduce { acc, element -> acc * element }
                }.toList()
        return powers.sum()
    }

    private fun parseGameData(gameData: String): Game {
        val (gameIdText, gameDrawsText) = gameData.split(":")

        val gameIdRegex = Regex("\\d+")
        val gameIdMatch = gameIdRegex.find(gameIdText)
        val gameId = gameIdMatch!!.value.toInt()

        val gameDraws = gameDrawsText.split(";").map { it.trim().split(", ") }.map { entries ->
            val colorCountMap = mutableMapOf(GREEN to 0, RED to 0, BLUE to 0)
            entries.forEach { entry ->
                val (count, color) = entry.split(" ")
                colorCountMap[color] = count.toInt()
            }
            colorCountMap
        }

        return Game(gameId, gameDraws)
    }
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2023/day02.txt")
    val day02 = Day02(input = input)
    println("Part 1 Solution: ${day02.solvePart1()}")
    println("Part 1 Solution: ${day02.solvePart2()}")
}