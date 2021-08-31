package ee.andrusj.timecalendar.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.*
import ee.andrusj.timecalendar.data.model.Task
import ee.andrusj.timecalendar.data.repository.TaskRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTasks: LiveData<List<Task>> = repository.allTasks.asLiveData()

    fun insert(task: Task) = viewModelScope.launch {
        Log.d("YEMEN", "Something is being inserted")
        repository.insert(task)
    }
}

class MainViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}