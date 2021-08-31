package ee.andrusj.timecalendar.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ee.andrusj.timecalendar.R
import ee.andrusj.timecalendar.data.model.Task

class MainAdapter(
    private val tasks: ArrayList<Task>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.findViewById<TextView>(R.id.textViewBlockName).text = task.name;
            itemView.findViewById<TextView>(R.id.textViewBlockStart).text = task.start.toString()
            itemView.findViewById<TextView>(R.id.textViewBlockEnd).text = task.end.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(tasks[position])

    fun addData(list: List<Task>) {
        val lastIndex = tasks.lastIndex
        tasks.addAll(list)
        for (i in lastIndex..tasks.size) {
            notifyItemInserted(i)
        }
    }

}