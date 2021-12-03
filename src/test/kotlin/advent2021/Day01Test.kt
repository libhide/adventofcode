package advent2021

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    private val input = Resources.resourceAsListOfInt("advent2021/day01.txt")

    @Test
    fun `test part 1`() {
        val sut = Day01(input = input)
        assertThat(sut.solvePart1()).isEqualTo(7)
    }

    @Test
    fun `test part 2`() {
        val sut = Day01(input = input)
        assertThat(sut.solvePart2()).isEqualTo(5)
    }
}