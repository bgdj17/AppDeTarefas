package com.example.minhastarefas.services.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.minhastarefas.services.constants.DataBaseConstants

class TaskDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_TASK)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Tarefas.db"

        private const val CREATE_TABLE_TASK = (
                "CREATE TABLE " + DataBaseConstants.TASK.TABLE_NAME + " ("
                        + DataBaseConstants.TASK.COLUMNS.ID + " integer primary key autoincrement, "
                        + DataBaseConstants.TASK.COLUMNS.TITLE + " text, "
                        + DataBaseConstants.TASK.COLUMNS.DESCRIPTION + " text, "
                        + DataBaseConstants.TASK.COLUMNS.STATUS + " text ); "
                )
    }

}