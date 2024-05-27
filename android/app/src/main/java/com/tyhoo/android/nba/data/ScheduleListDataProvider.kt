package com.tyhoo.android.nba.data

import com.tyhoo.android.nba.api.ApiService
import javax.inject.Inject

interface ScheduleListDataProvider {
    suspend fun provideScheduleListData(
        network: String, timestamp: String, startDate: String, endDate: String
    ): List<SchedulesGroup>
}

class ScheduleListDataProviderImpl @Inject constructor(
    private val service: ApiService
) : ScheduleListDataProvider {
    override suspend fun provideScheduleListData(
        network: String, timestamp: String, startDate: String, endDate: String
    ): List<SchedulesGroup> {
        return runCatching {
            service.scheduleList(
                network = network, t = timestamp, start = startDate, end = endDate
            ).data.groups
        }.getOrElse {
            emptyList()
        }
    }
}