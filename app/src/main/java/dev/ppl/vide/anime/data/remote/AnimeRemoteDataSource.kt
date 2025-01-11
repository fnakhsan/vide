package dev.ppl.vide.anime.data.remote

import dev.ppl.vide.anime.data.remote.paging.GenericAnimePagingSource
import dev.ppl.vide.anime.data.remote.paging.SearchAnimePagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class AnimeRemoteDataSource(
    private val animeApi: AnimeApi
) {

    fun searchAnime(query: String) = SearchAnimePagingSource(animeApi = animeApi, query = query)

    suspend fun searchSuggestionAnime(query: String) = withContext(Dispatchers.IO) {
        val data = animeApi.fetchSearchSuggestionAnime(query).results
        Timber.d("searchSuggestionAnime: $data")
        data
    }

    suspend fun fetchSpotlightAnime() = withContext(Dispatchers.IO) {
        val data = animeApi.fetchSpotlightAnime().results
        Timber.d("fetchSpotlightAnime: $data")
        data
    }

    fun fetchRecentEpisodeAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.RECENT_EPISODE
    )

    fun fetchRecentEpisodesAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.RECENT_EPISODES
    )


    fun fetchRecentlyAddedAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.RECENT_ADDED
    )


    fun fetchTopAiringAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.TOP_AIRING
    )

    fun fetchTopUpcomingAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.TOP_UPCOMING
    )

    fun fetchPopularAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.POPULAR
    )

    fun fetchFavoriteAnime() = GenericAnimePagingSource(
        animeApi = animeApi,
        genericAnimePagination = GenericAnimePagination.FAVORITE
    )

    suspend fun fetchScheduledAnime(date: String) = withContext(Dispatchers.IO) {
        val data = animeApi.fetchScheduledAnime(date).results
        Timber.d("fetchScheduledAnime: $data")
        data
    }

    suspend fun fetchInfoAnime(animeId: String) = withContext(Dispatchers.IO) {
        val data = animeApi.fetchInfoAnime(animeId)
        Timber.d("fetchInfoAnime: $data")
        data
    }

    suspend fun watchAnime(episodeId: String) = withContext(Dispatchers.IO) {
        val data = animeApi.watchAnime(episodeId)
        Timber.d("watchAnime: $data")
        data
    }
}