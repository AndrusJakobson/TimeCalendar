package ee.andrusj.timecalendar.ui.task.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ee.andrusj.timecalendar.data.database.DatabaseApplication
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModel
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModelFactory

class TaskFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((activity?.application as DatabaseApplication).taskRepository)
    }
}