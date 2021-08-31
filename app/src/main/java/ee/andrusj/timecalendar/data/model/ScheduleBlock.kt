package ee.andrusj.timecalendar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ee.andrusj.timecalendar.utils.RoomConverters
import java.util.*

@Entity
data class ScheduleBlock(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "block_name")
    val blockName: String,

    @ColumnInfo(name = "block_start")
    @TypeConverters(RoomConverters::class)
    val blockStart: Date,

    @ColumnInfo(name = "block_end")
    @TypeConverters(RoomConverters::class)
    val blockEnd: Date
)