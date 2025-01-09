package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GenericListAnimeResponse<T>(
    val results: List<T>
)