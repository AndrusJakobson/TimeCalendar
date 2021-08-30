package ee.andrusj.timecalendar.source

import ee.andrusj.timecalendar.model.Schedule

class ScheduleDataRepository private constructor(private val localDataSource: ScheduleDataSource) :
    ScheduleDataSource {

    companion object {
        private var INSTANCE: ScheduleDataRepository? = null
        fun getInstance(
            localDataSource: ScheduleDataSource
        ): ScheduleDataRepository {
            if (INSTANCE == null) {
                INSTANCE = ScheduleDataRepository(localDataSource)
            }
            return INSTANCE!!
        }
    }

    override fun getSchedules(callback: ScheduleDataSource.LoadSchedulesCallback) {
        localDataSource.getSchedules(object : ScheduleDataSource.LoadSchedulesCallback {
            override fun onSchedulesLoaded(schedules: List<Schedule>) {
                callback.onSchedulesLoaded(schedules)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}