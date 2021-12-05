package advent2021

import Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Test {

    private val input = Resources.resourceAsListOfString("advent2021/day04.txt")

    @Test
    fun `test part 1`() {
        val sut = Day04(input = input)
        assertThat(sut.solvePart1()).isEqualTo(4512)
    }

    @Test
    fun `test part 2`() {
        val sut = Day04(input = input)
        assertThat(sut.solvePart2()).isEqualTo(1924)
    }
}