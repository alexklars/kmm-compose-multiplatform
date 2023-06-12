package ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import icon.Icons
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url


@Composable
fun AlbumArtComponent(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String = "Album art",
    placeholder: ImageVector = Icons.Album,
) {
    KamelImage(
        modifier = modifier,
        resource = asyncPainterResource(
            data = Url(url!!) // todo
        ),
        contentDescription = contentDescription,
        onFailure = {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Album,
                tint = Color.LightGray,
                contentDescription = contentDescription,
            )
        },
        contentScale = ContentScale.Crop,
    )
}
