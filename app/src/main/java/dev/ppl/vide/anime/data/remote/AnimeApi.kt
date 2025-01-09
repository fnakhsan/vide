package dev.ppl.vide.anime.data.remote

import dev.ppl.vide.BuildConfig
import dev.ppl.vide.anime.data.remote.dto.DetailAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.GenericListAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.GenericPaginationAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.ListAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.ScheduledAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.SearchSuggestionAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.SpotlightAnimeResponse
import dev.ppl.vide.anime.data.remote.dto.WatchAnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface AnimeApi {
    @GET("$ANIME_URL/{query}")
    suspend fun searchAnime(
        @Path("query") query: String,
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/search-suggestions/{query}")
    suspend fun fetchSearchSuggestionAnime(
        @Path("query") query: String,
        @Query("page") page: Int? = null,
    ): GenericListAnimeResponse<SearchSuggestionAnimeResponse>

    @GET("$ANIME_URL/spotlight")
    suspend fun fetchSpotlightAnime(): GenericListAnimeResponse<SpotlightAnimeResponse>

    @GET("$ANIME_URL/recent-episode")
    suspend fun fetchRecentEpisodeAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/recent-episodes")
    suspend fun fetchRecentEpisodesAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/recent-added")
    suspend fun fetchRecentlyAddedAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/top-airing")
    suspend fun fetchTopAiringAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/top-upcoming")
    suspend fun fetchTopUpcomingAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/most-popular")
    suspend fun fetchPopularAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/most-favorite")
    suspend fun fetchFavoriteAnime(
        @Query("page") page: Int? = null,
    ): GenericPaginationAnimeResponse<ListAnimeResponse>

    @GET("$ANIME_URL/schedule/{date}")   // YYYY-MM-DD (2025-01-09)
    suspend fun fetchScheduledAnime(
        @Path("date") date: String,
    ): GenericListAnimeResponse<ScheduledAnimeResponse>

    @GET("$ANIME_URL/info/{animeId}")
    suspend fun fetchInfoAnime(
        @Path("animeId") animeId: String,
    ): DetailAnimeResponse

    @GET("$ANIME_URL/watch/{episodeId}")
    suspend fun watchAnime(
        @Path("episodeId") episodeId: String,
    ): WatchAnimeResponse

    companion object {
        private const val ANIME_URL = "anime/" + BuildConfig.ANIME_PROVIDER_1
    }
}