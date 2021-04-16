package com.example.minhastarefas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.minhastarefas.R
import com.example.minhastarefas.services.constants.TaskConstants
import com.example.minhastarefas.viewmodel.BottonSheetViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_task_view.*

class TaskFormViewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModelProgress: BottonSheetViewModel
    private var mTaskId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_view)

        mViewModelProgress = ViewModelProvider(this).get(BottonSheetViewModel::class.java)

        setListeners()
        observe()
        loadData()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_initiate_task) {
            val title = view_task_title.text.toString()
            val description = view_task_description.text.toString()

            mViewModelProgress.save(mTaskId, title, description, "EM ANDAMENTO")

        } else if(id == R.id.button_edit){

                startActivity(Intent(applicationContext, TaskVFormEditActivity::class.java))

        }
    }

    fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            mTaskId = bundle.getInt(TaskConstants.TASKID)
            mViewModelProgress.load(mTaskId)
        }
    }

    private fun observe() {
        mViewModelProgress.saveTask.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })
        mViewModelProgress.task.observe(this, Observer {
            view_task_title.text = it.title
            view_task_description.text = it.description
            view_task_status.text = it.status
        })


    }

    private fun setListeners() {
        button_initiate_task.setOnClickListener(this)
        button_edit.setOnClickListener(this)
    }



}