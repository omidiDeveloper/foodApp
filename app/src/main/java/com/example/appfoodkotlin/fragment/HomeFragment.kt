package com.example.foodkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.appfoodkotlin.R
import com.example.foodkotlin.activity.fragment.tablayout.BrunchFragment
import com.example.foodkotlin.activity.fragment.tablayout.CakeFragment
import com.example.foodkotlin.activity.fragment.tablayout.DinnerFragment
import com.example.foodkotlin.activity.fragment.tablayout.LucnhFragment
import com.example.foodkotlin.adapter.AdapterViewPager
import com.google.android.material.tabs.TabLayout

class HomeFragment() : Fragment() {

    var viewLayout: View? = null

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLayout = inflater.inflate(R.layout.fragment_home, container, false)

        cast()

        return viewLayout
    }

    private fun cast() {
        tabLayout = viewLayout!!.findViewById(R.id.tab_layout)
        viewPager = viewLayout!!.findViewById(R.id.view_pager)
        adapter()
    }

    private fun adapter() {
        val adapterViewPager = AdapterViewPager(childFragmentManager)
        adapterViewPager.setFragment(BrunchFragment(), "ضبحانه")
        adapterViewPager.setFragment(LucnhFragment(), "ناهار")
        adapterViewPager.setFragment(DinnerFragment(), "شام")
        adapterViewPager.setFragment(CakeFragment(), "کیک و بستنی")
        viewPager!!.adapter = adapterViewPager
        tabLayout!!.setupWithViewPager(viewPager)

    }

}
