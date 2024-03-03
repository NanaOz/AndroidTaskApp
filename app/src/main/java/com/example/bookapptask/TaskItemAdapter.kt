package com.example.bookapptask

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.CheckBox
import androidx.recyclerview.widget.ListAdapter
import androidx.cardview.widget.CardView
import com.example.bookapptask.databinding.TaskItemBinding


class TaskItemAdapter : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

//    class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
    class TaskItemViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

//        val taskName = rootView.findViewById<TextView>(R.id.task_name)
//        val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
//                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
//                return TaskItemViewHolder(view)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task) {
//            taskName.text = item.taskName
//            taskDone.isChecked = item.taskDone
            binding.task = item
        }
    }
}