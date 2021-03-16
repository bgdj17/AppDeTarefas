package com.example.minhastarefas.model

class Task(val title: String, val description : String?, var status : String? ){

    companion object{
        val list = mutableListOf<Task>(
            Task("Criar Fragmente", "Tenho que finalizar o projeto do curso CTT", "A_FAZER"),
        )

    }
}