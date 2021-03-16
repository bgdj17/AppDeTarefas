package com.example.minhastarefas.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.minhastarefas.R
import com.example.minhastarefas.TaskAdapter
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.viewmodel.BottonSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottonsheet_fragment.*


class BottonSheetFragment : BottomSheetDialogFragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottonsheet_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var title = editTextTitle.text.toString()
        var description = editTextDescription.text.toString()
        var task = Task(title, description, "A_FAZER")

        //val model = ViewModelProviders.of(activity!!).get(BottonSheetViewModel::class.java)

        btnCreateTask.setOnClickListener {
            ///model!!.dataTask(task)

            TaskFragmentProgress.listTask.add(task)

            Toast.makeText(context, "Deu certooo!!!", Toast.LENGTH_SHORT).show()



        }
    }

    fun setListeners() {
        btnCreateTask.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id

    }

}