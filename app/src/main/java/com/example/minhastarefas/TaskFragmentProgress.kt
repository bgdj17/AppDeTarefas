package com.example.minhastarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minhastarefas.model.Task

class TaskFragmentProgress : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listTasks = mutableListOf<Task>(
            Task("Criar Fragmente", "Tenho que finalizar o projeto do curso CTT"),
            Task("Novas Tarefas", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("Criar Fragmente", "Tenho que finalizar o projeto do curso CTT"),
            Task("Novas Tarefas", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
            Task("TabLayout", "Tenho que finalizar o projeto do curso CTT"),
        )

        var rvTask = view.findViewById<RecyclerView>(R.id.listTask)

        val adapterTask = TaskAdapter(listTasks)
        rvTask.adapter = adapterTask

        rvTask.layoutManager = LinearLayoutManager(requireContext())

    }
}