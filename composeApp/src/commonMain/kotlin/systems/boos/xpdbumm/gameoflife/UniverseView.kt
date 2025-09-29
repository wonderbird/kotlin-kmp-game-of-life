package systems.boos.xpdbumm.gameoflife

class UniverseView {
    var aliveCells: MutableSet<Cell> =
        mutableSetOf(
            Cell(0, 0),
            Cell(1, 0),
            Cell(0, 1),
        )

    fun asString(): String = aliveCells.toUniverse()
}

fun MutableSet<Cell>.toUniverse(): String {
    val alive = "█"
    val dead = " "
    val sb2 = StringBuilder()

    // line up all cells in a single row universe
    var numberOfDeadCells = 25

    if (this.count() > 0) {
        sb2.append(alive)
        numberOfDeadCells -= 1
    }

    sb2.append(dead.repeat(numberOfDeadCells))
    val entireUniverseAsSingleRow = sb2.toString()

    // change universe format to 5x5
    val universeRows = entireUniverseAsSingleRow.chunked(5)

    // decorate the universe by indices
    val sb = StringBuilder()
    sb.append("  01234  \n")
    for (rowIndex in 0..4) {
        sb.append("$rowIndex ${universeRows.elementAt(rowIndex)} $rowIndex\n")
    }
    sb.append("  01234  ")

    return sb.toString()
}