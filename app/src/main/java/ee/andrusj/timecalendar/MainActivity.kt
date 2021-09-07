package ee.andrusj.timecalendar

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ee.andrusj.timecalendar.data.database.AppDatabase
import ee.andrusj.timecalendar.ui.main.view.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val database by lazy { AppDatabase.getDatabase(this) }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        commitMainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commitMainFragment()
    }

    private fun commitMainFragment() {
        supportFragmentManager.commit {
            replace<MainFragment>(R.id.activity_main_framelayout)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_bar_menu -> {
            Log.d("yemen", "Menu is clicked")
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}