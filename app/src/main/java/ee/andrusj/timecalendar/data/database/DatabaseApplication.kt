package ee.andrusj.timecalendar.data.database

import android.app.Application
import ee.andrusj.timecalendar.data.repository.TaskRepository

class DatabaseApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val taskRepository by lazy { TaskRepository(database.TaskDao()) }
}