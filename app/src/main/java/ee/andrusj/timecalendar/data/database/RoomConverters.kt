package ee.andrusj.timecalendar.data.database

import androidx.room.TypeConverter
import java.util.*

class RoomConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    companion object {
        val instance by lazy { RoomConverters() }
    }
}