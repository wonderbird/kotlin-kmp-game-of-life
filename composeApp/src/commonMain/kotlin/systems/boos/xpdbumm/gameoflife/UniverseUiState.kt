package systems.boos.xpdbumm.gameoflife

data class UniverseUiState(
    val universeAsText: String = "",
)

fun MutableSet<Cell>.toUniverseUiState(): UniverseUiState {
    val alive = "█"
    val dead = " "
    val sb2 = StringBuilder()

    // line up all cells in a single row universe
    val cellIndices = listOf(-1) + this.map { (column, row) -> row * 5 + column } + listOf(26)
    val deadCellDistances = cellIndices.zipWithNext().map { (first, second) -> second - first - 1 }

    sb2.append(dead.repeat(deadCellDistances.first()))

    for (deadCellDistance in deadCellDistances.drop(1)) {
        sb2.append(alive)
        sb2.append(dead.repeat(deadCellDistance))
    }

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

    return UniverseUiState(sb.toString())
}