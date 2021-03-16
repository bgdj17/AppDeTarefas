package com.example.minhastarefas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minhastarefas.model.Task

class BottonSheetViewModel : ViewModel() {

    val msg = MutableLiveData<Task>()

    fun dataTask(task: Task){
        msg.value = task
    }


    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}