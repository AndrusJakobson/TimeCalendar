package ee.andrusj.timecalendar.ui.schedulelist

import androidx.lifecycle.ViewModel
import ee.andrusj.timecalendar.UseCase
import ee.andrusj.timecalendar.UseCaseHandler
import ee.andrusj.timecalendar.source.ScheduleDataSource
import ee.andrusj.timecalendar.ui.schedulelist.domain.GetSchedules

class ScheduleListViewModel(
    val useCaseHandler: UseCaseHandler,
    val getSchedules: GetSchedules
) : ViewModel() {
    // TODO do not take longer than week old ones.
    fun getAllSchedules(callback: ScheduleDataSource.LoadSchedulesCallback) {
        val requestValue = GetSchedules.RequestValues()
        useCaseHandler.execute(
            getSchedules,
            requestValue,
            object : UseCase.UseCaseCallback<GetSchedules.ResponseValue> {
                override fun onSuccess(response: GetSchedules.ResponseValue) {
                    callback.onSchedulesLoaded(response.schedules)
                }

                override fun onError(t: Throwable) {
                    callback.onError(t)
                }

            })
    }
}