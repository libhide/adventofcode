package advent2021

import Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    private val input = Resources.resourceAsListOfString("advent2021/day05.txt")

    @Test
    fun `test part 1`() {
        val sut = Day05(input = input)
        assertThat(sut.solvePart1()).isEqualTo(5)
    }

    @Test
    fun `test part 2`() {
        val sut = Day05(input = input)
        assertThat(sut.solvePart2()).isEqualTo(12)
    }
}