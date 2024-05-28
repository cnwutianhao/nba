package com.tyhoo.android.nba.di

import com.tyhoo.android.nba.api.ApiService
import com.tyhoo.android.nba.data.NewsDetailDataProvider
import com.tyhoo.android.nba.data.NewsDetailDataProviderImpl
import com.tyhoo.android.nba.data.NewsListDataProvider
import com.tyhoo.android.nba.data.NewsListDataProviderImpl
import com.tyhoo.android.nba.data.PlayerListDataProvider
import com.tyhoo.android.nba.data.PlayerListDataProviderImpl
import com.tyhoo.android.nba.data.ScheduleListDataProvider
import com.tyhoo.android.nba.data.ScheduleListDataProviderImpl
import com.tyhoo.android.nba.data.TeamListDataProvider
import com.tyhoo.android.nba.data.TeamListDataProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideNewsListDataProvider(
        @Named("ChinaNBA") apiService: ApiService
    ): NewsListDataProvider {
        return NewsListDataProviderImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideTeamListDataProvider(
        @Named("ApiNBA") apiService: ApiService
    ): TeamListDataProvider {
        return TeamListDataProviderImpl(apiService)
    }

    @Singleton
    @Provides
    fun providePlayerListDataProvider(
        @Named("ApiNBA") apiService: ApiService
    ): PlayerListDataProvider {
        return PlayerListDataProviderImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideScheduleListDataProvider(
        @Named("ApiNBA") apiService: ApiService
    ): ScheduleListDataProvider {
        return ScheduleListDataProviderImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideNewsDetailDataProvider(
        @Named("ChinaNBA") apiService: ApiService
    ): NewsDetailDataProvider {
        return NewsDetailDataProviderImpl(apiService)
    }
}