package com.baharudin.pokemon.di

import com.baharudin.pokemon.data.remote.api.PokemonApi
import com.baharudin.pokemon.data.remote.repository.PokemonRepo
import com.baharudin.pokemon.data.remote.repository.PokemonRepository
import com.baharudin.pokemon.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : PokemonApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        pokemonApi : PokemonApi
    ) : PokemonRepo {
        return PokemonRepository(
            pokemonApi
        )
    }
}