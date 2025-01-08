package dev.ppl.vide.anime.domain.fav

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface FavAnimeUseCase {
    fun getFavoriteAnime(): Flow<PagingData<FavAnimeModel>>
}