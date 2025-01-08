package dev.ppl.vide.anime.domain.new

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface NewAnimeUseCase {
    fun getNewlyUpdatedAnime(): Flow<PagingData<NewAnimeModel>>
}