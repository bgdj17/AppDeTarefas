package com.example.minhastarefas.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.minhastarefas.view.adapter.PageAdapter
import com.example.minhastarefas.R
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fabAdd)
        fab.setOnClickListener {
            startActivity(Intent(applicationContext, TaskFormAddActivity::class.java))
        }

        val tabLayout = tabLayout
        val viewPager = viewPager

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }



}