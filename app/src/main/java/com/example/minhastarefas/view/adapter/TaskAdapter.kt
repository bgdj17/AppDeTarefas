package com.example.minhastarefas.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.R
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.view.listener.TaskListener
import com.example.minhastarefas.view.viewholder.TaskViewHolder


class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private var mTaskList: List<Task> = arrayListOf()
    private lateinit var mListener: TaskListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.task_list, parent, false)
        return TaskViewHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(mTaskList[position])
    }

    override fun getItemCount(): Int = mTaskList.count()

    fun updateTask(list: List<Task>) {
        mTaskList = list
        notifyDataSetChanged()

    }

    fun attachListener(listener: TaskListener) {
        mListener = listener
    }
}

