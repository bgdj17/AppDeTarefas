@file:Suppress("DEPRECATION")

package com.example.minhastarefas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TaskFragmentProgress()
            1 -> TaskFragmentProgress()
            2 -> TaskFragmentProgress()
            else -> TaskFragmentProgress()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Em andamento"
            1 -> "A fazer"
            2 -> "Feito"
            else -> super.getPageTitle(position)
        }
    }
}
