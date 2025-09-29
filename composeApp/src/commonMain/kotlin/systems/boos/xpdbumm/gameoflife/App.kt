package systems.boos.xpdbumm.gameoflife

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: UniverseViewModel = viewModel { UniverseViewModel() }) {
    MaterialTheme {
        val uiState by viewModel.uiState.collectAsState()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                Modifier
                    .padding(20.dp)
                    .safeContentPadding()
                    .fillMaxSize(),
        ) {
            OutlinedTextField(
                value = uiState.universeAsText,
                label = { Text("Universe") },
                textStyle =
                    TextStyle(
                        fontFamily = FontFamily.Monospace,
                        lineHeight = 1.em,
                    ),
                minLines = 7,
                maxLines = 7,
                readOnly = true,
                onValueChange = { },
            )
            Button(
                onClick = { viewModel.goToNextGeneration() },
                modifier = Modifier.padding(top = 10.dp),
            ) {
                Text("Next Generation")
            }
        }
    }
}