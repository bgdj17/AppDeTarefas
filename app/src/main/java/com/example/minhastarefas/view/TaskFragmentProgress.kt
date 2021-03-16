package com.example.minhastarefas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.R
import com.example.minhastarefas.TaskAdapter
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.view.TaskFragmentProgress.Companion.listTask


class TaskFragmentProgress : Fragment() {

    lateinit var adapter: TaskAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rvTask = view.findViewById<RecyclerView>(R.id.listTask)
        adapter = TaskAdapter(listTask)
        rvTask.adapter = adapter
        rvTask.layoutManager = LinearLayoutManager(requireContext())
        adapter.notifyDataSetChanged()


    }
    override fun onResume(){
        super.onResume()
        adapter.notifyDataSetChanged()
    }
    companion object{
        val listTask = mutableListOf(
            Task("Criar Tarefa", "Tenho que finalizar o projeto do curso CTT", "A_FEITO"),
            Task("Criar AddTarefa", "Tenho que finalizar o projeto do curso CTT", "A_FAZER"),
            Task("Criar Filtro de Tarefa", "Tenho que finalizar o projeto do curso CTT", "A_FAZER"),
        )
    }
}