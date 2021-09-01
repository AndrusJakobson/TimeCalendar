package ee.andrusj.timecalendar.data.repository

import androidx.annotation.WorkerThread
import ee.andrusj.timecalendar.data.database.TaskDao
import ee.andrusj.timecalendar.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: Flow<List<Task>> = taskDao.getAll()

    @WorkerThread
    suspend fun insert(insertable: Task) {
        taskDao.insert(insertable)
    }

    @WorkerThread
    suspend fun delete(deletable: Task) {
        taskDao.delete(deletable)
    }

}