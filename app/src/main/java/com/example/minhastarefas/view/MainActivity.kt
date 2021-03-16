package com.example.minhastarefas.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.minhastarefas.PageAdapter
import com.example.minhastarefas.R
import com.example.minhastarefas.model.Task
import com.example.minhastarefas.viewmodel.BottonSheetViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = BottonSheetFragment()
        fabAdd.setOnClickListener {
            fragment.show(supportFragmentManager, "add_to_album")
            BottomSheetBehavior.PEEK_HEIGHT_AUTO
        }

        val tabLayout = tabLayout
        val viewPager = viewPager

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }



}