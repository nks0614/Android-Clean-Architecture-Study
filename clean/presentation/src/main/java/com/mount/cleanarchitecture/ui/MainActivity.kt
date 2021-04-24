package com.mount.cleanarchitecture.ui

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mount.cleanarchitecture.R
import com.mount.cleanarchitecture.base.BindingActivity
import com.mount.cleanarchitecture.base.ViewPagerAdapter
import com.mount.cleanarchitecture.databinding.ActivityMainBinding


class MainActivity : BindingActivity<ActivityMainBinding>() {

    //ViewPager를 구현하기 위한 Adapter
    private lateinit var viewPagerAdapter : ViewPagerAdapter

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.setFragmentList(arrayListOf(GithubFragment(), BookmarkFragment()))

        binding.pagerLayout.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.pagerLayout) { tab: TabLayout.Tab, position: Int ->
            when(position){
                0 -> tab.text = "Github"
                1 -> tab.text = "Bookmark"
            }
            binding.pagerLayout.setCurrentItem(tab.position, true)
        }.attach()

    }

    override fun observeEvent() { }
}