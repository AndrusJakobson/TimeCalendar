package ee.andrusj.timecalendar.utils

import ee.andrusj.timecalendar.UseCaseHandler
import ee.andrusj.timecalendar.source.ScheduleDataRepository
import ee.andrusj.timecalendar.source.ScheduleDataSource
import ee.andrusj.timecalendar.source.local.LocalDataSource
import ee.andrusj.timecalendar.ui.schedulelist.domain.GetSchedules

object Injection {
    fun provideScheduleDataRepository(): ScheduleDataRepository {
        return ScheduleDataRepository.getInstance(provideLocalDataSource())
    }

    fun provideViewModelFactory() = ViewModelFactory.getInstance()

    fun provideLocalDataSource(): ScheduleDataSource = LocalDataSource.getInstance()

    fun provideGetSchedules() = GetSchedules(provideScheduleDataRepository())

    fun provideUseCaseHandler() = UseCaseHandler.getInstance()
}