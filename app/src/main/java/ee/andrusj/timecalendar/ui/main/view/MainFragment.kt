package ee.andrusj.timecalendar.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ee.andrusj.timecalendar.R
import ee.andrusj.timecalendar.data.database.DatabaseApplication
import ee.andrusj.timecalendar.ui.main.adapter.MainAdapter
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModel
import ee.andrusj.timecalendar.ui.main.viewmodel.MainViewModelFactory

class MainFragment : Fragment() {
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((activity?.application as DatabaseApplication).taskRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupUI()

        viewModel.allTasks.observe(viewLifecycleOwner, {
            for (task in it) {
                Log.d("YEMEN", task.name)
            }
        })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    companion object {
        val instance: MainFragment by lazy { MainFragment() }
    }
}