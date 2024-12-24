package dev.ppl.vide.anime.di

import dev.ppl.vide.anime.di.network.networkModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(networkModule)
    single {

    }
}