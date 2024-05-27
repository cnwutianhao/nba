package com.tyhoo.android.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tyhoo.android.nba.util.DateUtils
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduleListRepository @Inject constructor(private val provider: ScheduleListDataProvider) {

    suspend fun getScheduleList(): LiveData<List<SchedulesGroup>> {
        val timestamp = System.currentTimeMillis().toString()
        val network = URLDecoder.decode("N%2FA", StandardCharsets.UTF_8.name())
        val scheduleList = MutableLiveData<List<SchedulesGroup>>()
        val list = provider.provideScheduleListData(
            network,
            timestamp,
            DateUtils.getTodayDate(),
            DateUtils.getDateAfterSevenDays()
        )
        scheduleList.postValue(list)
        return scheduleList
    }
}