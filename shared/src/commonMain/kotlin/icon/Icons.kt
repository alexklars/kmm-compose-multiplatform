package icon

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath

// TODO Copied from "material:material-icons-extended", because this artifacts are not working on iOS for now

object Icons {

    val PlayArrow = materialIcon(name = "Rounded.PlayArrow") {
        materialPath {
            moveTo(8.0f, 6.82f)
            verticalLineToRelative(10.36f)
            curveToRelative(0.0f, 0.79f, 0.87f, 1.27f, 1.54f, 0.84f)
            lineToRelative(8.14f, -5.18f)
            curveToRelative(0.62f, -0.39f, 0.62f, -1.29f, 0.0f, -1.69f)
            lineTo(9.54f, 5.98f)
            curveTo(8.87f, 5.55f, 8.0f, 6.03f, 8.0f, 6.82f)
            close()
        }
    }

    val Pause = materialIcon(name = "Rounded.Pause") {
        materialPath {
            moveTo(8.0f, 19.0f)
            curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
            lineTo(10.0f, 7.0f)
            curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
            reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f)
            verticalLineToRelative(10.0f)
            curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
            close()
            moveTo(14.0f, 7.0f)
            verticalLineToRelative(10.0f)
            curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
            reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f)
            lineTo(18.0f, 7.0f)
            curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
            reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f)
            close()
        }
    }

    val SkipNext = materialIcon(name = "Rounded.SkipNext") {
        materialPath {
            moveTo(7.58f, 16.89f)
            lineToRelative(5.77f, -4.07f)
            curveToRelative(0.56f, -0.4f, 0.56f, -1.24f, 0.0f, -1.63f)
            lineTo(7.58f, 7.11f)
            curveTo(6.91f, 6.65f, 6.0f, 7.12f, 6.0f, 7.93f)
            verticalLineToRelative(8.14f)
            curveToRelative(0.0f, 0.81f, 0.91f, 1.28f, 1.58f, 0.82f)
            close()
            moveTo(16.0f, 7.0f)
            verticalLineToRelative(10.0f)
            curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
            reflectiveCurveToRelative(1.0f, -0.45f, 1.0f, -1.0f)
            verticalLineTo(7.0f)
            curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f)
            reflectiveCurveToRelative(-1.0f, 0.45f, -1.0f, 1.0f)
            close()
        }
    }

    val SkipPrevious = materialIcon(name = "Rounded.SkipPrevious") {
        materialPath {
            moveTo(7.0f, 6.0f)
            curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f)
            verticalLineToRelative(10.0f)
            curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f)
            reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f)
            lineTo(6.0f, 7.0f)
            curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f)
            close()
            moveTo(10.66f, 12.82f)
            lineToRelative(5.77f, 4.07f)
            curveToRelative(0.66f, 0.47f, 1.58f, -0.01f, 1.58f, -0.82f)
            lineTo(18.01f, 7.93f)
            curveToRelative(0.0f, -0.81f, -0.91f, -1.28f, -1.58f, -0.82f)
            lineToRelative(-5.77f, 4.07f)
            curveToRelative(-0.57f, 0.4f, -0.57f, 1.24f, 0.0f, 1.64f)
            close()
        }
    }

    val MoreVert = materialIcon(name = "Filled.MoreVert") {
        materialPath {
            moveTo(12.0f, 8.0f)
            curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
            reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
            reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f)
            reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
            close()
            moveTo(12.0f, 10.0f)
            curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
            reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
            reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f)
            reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
            close()
            moveTo(12.0f, 16.0f)
            curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
            reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f)
            reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f)
            reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f)
            close()
        }
    }

    val ArrowBackIos = materialIcon(name = "Rounded.ArrowBackIos") {
        materialPath {
            moveTo(16.62f, 2.99f)
            curveToRelative(-0.49f, -0.49f, -1.28f, -0.49f, -1.77f, 0.0f)
            lineTo(6.54f, 11.3f)
            curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f)
            lineToRelative(8.31f, 8.31f)
            curveToRelative(0.49f, 0.49f, 1.28f, 0.49f, 1.77f, 0.0f)
            reflectiveCurveToRelative(0.49f, -1.28f, 0.0f, -1.77f)
            lineTo(9.38f, 12.0f)
            lineToRelative(7.25f, -7.25f)
            curveToRelative(0.48f, -0.48f, 0.48f, -1.28f, -0.01f, -1.76f)
            close()
        }
    }

    val Album = materialIcon(name = "Rounded.Album") {
        materialPath {
            moveTo(12.0f, 2.0f)
            curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f)
            reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f)
            reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f)
            reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f)
            close()
            moveTo(12.0f, 16.5f)
            curveToRelative(-2.49f, 0.0f, -4.5f, -2.01f, -4.5f, -4.5f)
            reflectiveCurveTo(9.51f, 7.5f, 12.0f, 7.5f)
            reflectiveCurveToRelative(4.5f, 2.01f, 4.5f, 4.5f)
            reflectiveCurveToRelative(-2.01f, 4.5f, -4.5f, 4.5f)
            close()
            moveTo(12.0f, 11.0f)
            curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
            reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f)
            reflectiveCurveToRelative(1.0f, -0.45f, 1.0f, -1.0f)
            reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f)
            close()
        }
    }
}
