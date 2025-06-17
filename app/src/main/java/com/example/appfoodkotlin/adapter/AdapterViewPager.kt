package com.example.foodkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterViewPager(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragmentList: ArrayList<Fragment> = ArrayList()
    val titleList: ArrayList<String> = ArrayList()


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }

    fun setFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

}