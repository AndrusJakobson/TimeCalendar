package ee.andrusj.timecalendar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ee.andrusj.timecalendar.data.model.ScheduleBlock

@Database(
    entities = [
        ScheduleBlock::class
    ],
    version = 1
)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleBlockDao(): ScheduleBlockDao

    companion object {
        val DATABASE_NAME = "timecalendar"
        private lateinit var instance: AppDatabase

        fun getInstance(context: Context): AppDatabase {
            if (!this::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).addTypeConverter(RoomConverters.instance).build()
            }

            return instance;
        }
    }
}