package ee.andrusj.timecalendar.ui.schedulelist.domain

import ee.andrusj.timecalendar.UseCase
import ee.andrusj.timecalendar.model.Schedule
import ee.andrusj.timecalendar.source.ScheduleDataSource

class GetSchedules(private val dataSource: ScheduleDataSource) :
    UseCase<GetSchedules.RequestValues, GetSchedules.ResponseValue>() {

    override fun executeUseCase(requestValues: RequestValues?) {
        dataSource.getSchedules(object : ScheduleDataSource.LoadSchedulesCallback {
            override fun onSchedulesLoaded(schedules: List<Schedule>) {
                useCaseCallback?.onSuccess(ResponseValue(schedules))
            }

            override fun onError(throwable: Throwable) {
                useCaseCallback?.onError(Throwable("No Schedules"))
            }
        }
        )
    }

    class RequestValues() : UseCase.RequestValues
    class ResponseValue(val schedules: List<Schedule>) : UseCase.ResponseValue
}