package com.bebooo43.cv.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bebooo43.cv.main.about.AboutMeFragment
import com.bebooo43.cv.main.contact.ContactFragment
import com.bebooo43.cv.main.home.HomeFragment
import com.bebooo43.cv.main.work.WorkFragment

class MainViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> HomeFragment()
            1 -> AboutMeFragment()
            2 -> WorkFragment()
            3 -> ContactFragment()
            else -> Fragment()
        }
}