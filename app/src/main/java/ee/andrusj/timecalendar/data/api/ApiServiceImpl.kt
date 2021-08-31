package ee.andrusj.timecalendar.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import ee.andrusj.timecalendar.data.model.ScheduleBlock
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getUsers(): Single<List<ScheduleBlock>> {
        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getObjectListSingle(ScheduleBlock::class.java)
    }

}