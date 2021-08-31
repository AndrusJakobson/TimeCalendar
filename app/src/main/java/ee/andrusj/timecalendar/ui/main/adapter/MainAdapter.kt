package ee.andrusj.timecalendar.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.andrusj.timecalendar.R
import ee.andrusj.timecalendar.data.model.ScheduleBlock
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val scheduleBlocks: ArrayList<ScheduleBlock>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(scheduleBlock: ScheduleBlock) {
            itemView.textViewBlockName.text = scheduleBlock.blockName
            itemView.textViewBlockStart.text = scheduleBlock.blockStart.toString()
            itemView.textViewBlockEnd.text = scheduleBlock.blockEnd.toString()

//            Glide.with(itemView.imageViewAvatar.context)
//                .load(scheduleBlock.avatar)
//                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = scheduleBlocks.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(scheduleBlocks[position])

    fun addData(list: List<ScheduleBlock>) {
        val lastIndex = scheduleBlocks.lastIndex
        scheduleBlocks.addAll(list)
        for (i in lastIndex..scheduleBlocks.size) {
            notifyItemInserted(i)
        }
    }

}