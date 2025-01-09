package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GenericPaginationAnimeResponse<T> (
    val currentPage: Int?, // 1
    val hasNextPage: Boolean, // true
    val totalPages: Int?, // 184
    val results: List<T>
)