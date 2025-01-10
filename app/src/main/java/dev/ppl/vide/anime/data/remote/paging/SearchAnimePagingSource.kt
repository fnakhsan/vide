package dev.ppl.vide.anime.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.ppl.vide.anime.data.remote.AnimeApi
import dev.ppl.vide.anime.data.remote.dto.ListAnimeResponse
import kotlinx.coroutines.delay
import timber.log.Timber

class SearchAnimePagingSource(
    private val animeApi: AnimeApi,
    private val query: String,
) : PagingSource<Int, ListAnimeResponse>() {

    override fun getRefreshKey(state: PagingState<Int, ListAnimeResponse>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListAnimeResponse> {
        return try {
            val currentPage = params.key ?: 1
            val apiResponse = animeApi.searchAnime(query = query, page = currentPage)
            Timber.d("load: $apiResponse")
            delay(
                if (currentPage == 1) {
                    0
                } else {
                    500
                }
            )
            val previousPage =
                if (currentPage == 1) {
                    null
                } else {
                    currentPage - 1
                }
            val nextPage =
                if (apiResponse.hasNextPage) {
                    currentPage + 1
                } else {
                    null
                }
            Timber.d("load: ${apiResponse.results}")
            LoadResult.Page(
                data = apiResponse.results,
                prevKey = previousPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            Timber.e(e.message)
            LoadResult.Error(e)
        }
    }
}