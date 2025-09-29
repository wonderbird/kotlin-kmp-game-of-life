package systems.boos.xpdbumm.gameoflife

import kotlin.test.Test
import kotlin.test.assertEquals

class UniverseViewTest {
    @Test
    fun toUniverse_noAliveCells() {
        val aliveCells: MutableSet<Cell> = mutableSetOf()

        val actual = aliveCells.toUniverse()

        val expected =
            """
              01234  
            0       0
            1       1
            2       2
            3       3
            4       4
              01234  
            """.trimIndent()
        assertEquals(expected, actual)
    }

    @Test
    fun toUniverse_singleAliveCellInFirstRow() {
        val aliveCells: MutableSet<Cell> = mutableSetOf(Cell(0, 0))

        val actual = aliveCells.toUniverse()

        val expected =
            """
              01234  
            0 █     0
            1       1
            2       2
            3       3
            4       4
              01234  
            """.trimIndent()
        assertEquals(expected, actual)
    }
}