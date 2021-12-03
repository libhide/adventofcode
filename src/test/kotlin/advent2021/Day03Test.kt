package advent2021

import Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Test {

    private val input = Resources.resourceAsListOfString("advent2021/day03.txt")

    @Test
    fun `test part 1`() {
        val sut = Day03(input = input)
        assertThat(sut.solvePart1()).isEqualTo(198)
    }

    @Test
    fun `test part 2`() {
        val sut = Day03(input = input)
        assertThat(sut.solvePart2()).isEqualTo(230)
    }
}