package advent2021

import Resources
import advent2021.Day02.DIRECTIVE.DOWN
import advent2021.Day02.DIRECTIVE.FORWARD
import advent2021.Day02.DIRECTIVE.UP

class Day02(input: List<String>) {

    private val commands = input.map { Command.of(it) }

    private enum class DIRECTIVE { FORWARD, UP, DOWN }

    private class Command(val directive: DIRECTIVE, val amount: Int) {
        companion object {
            fun of(input: String) = input.split(" ").let {
                Command(
                    directive = DIRECTIVE.valueOf(it.first().uppercase()),
                    amount = it.last().toInt()
                )
            }
        }
    }

    private data class Submarine(
        val depth: Int = 0,
        val position: Int = 0,
        val aim: Int = 0
    ) {
        fun answer() = depth * position

        fun movePart1(command: Command): Submarine =
            when (command.directive) {
                FORWARD -> copy(position = position + command.amount)
                DOWN -> copy(depth = depth + command.amount)
                UP -> copy(depth = depth - command.amount)
            }

        fun movePart2(command: Command) =
            when (command.directive) {
                FORWARD -> copy(
                    position = position + command.amount,
                    depth = depth + (aim * command.amount)
                )
                DOWN -> copy(aim = aim + command.amount)
                UP -> copy(aim = aim - command.amount)
            }
    }

    fun solvePart1(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart1(command) }.answer()

    fun solvePart2(): Int =
        commands.fold(Submarine()) { submarine, command -> submarine.movePart2(command) }.answer()
}

fun main() {
    val input = Resources.resourceAsListOfString("advent2021/day02.txt")
    val day = Day02(input = input)
    println("Part 1: ${day.solvePart1()}")
    println("Part 2: ${day.solvePart2()}")
}