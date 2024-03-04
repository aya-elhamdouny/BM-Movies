package com.example.bmmovies.di

import com.example.bmmovies.data.utilities.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL).addConverterFactory(gsonConverterFactory)
            .client(okHttpClient).build()

    }

    @Provides
    @Singleton
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.BUILD_TYPE == "release") {
            HttpLoggingInterceptor.Level.NONE
        } else {
            HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        @ApplicationContext appContext: Context,
        storageManager: StorageManager
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.excludeFieldsWithoutExposeAnnotation()
        return gsonBuilder.setLenient().create()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }
}