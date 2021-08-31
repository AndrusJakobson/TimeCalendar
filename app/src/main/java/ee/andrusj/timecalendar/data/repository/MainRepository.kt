package ee.andrusj.timecalendar.data.repository

import ee.andrusj.timecalendar.data.api.ApiHelper
import ee.andrusj.timecalendar.data.model.ScheduleBlock
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(): Single<List<ScheduleBlock>> {
        return apiHelper.getUsers()
    }

}