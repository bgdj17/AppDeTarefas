package com.example.minhastarefas.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.R
import com.example.minhastarefas.services.constants.TaskConstants
import com.example.minhastarefas.view.adapter.TaskAdapter
import com.example.minhastarefas.view.listener.TaskListener
import com.example.minhastarefas.viewmodel.TaskViewModel


class ProgressTasksFragment : Fragment() {
    private lateinit var mViewModel: TaskViewModel
    private  var adapter: TaskAdapter = TaskAdapter()
    private lateinit var mListener: TaskListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_task_progress, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.listTask)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        mListener = object : TaskListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, TaskFormViewActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(TaskConstants.TASKID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {

                mViewModel.load(TaskConstants.FILTER.TODO)

            }
        }
        adapter.attachListener(mListener)
        observer()
        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(TaskConstants.FILTER.TODO)

    }

    private fun observer() {

        mViewModel.taskList.observe(viewLifecycleOwner, Observer {
            adapter.updateTask(it)
            adapter.notifyDataSetChanged()
        })
    }

}