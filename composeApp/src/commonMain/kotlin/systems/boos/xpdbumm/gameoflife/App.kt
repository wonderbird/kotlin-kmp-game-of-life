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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var renderedUniverse by remember {
            mutableStateOf(
                """
                  01234  
                0 ██    0
                1 █     1
                2       2
                3       3
                4       4
                  01234  
                """.trimIndent(),
            )
        }
        var universeView: UniverseView = UniverseView()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                Modifier
                    .padding(20.dp)
                    .safeContentPadding()
                    .fillMaxSize(),
        ) {
            OutlinedTextField(
                value = universeView.asString(),
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
                onClick = {},
                modifier = Modifier.padding(top = 10.dp),
            ) {
                Text("Next Generation")
            }
        }
    }
}