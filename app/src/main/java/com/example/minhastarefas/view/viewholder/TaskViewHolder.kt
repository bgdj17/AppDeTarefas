package com.example.minhastarefas.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.R
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.view.listener.TaskListener

class TaskViewHolder(itemView: View, private val listener: TaskListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(task: Task){
        val textTitle = itemView.findViewById<TextView>(R.id.taskTitle)
        val textDescription = itemView.findViewById<TextView>(R.id.taskDescription)

        textTitle.text = task.title
        textDescription.text = task.description

        textTitle.setOnClickListener{
            listener.onClick(task.id)
        }

    }
}