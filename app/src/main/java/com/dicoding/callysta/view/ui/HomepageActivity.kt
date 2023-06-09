package com.dicoding.callysta.view.ui

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.callysta.R
import com.dicoding.callysta.databinding.ActivityHomepageBinding
import com.dicoding.callysta.utils.dataStore
import com.dicoding.callysta.view.adapter.TaskPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomepageActivity : AppCompatActivity() {

    private val binding: ActivityHomepageBinding by lazy {
        ActivityHomepageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        tabLayoutViewPagerSetup()
    }

    private fun tabLayoutViewPagerSetup() {
        val taskPagerAdapter = TaskPagerAdapter(this, dataStore)
        val viewPager = binding.viewPager
        viewPager.adapter = taskPagerAdapter

        val tabs: TabLayout = binding.tabLayout
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    companion object {
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_0,
            R.string.tab_text_1,
        )
    }
}