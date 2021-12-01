import Resources.resourceAsListOfInt
import Resources.resourceAsListOfLong
import Resources.resourceAsListOfString
import Resources.resourceAsString
import Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ResourcesTest {

    @Nested
    inner class ResourceAsStringTests {
        @Test
        fun `concatenates lines without delimiter`() {
            assertThat(resourceAsString("fake_input.txt"))
                .isEqualTo("123")
        }

        @Test
        fun `concatenates lines with delimiter`() {
            assertThat(resourceAsString(fileName = "fake_input.txt", delimiter = ":::"))
                .isEqualTo("1:::2:::3")
        }

        @Test
        fun `throws exception when file does not exist`() {
            assertThatThrownBy {
                resourceAsString("this_does_not_exist.txt", delimiter = "???")
            }.isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Nested
    inner class ResourceAsTextTests {
        @Test
        fun `reads file as-is into one String`() {
            assertThat(resourceAsText("fake_input.txt"))
                .isEqualTo("""
                    1
                    2
                    3
                """.trimIndent())
        }
    }

    @Nested
    inner class ResourceAsListTests {
        @Test
        fun `reads lines as Strings`() {
            assertThat(resourceAsListOfString("fake_input.txt"))
                .hasSize(3)
                .containsExactly("1", "2", "3")
        }

        @Test
        fun `reads lines as Ints`() {
            assertThat(resourceAsListOfInt("fake_input.txt"))
                .hasSize(3)
                .containsExactly(1, 2, 3)
        }

        @Test
        fun `reads lines as Longs`() {
            assertThat(resourceAsListOfLong("fake_input.txt"))
                .hasSize(3)
                .containsExactly(1L, 2L, 3L)
        }

        @Test
        fun `throws exception when file does not exist`() {
            assertThatThrownBy {
                resourceAsListOfString("this_does_not_exist.txt")
            }.isInstanceOf(IllegalArgumentException::class.java)
        }
    }

}