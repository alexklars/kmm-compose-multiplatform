package ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("LongParameterList")
@Composable
fun IconButtonComponent(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    tint: Color = Color.Black,
    size: Dp = 24.dp,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier.wrapContentSize(),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(size),
            imageVector = icon,
            tint = tint,
            contentDescription = contentDescription,
        )
    }
}
