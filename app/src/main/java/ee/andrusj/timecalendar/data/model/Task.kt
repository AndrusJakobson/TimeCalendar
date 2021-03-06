package ee.andrusj.timecalendar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ee.andrusj.timecalendar.data.database.RoomConverters
import java.util.*

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "block_name")
    val name: String,

    @ColumnInfo(name = "block_start")
    @TypeConverters(RoomConverters::class)
    val start: Date,

    @ColumnInfo(name = "block_end")
    @TypeConverters(RoomConverters::class)
    val end: Date
)