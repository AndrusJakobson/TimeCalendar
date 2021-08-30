package ee.andrusj.timecalendar.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ee.andrusj.timecalendar.ui.schedulelist.ScheduleListViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ScheduleListViewModel::class.java) {
            return ScheduleListViewModel(
                Injection.provideUseCaseHandler(),
                Injection.provideGetSchedules()
            ) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory {
            if (INSTANCE == null) {
                INSTANCE = ViewModelFactory()
            }
            return INSTANCE!!
        }
    }
}
