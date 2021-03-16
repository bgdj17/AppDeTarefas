package com.example.minhastarefas.model

import android.provider.SyncStateContract.Helpers.update
import com.example.minhastarefas.TaskAdapter

class ActionTask() {


    fun createTask( title: String, description: String?, status: String = "A_FAZER"): Task{
        return Task(title,description,status)
    }

    fun addTask(task: Task): String {

        list.add(task)

        return "Tarefa  adicionda com sucesso!"
    }

    fun removeTask(task: Task) {
        var idxRemove = list.filter { it.title == task.title }
        list.remove(element = idxRemove)
    }

    fun getTasks(): MutableList<Task> {
        return list
    }

    companion object{
        val list = mutableListOf<Task>(
            Task("Criar Fragmente", "Tenho que finalizar o projeto do curso CTT", "A_FAZER"),
        )

    }
}


