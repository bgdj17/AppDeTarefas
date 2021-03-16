package com.example.minhastarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.model.ActionTask
import com.example.minhastarefas.model.Task


class TaskAdapter( val taskList: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    class TaskHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleTask: TextView = view.findViewById(R.id.taskTitle)
        var descriptionTask: TextView = view.findViewById(R.id.taskDescription)

        init {
            view.setOnClickListener {
                val position : Int = adapterPosition
                Toast.makeText(view.context,"$position", Toast.LENGTH_SHORT).show()
            }
        }
    }


   fun addTask(newTask: Task){
        taskList.add(newTask)
       notifyDataSetChanged()
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

