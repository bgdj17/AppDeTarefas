package com.example.minhastarefas.services.constants

class DataBaseConstants {
    object TASK{

        const val TABLE_NAME = "Task"

        object COLUMNS{
            const val ID = "id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val STATUS = "status"
        }
    }
}