package data

import data.model.PlayerUI

object PlayerUIData {

    val playerUI: PlayerUI
        get() = PlayerUI(
            state = PlayerUI.PlaybackState.Stopped,
            currentPosition = 0F,
            progressRange = 0F..180000F,
            position = "0:00",
            duration = "03:00",
            remainingTime = "3:00",
            title = "Voyage I - Waterfall",
            artist = "The Kyoto Connection",
            albumArtUri = "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/art.jpg",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
}
