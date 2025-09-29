package systems.boos.xpdbumm.gameoflife

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UniverseViewModel : ViewModel() {
    private var aliveCells: MutableSet<Cell> = mutableSetOf()
    private val _uiState = MutableStateFlow(aliveCells.toUniverseUiState())
    val uiState: StateFlow<UniverseUiState> = _uiState.asStateFlow()

    fun goToNextGeneration() {
        aliveCells.add(Cell(0, 0))
        val nextState = aliveCells.toUniverseUiState()
        _uiState.update { _ -> nextState }
    }
}