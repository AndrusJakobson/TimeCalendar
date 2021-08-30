package ee.andrusj.timecalendar.source.local

import ee.andrusj.timecalendar.UseCaseHandler
import ee.andrusj.timecalendar.source.ScheduleDataSource

class LocalDataSource : ScheduleDataSource {
    override fun getSchedules(callback: ScheduleDataSource.LoadSchedulesCallback) {

    }

    companion object {
        private var INSTANCE: LocalDataSource = LocalDataSource();

        fun getInstance(): ScheduleDataSource {
            return INSTANCE;
        }
    }
}