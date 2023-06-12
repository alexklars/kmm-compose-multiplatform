import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import data.PlayerUIData
import ui.component.AudioPlayerExpandedComponent

@Composable
fun App() {
    MaterialTheme {
        AudioPlayerExpandedComponent(
            playerUI = PlayerUIData.playerUI,
            onBackClick = {},
        )
    }
}

expect fun getPlatformName(): String