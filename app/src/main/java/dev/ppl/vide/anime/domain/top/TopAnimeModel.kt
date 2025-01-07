package dev.ppl.vide.anime.domain.top

data class TopAnimeModel(
    val id: String, // dandadan
    val title: String, // Dandadan
    val image: String, // https://gogocdn.net/cover/dandadan.png
    val totalEpisodes: Int, // 8
    val rank: Int, // 1
    val genres: List<String>
)
