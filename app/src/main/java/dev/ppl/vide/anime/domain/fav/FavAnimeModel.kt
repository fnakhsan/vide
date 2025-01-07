package dev.ppl.vide.anime.domain.fav

data class FavAnimeModel(
    val id: String, // dandadan
    val title: String, // Dandadan
    val image: String, // https://gogocdn.net/cover/dandadan.png
    val watchedEps: Int,
    val totalEpisodes: Int, // 8
    val rating: Int, // 5
    val subOrDub: String, // sub
)
