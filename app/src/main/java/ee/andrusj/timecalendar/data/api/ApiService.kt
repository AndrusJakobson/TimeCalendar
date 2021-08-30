package ee.andrusj.timecalendar.data.api

import ee.andrusj.timecalendar.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}