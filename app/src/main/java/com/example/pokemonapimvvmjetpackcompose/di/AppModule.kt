package com.example.pokemonapimvvmjetpackcompose.di

import com.example.pokemonapimvvmjetpackcompose.data.API.APIDetails.BASE_URL
import com.example.pokemonapimvvmjetpackcompose.data.API.APIEndpoints
import com.example.pokemonapimvvmjetpackcompose.data.repository.PokemonRepository
import com.example.pokemonapimvvmjetpackcompose.data.repository.PokemonRepositoryImplementation
import com.google.gson.Gson
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
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()
                .apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
        val gson = Gson()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun providePokemonRepository(
        apiEndpoints: APIEndpoints
    ): PokemonRepository {
        return PokemonRepositoryImplementation(apiEndpoints)
    }


    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): APIEndpoints {
        return retrofit.create(APIEndpoints::class.java)
    }


}