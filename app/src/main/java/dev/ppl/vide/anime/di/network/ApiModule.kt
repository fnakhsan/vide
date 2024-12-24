package dev.ppl.vide.anime.di.network

import dev.ppl.vide.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

val apiModule = module {

    single {
        Json.asConverterFactory("application/json; charset=UTF8".toMediaType())
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .validateEagerly(true)
            .build()
    }

    single {
        get<Retrofit>()
    }
}
