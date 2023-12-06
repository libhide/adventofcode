package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day06Test {

    private val input = Resources.resourceAsListOfString("advent2023/day06.txt")

    @Test
    fun `test part 1`() {
        val sut = Day06(input = input)
        assertThat(sut.solvePart1()).isEqualTo(288)
    }

    @Test
    fun `test part 2`() {
        val sut = Day06(input = input)
        assertThat(sut.solvePart2()).isEqualTo(71503)
    }
}