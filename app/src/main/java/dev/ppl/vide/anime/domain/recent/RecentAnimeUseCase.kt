package dev.ppl.vide.anime.domain.recent

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface RecentAnimeUseCase {
    fun getRecentWatchedAnime(): Flow<PagingData<RecentAnimeModel>>
}