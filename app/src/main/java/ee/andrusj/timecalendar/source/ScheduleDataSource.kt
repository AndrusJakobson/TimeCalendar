package ee.andrusj.timecalendar.source

import ee.andrusj.timecalendar.model.Schedule

interface ScheduleDataSource {
    interface LoadSchedulesCallback {
        fun onSchedulesLoaded(schedules: List<Schedule>)
        fun onError(throwable: Throwable)
    }

    fun getSchedules(callback: LoadSchedulesCallback)
}