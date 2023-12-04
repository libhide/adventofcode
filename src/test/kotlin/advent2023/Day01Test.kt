package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun `test part 1`() {
        val rawInput = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()
        val input = rawInput.split("\n")
        val sut = Day01(input = input)
        assertThat(sut.solvePart1(input)).isEqualTo(142)
    }

    @Test
    fun `test part 2`() {
        val rawInput = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()
        val input = rawInput.split("\n")
        val sut = Day01(input = input)
        assertThat(sut.solvePart2()).isEqualTo(281)
    }
}