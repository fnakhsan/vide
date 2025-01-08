package dev.ppl.vide.anime.domain.top

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface TopAnimeUseCase {
    fun getTopAiringAnime(): Flow<PagingData<TopAnimeModel>>
}