@file:Suppress("DEPRECATION")

package com.example.minhastarefas.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.minhastarefas.view.ProgressTasksFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ProgressTasksFragment()
            1 -> ProgressTasksFragment()
            2 -> ProgressTasksFragment()
            else -> ProgressTasksFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "A fazer"
            1 -> "Em andamento"
            2 -> "Feito"
            else -> super.getPageTitle(position)
        }
    }
}
