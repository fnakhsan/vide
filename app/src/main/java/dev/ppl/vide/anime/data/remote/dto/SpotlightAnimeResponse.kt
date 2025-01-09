package dev.ppl.vide.anime.data.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class SpotlightAnimeResponse(
    val id: String,
    val title: String,
    val japaneseTitle: String,
    val banner: String,
    val rank: Int, // 1
    val url: String,
    val type: String, // TV
    val duration: String, // 23m
    val releaseDate: String, // Oct 6, 2024
    val quality: String, // HD
    val sub: Int, // 12
    val dub: Int, // 12
    val episodes: Int, // 12
    val description: String
)