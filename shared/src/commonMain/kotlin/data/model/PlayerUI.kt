package data.model


data class PlayerUI(
    val title: String,
    val artist: String,
    val albumArtUri: String?,
    val description: String,
    val state: PlaybackState,
    val currentPosition: Float,
    val progressRange: ClosedFloatingPointRange<Float>,
    val position: String,
    val duration: String,
    val remainingTime: String,
) {


    sealed interface PlaybackState {

        object Stopped : PlaybackState

        object Playing : PlaybackState

        object Paused : PlaybackState
    }
}
