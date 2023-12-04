package advent2023

import kotlin.math.pow

private const val CARD = "Card"
private const val COLON_SEPARATOR = ":"

class Day04(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.sumOf { card ->
            val matchCount = findMatchCountForCard(card)
            2.0.pow(matchCount - 1).toInt()
        }
    }

    fun solvePart2(): Int {
        val cardToTotalCount = mutableMapOf<Int, Int>()

        val cardToMatchCount = input.map { card ->
            val cardNumber = card.substringAfter(CARD)
                .substringBefore(COLON_SEPARATOR)
                .trim()
                .toInt()
                .also {
                    // init `cardToTotalCount` with each card occurring once
                    cardToTotalCount[it] = 1
                }
            cardNumber to findMatchCountForCard(card)
        }

        cardToMatchCount.forEach { (cardNumber, matchCount) ->
            repeat(matchCount) {
                cardToTotalCount[cardNumber + it + 1] =
                    checkNotNull(cardToTotalCount[cardNumber + it + 1]) + checkNotNull(cardToTotalCount[cardNumber])
            }
        }

        return cardToTotalCount.map { it.value }.sum()
    }

    private fun findMatchCountForCard(cardInfo: String): Int {
        val numbers = cardInfo.split(":").last().split("|")

        val winningNumbers = numbers
            .first()
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { it.toInt() }
        val cardsInHand = numbers
            .last()
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { it.toInt() }

        var count = 0
        cardsInHand.forEach { number ->
            if (number in winningNumbers) {
                count += 1
            }
        }
        return count
    }
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2023/day04.txt")
    val day04 = Day04(input = input)
    println("Part 1 Solution: ${day04.solvePart1()}")
    println("Part 2 Solution: ${day04.solvePart2()}")
}