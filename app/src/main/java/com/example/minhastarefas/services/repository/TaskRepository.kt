package com.example.minhastarefas.services.repository

import android.content.ContentValues
import android.content.Context
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.services.constants.DataBaseConstants

import java.lang.Exception

class TaskRepository private constructor(context: Context) {

    private var mTaskDataBaseHelper: TaskDataBaseHelper = TaskDataBaseHelper(context)

    companion object {
        private lateinit var repository: TaskRepository

        fun getInstance(context: Context): TaskRepository {
            if (!::repository.isInitialized) {
                repository = TaskRepository(context)
            }
            return TaskRepository(context)
        }
    }

    fun save(task: Task): Boolean {
        return try {
            val db = mTaskDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.TASK.COLUMNS.TITLE, task.title)
            contentValues.put(DataBaseConstants.TASK.COLUMNS.DESCRIPTION, task.description)
            contentValues.put(DataBaseConstants.TASK.COLUMNS.STATUS, task.status)
            db.insert(DataBaseConstants.TASK.TABLE_NAME, null, contentValues)
            true
        } catch (e: Exception) {
            false
        }

    }

    fun get(id: Int): Task? {
        var task: Task? = null

        return try {
            val db = mTaskDataBaseHelper.readableDatabase

            //db.rawQuery -> escreve uma query direto no Db

            val projection = arrayOf(
                DataBaseConstants.TASK.COLUMNS.TITLE,
                DataBaseConstants.TASK.COLUMNS.DESCRIPTION,
                DataBaseConstants.TASK.COLUMNS.STATUS
            )

            val selection = DataBaseConstants.TASK.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstants.TASK.TABLE_NAME,
                projection,
                selection,
                args,
                null,
                null,
                null
            )
            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()

                val title = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.TITLE))
                val description = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.DESCRIPTION))
                val status = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.STATUS))

                task = Task(id, title, description, status)
            }
            cursor?.close()

            task
        } catch (e: Exception) {
            task
        }
    }

    fun getAll(): List<Task> {
        val list: MutableList<Task> = ArrayList()

        return try {
            val db = mTaskDataBaseHelper.readableDatabase

            //db.rawQuery -> escreve uma query direto no Db

            val projection = arrayOf(
                DataBaseConstants.TASK.COLUMNS.ID,
                DataBaseConstants.TASK.COLUMNS.TITLE,
                DataBaseConstants.TASK.COLUMNS.DESCRIPTION,
                DataBaseConstants.TASK.COLUMNS.STATUS
            )


            val cursor = db.query(
                DataBaseConstants.TASK.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.ID))
                    val title = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.TITLE))
                    val description = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.DESCRIPTION))
                    val status = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.STATUS))

                    val task = Task(id, title, description, status)


                    list.add(task)

                }


            }
            cursor?.close()

            list
        } catch (e: Exception) {
            list
        }
        return list
    }

    fun delete(id: Int): Boolean {
        return try {
            val db = mTaskDataBaseHelper.writableDatabase


            val selection = DataBaseConstants.TASK.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.TASK.TABLE_NAME, selection, args)

            true
        } catch (e: Exception) {
            false
        }

    }
    fun update(task: Task): Boolean {
        return try {
            val db = mTaskDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.TASK.COLUMNS.TITLE, task.title)
            contentValues.put(DataBaseConstants.TASK.COLUMNS.DESCRIPTION, task.description)
            contentValues.put(DataBaseConstants.TASK.COLUMNS.STATUS, task.status)

            val selection = DataBaseConstants.TASK.COLUMNS.ID + " = ?"
            val args = arrayOf(task.id.toString())

            db.update(DataBaseConstants.TASK.TABLE_NAME, contentValues, selection, args)

            true
        } catch (e: Exception) {
            false
        }


    }
    fun getProgress(): List<Task> {
        val list: MutableList<Task> = ArrayList()

        return try {
            val db = mTaskDataBaseHelper.readableDatabase


            val cursor = db.rawQuery("Select * from Guest where status = 'A_FAZER'", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.ID))
                    val title = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.TITLE))
                    val description = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.DESCRIPTION))
                    val status = cursor.getString(cursor.getColumnIndex(DataBaseConstants.TASK.COLUMNS.STATUS))

                    val task = Task(id, title, description,status)
                    list.add(task)

                }


            }
            cursor?.close()

            list
        } catch (e: Exception) {
            list
        }
        return list
    }

}