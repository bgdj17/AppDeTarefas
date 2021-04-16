package com.example.minhastarefas.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.minhastarefas.R
import com.example.minhastarefas.services.constants.TaskConstants
import com.example.minhastarefas.viewmodel.BottonSheetViewModel
import kotlinx.android.synthetic.main.bottonsheet_fragment.*

class TaskFormAddActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModelProgress: BottonSheetViewModel
    private var mTaskId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottonsheet_fragment)

        mViewModelProgress = ViewModelProvider(this).get(BottonSheetViewModel::class.java)

        setListeners()
        observe()
        loadData()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btnCreateTask) {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            mViewModelProgress.save(mTaskId, title, description, "A_FAZER")
            loadData()

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
            editTextTitle.setText(it.title)
            editTextDescription.setText(it.description)
        })

    }

    private fun setListeners() {
        btnCreateTask.setOnClickListener(this)
    }

}