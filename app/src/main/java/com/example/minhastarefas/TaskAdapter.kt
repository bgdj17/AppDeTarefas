package com.example.minhastarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.model.Task


class TaskAdapter( val taskList: MutableList<Task>, val context: Context) :
    RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    class TaskHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleTask: TextView = view.findViewById(R.id.taskTitle)
        var descriptionTask: TextView = view.findViewById(R.id.taskDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list, parent, false)
        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {

        holder.titleTask.text = taskList[position].title
        holder.descriptionTask.text = taskList[position].description
    }

    override fun getItemCount(): Int = taskList.size
}

