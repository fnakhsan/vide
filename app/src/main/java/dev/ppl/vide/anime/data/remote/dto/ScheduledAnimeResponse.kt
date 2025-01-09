package dev.ppl.vide.anime.data.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class ScheduledAnimeResponse(
    val id: String,
    val title: String,
    val japaneseTitle: String,
    val url: String,
    val airingEpisode: String, // Episode 14
    val airingTime: String // 07:00
)