package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    private val input = Resources.resourceAsText("advent2023/day05.txt")

    @Test
    fun `test part 1`() {
        val sut = Day05(input = input)
        assertThat(sut.solvePart1()).isEqualTo(35)
    }

    @Test
    fun `test part 2`() {
        val sut = Day05(input = input)
        assertThat(sut.solvePart2()).isEqualTo(46)
    }
}