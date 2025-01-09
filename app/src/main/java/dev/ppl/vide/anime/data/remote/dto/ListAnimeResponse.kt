package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ListAnimeResponse (
    val id: String,
    val title: String, // Fullmetal Alchemist: Brotherhood
    val url: String,
    val image: String,
    val duration: String, // 24m
    val japaneseTitle: String, // Fullmetal Alchemist: Brotherhood
    val type: String, // TV
    val nsfw: Boolean, // true
    val sub: Int, // 64
    val dub: Int, // 64
    val episodes: Int // 64
)