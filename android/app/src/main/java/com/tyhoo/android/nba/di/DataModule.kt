package com.tyhoo.android.nba.di

import com.tyhoo.android.nba.api.ApiService
import com.tyhoo.android.nba.data.NewsListDataProvider
import com.tyhoo.android.nba.data.NewsListDataProviderImpl
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
}