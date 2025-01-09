package dev.ppl.vide.anime.data.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class WatchAnimeResponse(
    val intro: Intro?,
    val outro: Outro?,
    val sources: List<Source>,
    val subtitles: List<Subtitle?>
) {
    @Serializable
    data class Intro(
        val start: Int, // 359
        val end: Int // 448
    )

    @Serializable
    data class Outro(
        val start: Int, // 1411
        val end: Int // 1502
    )

    @Serializable
    data class Source(
        val url: String, // https://eh.netmagcdn.com:2228/hls-playback/92cb644cc741fe26e79bfe7c308c8ec7f37761b4a73267ad9a19aee0b0676437c71e105803142276e5446e99510b432d209490cbc21beaf93bcb824fb73c88ce853da5f27290ec82cbe2cbc4c041884ee49ae92abc9838f126a1d5c6f6f1b9834c61e5cb729ea27c19407559c745e05a5e0f70759edabc1882701451aae6113c9e1c9a70975b2265684ad6897c390ae1/master.m3u8
        val isM3U8: Boolean, // true
        val type: String // hls
    )

    @Serializable
    data class Subtitle(
        val url: String, // https://s.megastatics.com/subtitle/2f0993384af10ee645c5d98d7a7387d4/ara-3.vtt
        val lang: String // Arabic
    )
}