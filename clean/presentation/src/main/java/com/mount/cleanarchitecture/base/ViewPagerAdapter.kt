package com.mount.cleanarchitecture.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentList = mutableListOf<Fragment>()

    fun setFragmentList(fragment : ArrayList<Fragment>){
        fragmentList.clear()
        fragmentList.addAll(fragment)
    }

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]


}