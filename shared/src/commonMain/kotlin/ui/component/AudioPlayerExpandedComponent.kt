package ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.PlayerUI
import icon.Icons

@Composable
fun AudioPlayerExpandedComponent(
    modifier: Modifier = Modifier,
    playerUI: PlayerUI,
    onBackClick: () -> Unit,
) {
    Scaffold(modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButtonComponent(
                    icon = Icons.ArrowBackIos,
                    contentDescription = "Back",
                    size = 24.dp,
                    onClick = onBackClick
                )
                IconButtonComponent(
                    icon = Icons.MoreVert,
                    contentDescription = "More",
                    size = 24.dp,
                    onClick = {}
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 36.dp
                )
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            AlbumArtComponent(
                modifier = Modifier.size(400.dp)
                    .align(Alignment.CenterHorizontally),
                url = playerUI.albumArtUri
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = playerUI.title,
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = playerUI.artist,
                style = MaterialTheme.typography.body1
            )
            SliderComponent(
                modifier = Modifier.padding(top = 28.dp),
                value = playerUI.currentPosition,
                valueRange = playerUI.progressRange,
                thumbRadius = 0.dp,
                onValueChange = {}
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = playerUI.remainingTime,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = playerUI.duration,
                    style = MaterialTheme.typography.caption
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonComponent(
                    icon = Icons.SkipPrevious,
                    contentDescription = "Play previous",
                    size = 48.dp,
                    onClick = {}
                )
                IconButtonComponent(
                    icon = Icons.PlayArrow,
                    contentDescription = "Play",
                    size = 96.dp,
                    onClick = {}
                )
                IconButtonComponent(
                    icon = Icons.SkipNext,
                    contentDescription = "Play next",
                    size = 48.dp,
                    onClick = {}
                )
            }
        }
    }
}