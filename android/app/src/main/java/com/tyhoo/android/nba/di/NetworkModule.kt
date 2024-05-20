package com.tyhoo.android.nba.di

import com.tyhoo.android.nba.api.ApiService
import com.tyhoo.android.nba.data.NBAUrls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    @Named("ChinaNBA")
    fun provideChinaNBAService(): ApiService {
        return ApiService.create(NBAUrls.CHINA_NBA)
    }

    @Singleton
    @Provides
    @Named("ApiNBA")
    fun provideApiNBAService(): ApiService {
        return ApiService.create(NBAUrls.API_NBA)
    }
}