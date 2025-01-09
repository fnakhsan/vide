package dev.ppl.vide.anime.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class DetailAnimeResponse(
    val id: String,
    val title: String, // Violet Evergarden
    val malID: Int, // 33352
    val alID: Int, // 21827
    val japaneseTitle: String,
    val image: String,
    val description: String, // The Great War finally came to an end after four long years of conflict; fractured in two, the continent of Telesis slowly began to flourish once again. Caught up in the bloodshed was Violet Evergarden, a young girl raised for the sole purpose of decimating enemy lines. Hospitalized and maimed in a bloody skirmish during the War's final leg, she was left with only words from the person she held dearest, but with no understanding of their meaning.Recovering from her wounds, Violet starts a new life working at CH Postal Services after a falling out with her new intended guardian family. There, she witnesses by pure chance the work of an "Auto Memory Doll," amanuenses that transcribe people's thoughts and feelings into words on paper. Moved by the notion, Violet begins work as an Auto Memory Doll, a trade that will take her on an adventure, one that will reshape the lives of her clients and hopefully lead to self-discovery.[Written by MAL Rewrite]
    val type: String, // TV
    val url: String,
    val recommendations: List<Recommendation>,
    val relatedAnime: List<Recommendation?>,
    val subOrDub: String, // both
    val hasSub: Boolean, // true
    val hasDub: Boolean, // true
    val totalEpisodes: Int, // 13
    val episodes: List<Episode>
) {
    @Serializable
    data class Recommendation(
        val id: String,
        val title: String, // Xue Ying Ling Zhu 3rd Season
        val url: String,
        val image: String,
        val duration: String, // 19m
        val japaneseTitle: String, // Xue Ying Ling Zhu 3rd Season
        val type: String, // ONA
        val nsfw: Boolean, // false
        val sub: Int, // 26
        val dub: Int, // 0
        val episodes: Int // 26
    )

    @Serializable
    data class Episode(
        val id: String, // violet-evergarden-59$episode$1451$both
        val number: Int, // 1
        val title: String, // 'I Love You' and Auto Memoir Doll
        val isFiller: Boolean, // false
        val url: String
    )
}