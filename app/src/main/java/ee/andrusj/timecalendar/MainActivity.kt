package ee.andrusj.timecalendar

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ee.andrusj.timecalendar.data.database.AppDatabase
import ee.andrusj.timecalendar.ui.main.view.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val database by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        supportFragmentManager.commit {
            replace<MainFragment>(R.id.activity_main_framelayout)
        }
    }
}