package dev.ppl.vide.anime.di.network

import dev.ppl.vide.anime.data.remote.AnimeRemoteDataSource
import org.koin.dsl.module

val networkModule = module {
    includes(httpModule, apiModule)
    single { AnimeRemoteDataSource(get()) }
}
