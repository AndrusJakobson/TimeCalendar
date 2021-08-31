package ee.andrusj.timecalendar.ui.main.view

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ee.andrusj.timecalendar.R
import ee.andrusj.timecalendar.data.database.DatabaseApplication
import ee.andrusj.timecalendar.data.model.Task
import ee.andrusj.timecalendar.data.repository.TaskRepository
import ee.andrusj.timecalendar.ui.main.adapter.MainAdapter
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModel
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as DatabaseApplication).taskRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        setupUI()

        viewModel.insert(
            Task(
                2,
                "No fucking way is it actually working.",
                Date(1220227200L * 1000),
                Date(1220227200L * 1000)
            )
        );

        Log.d("YEMEN", "Test, is it actually working?")
        viewModel.allTasks.observe(this, androidx.lifecycle.Observer {
            for (task in it) {
                Log.d("YEMEN", task.name)

            }
        })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
}