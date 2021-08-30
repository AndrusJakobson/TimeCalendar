package ee.andrusj.timecalendar.ui.schedulelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ee.andrusj.timecalendar.R
import ee.andrusj.timecalendar.model.Schedule
import ee.andrusj.timecalendar.source.ScheduleDataSource
import ee.andrusj.timecalendar.utils.Injection

class ScheduleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("YEMEN", "onViewCreated")
        val scheduleListViewModel =
            Injection.provideViewModelFactory().create(ScheduleListViewModel::class.java)

        scheduleListViewModel.getAllSchedules(object : ScheduleDataSource.LoadSchedulesCallback {
            override fun onSchedulesLoaded(schedules: List<Schedule>) {
                Log.d("YEMEN", "HELLO THERE!")
            }

            override fun onError(throwable: Throwable) {
                Log.d("YEMEN", "HELLO THERE! 22")
            }
        })
    }
}