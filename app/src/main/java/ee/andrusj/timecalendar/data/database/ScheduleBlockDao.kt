package ee.andrusj.timecalendar.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ee.andrusj.timecalendar.data.model.ScheduleBlock

@Dao
interface ScheduleBlockDao {
    @Query("SELECT * FROM ScheduleBlock")
    fun getAll(): List<ScheduleBlock>

    @Insert
    fun insertBlocks(vararg scheduleBlocks: ScheduleBlock)

    @Delete
    fun delete(scheduleBlock: ScheduleBlock)
}