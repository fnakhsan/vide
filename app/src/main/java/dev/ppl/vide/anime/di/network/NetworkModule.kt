package dev.ppl.vide.anime.di.network

import org.koin.dsl.module

val networkModule = module {
    includes(httpModule, apiModule)
    single {  }
}
