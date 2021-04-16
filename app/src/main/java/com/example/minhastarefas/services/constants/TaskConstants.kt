package com.example.minhastarefas.services.constants

class TaskConstants private constructor() {
    companion object {
        const val TASKID = "taskID"
    }

    object FILTER {
        const val TODO = 0
        const val PROGRESS = 1
        const val DONE = 2
    }
}