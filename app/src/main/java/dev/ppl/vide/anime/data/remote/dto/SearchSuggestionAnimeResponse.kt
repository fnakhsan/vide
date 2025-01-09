package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchSuggestionAnimeResponse(
    val image: String,
    val id: String,
    val title: String, // One Piece Movie 1
    val japaneseTitle: String, // One Piece Movie 1
    val aliasTitle: String, // One Piece Movie 1
    val releaseDate: String, // Mar 4, 2000
    val type: String, // Movie
    val duration: String, // 50m
    val url: String
)