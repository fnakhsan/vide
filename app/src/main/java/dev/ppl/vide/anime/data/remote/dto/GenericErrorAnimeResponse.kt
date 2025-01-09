package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GenericErrorAnimeResponse (
    val message: String? = ""
)