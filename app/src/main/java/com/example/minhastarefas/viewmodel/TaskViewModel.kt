package com.example.minhastarefas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.services.constants.TaskConstants
import com.example.minhastarefas.services.repository.TaskRepository

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val mTaskRepository = TaskRepository.getInstance(application.applicationContext)

    private val mTaskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = mTaskList

    fun load(filter: Int) {
        mTaskList.value = mTaskRepository.getAll()
    }

    fun delete(id: Int) {
        mTaskRepository.delete(id)

    }

}