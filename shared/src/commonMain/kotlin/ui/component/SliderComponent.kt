package ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import utils.calculateFraction
import utils.scale


@Composable
fun SliderComponent(
    modifier: Modifier = Modifier,
    value: Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    valueChangeEnabled: Boolean = true,
    onValueChange: ((Float) -> Unit)? = null,
    onValueChangeFinished: (() -> Unit)? = null,
    trackRoundCorners: Boolean = true,
    trackHeight: Dp = 8.dp,
    thumbRadius: Dp = 8.dp,
    activeTrackColor: Color = Color.Blue,
    inactiveTrackColor: Color = Color.LightGray,
) {
    val onValueChangeState = rememberUpdatedState(onValueChange)
    val onValueChangeFinishedState = rememberUpdatedState(onValueChangeFinished)

    BoxWithConstraints(
        modifier = modifier
            .wrapContentSize()
            .requiredSizeIn(
                minHeight = thumbRadius * 2
            ),
        contentAlignment = Alignment.CenterStart
    ) {

        val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

        val width = constraints.maxWidth.toFloat()
        val thumbRadiusInPx: Float

        // Start of the track used for measuring progress,
        // it's line + radius of cap which is half of height of track
        // to draw this on canvas starting point of line
        // should be at trackStart + trackHeightInPx / 2 while drawing
        val trackStart: Float
        // End of the track that is used for measuring progress
        val trackEnd: Float
        val strokeRadius: Float
        with(LocalDensity.current) {
            thumbRadiusInPx = trackHeight.toPx()
            strokeRadius = trackHeight.toPx() / 2
            trackStart = thumbRadiusInPx.coerceAtLeast(strokeRadius)
            trackEnd = width - trackStart
        }

        // Scales and interpolates from offset from dragging to user value in valueRange
        fun scaleToUserValue(offset: Float) =
            scale(trackStart, trackEnd, offset, valueRange.start, valueRange.endInclusive)

        // When the value is out of the range defined by valueRange, it will be coerced into the valid range.
        val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
        val fraction = calculateFraction(valueRange.start, valueRange.endInclusive, coerced)

        key(valueRange) {
            val dragModifier = Modifier
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change: PointerInputChange, _: Offset ->
                            if (valueChangeEnabled) {
                                val rawOffset =
                                    if (!isRtl) change.position.x else trackEnd - change.position.x
                                val offsetInTrack = rawOffset.coerceIn(trackStart, trackEnd)
                                onValueChangeState.value?.invoke(
                                    scaleToUserValue(offsetInTrack)
                                )
                            }
                        },
                        onDragEnd = {
                            if (valueChangeEnabled) {
                                onValueChangeFinishedState.value?.invoke()
                            }
                        }
                    )
                }
                .pointerInput(Unit) {
                    detectTapGestures { position: Offset ->
                        if (valueChangeEnabled) {
                            val rawOffset =
                                if (!isRtl) position.x else trackEnd - position.x
                            val offsetInTrack = rawOffset.coerceIn(trackStart, trackEnd)
                            onValueChangeState.value?.invoke(
                                scaleToUserValue(offsetInTrack)
                            )
                            onValueChangeFinishedState.value?.invoke()
                        }
                    }
                }

            SliderComponentImpl(
                modifier = dragModifier,
                fraction = fraction,
                trackRoundCorners = trackRoundCorners,
                trackHeight = trackHeight,
                thumbRadius = thumbRadius,
                activeTrackColor = activeTrackColor,
                inactiveTrackColor = inactiveTrackColor,
            )
        }
    }
}

@Composable
private fun SliderComponentImpl(
    modifier: Modifier,
    fraction: Float,
    trackRoundCorners: Boolean,
    trackHeight: Dp,
    thumbRadius: Dp,
    activeTrackColor: Color,
    inactiveTrackColor: Color,
) {
    Canvas(
        modifier = modifier
            .heightIn(
                max = trackHeight
                    .coerceAtLeast(thumbRadius)
                    .coerceAtLeast(trackHeight)
            )
            .fillMaxSize()
    ) {
        val width = size.width

        // Do not draw the content if the width is zero. This can happen when the parent element
        // has not allocated space for child. That behaviour can be reached by setting the
        // visibility = Visibility.Gone in ConstraintLayout
        if (width > 0) {
            // Calculate the left and right points of the slider, depending on the available space.
            val centerY = center.y
            val sliderLeft = Offset(0F, centerY)
            val sliderRight = Offset(width, centerY)

            // Calculate the start and end points of the slider, depending on the layout direction.
            val isRtl = layoutDirection == LayoutDirection.Rtl
            val sliderStart = if (isRtl) sliderRight else sliderLeft
            val sliderEnd = if (isRtl) sliderLeft else sliderRight
            val sliderValue =
                Offset(sliderStart.x + (sliderEnd.x - sliderStart.x) * fraction, center.y)

            val cap = if (trackRoundCorners) StrokeCap.Round else StrokeCap.Square

            // Draw the inactive part of the track.
            drawLine(
                color = inactiveTrackColor,
                start = sliderStart,
                end = sliderEnd,
                strokeWidth = trackHeight.toPx(),
                cap = cap
            )

            // Draw the active part of the track.
            drawLine(
                color = activeTrackColor,
                start = sliderStart,
                end = sliderValue,
                strokeWidth = trackHeight.toPx(),
                cap = cap
            )

            // Draw the thumb.
            drawCircle(
                color = activeTrackColor,
                radius = thumbRadius.toPx(),
                center = sliderValue
            )
        }
    }
}