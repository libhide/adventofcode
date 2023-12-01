package advent2023

import advent2021.Day01
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    private val input = Resources.resourceAsListOfString("advent2023/day01.txt")

    @Test
    fun `test part 1`() {
        val sut = Day01(input = input)
        assertThat(sut.solvePart1(input)).isEqualTo(142)
    }

    @Test
    fun `test part 2`() {
        val sut = Day01(input = input)
        assertThat(sut.solvePart2()).isEqualTo(281)
    }
}