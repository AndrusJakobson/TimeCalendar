package ee.andrusj.timecalendar.data.repository

import ee.andrusj.timecalendar.data.api.ApiHelper
import ee.andrusj.timecalendar.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}