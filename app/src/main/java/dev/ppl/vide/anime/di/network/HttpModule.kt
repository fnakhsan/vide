package dev.ppl.vide.anime.di.network

import dev.ppl.vide.core.util.ConnectivityChecker
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val httpModule = module {
    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single(named(OFFLINE_INTERCEPTOR)) {
        Interceptor { chain ->
            var request = chain.request()
            val connectivityChecker = ConnectivityChecker()
            val isConnectivityAvailable = connectivityChecker(androidContext())
            if (!isConnectivityAvailable) {
                val maxStale = 60 * 60 * 24 * 7
                request = request
                    .newBuilder()
                    .header(CACHE_CONTROL, "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader(PRAGMA)
                    .build()
            }
            chain.proceed(request)
        }
    }

    single(named(ONLINE_INTERCEPTOR)) {
        Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val maxAge = 60 * 10
            response
                .newBuilder()
                .header(CACHE_CONTROL, "public, max-age=$maxAge")
                .removeHeader(PRAGMA)
                .build()
        }
    }

    //    single {
//        CertificatePinner.Builder()
//            .add(HOSTNAME, "sha256/WxVeH3behrxKvQkDq0Rk1d7c8ZFEx/rxNV4XNhHszo8=")
//            .add(HOSTNAME, "sha256/jQJTbIh0grw0/1TkHSumWb+Fs0Ggogr621gT3PvPKG0=")
//            .add(HOSTNAME, "sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=").build()
//    }

    single {
        OkHttpClient
            .Builder()
            .cache(Cache(androidContext().cacheDir, CACHE_SIZE))
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>(named(OFFLINE_INTERCEPTOR)))
            .addNetworkInterceptor(get<Interceptor>(named(ONLINE_INTERCEPTOR)))
            .build()
    }
}

private const val CACHE_SIZE: Long = (50 * 1024 * 1024).toLong()
private const val ONLINE_INTERCEPTOR = "online_interceptor"
private const val OFFLINE_INTERCEPTOR = "offline_interceptor"
private const val CACHE_CONTROL = "Cache-Control"
private const val PRAGMA = "Pragma"
