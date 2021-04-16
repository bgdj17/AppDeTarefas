package com.example.minhastarefas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.services.repository.TaskRepository

class BottonSheetViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mTaskRepository = TaskRepository.getInstance(mContext)

    private val mSaveTask = MutableLiveData<Boolean>()
    val saveTask: LiveData<Boolean> = mSaveTask

    private var mTask = MutableLiveData<Task>()
    val task: LiveData<Task> = mTask

    fun save(id: Int, title: String, description: String, status: String) {
        val task = Task(id, title, description, status)
        if (id == 0) {
            mSaveTask.value = mTaskRepository.save(task)
        }
    }
    fun update(id: Int, title: String, description: String, status: String){
        val task = Task(id, title, description, status)
        mSaveTask.value = mTaskRepository.update(task)
    }

    fun load(id: Int){
        mTask.value = mTaskRepository.get(id)
    }
}