package dev.ppl.vide.anime.domain.recent

data class RecentAnimeModel(
    val id: String, // dandadan
    val title: String, // Dandadan
    val image: String, // https://gogocdn.net/cover/dandadan.png
    val recentEps: Int, // 7
    val progressEps: Int, // 10:01 / 21:40
    val totalEpisodes: Int, // 8
    val subOrDub: String, // sub
)