package com.example.foodkotlin.activity.fragment.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodkotlin.R
import com.example.foodkotlin.App.Base
import com.example.foodkotlin.adapter.AdapterFood

class BrunchFragment() : Fragment() {

    var viewLayout: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLayout = inflater.inflate(R.layout.fragment_brunch, container, false)
        cast()
        return viewLayout
    }

    var recycler: RecyclerView? = null
    var adapterFood: AdapterFood? = null
    private fun cast() {
        recycler = viewLayout!!.findViewById(R.id.recycler_brunch)
        recycler!!.setHasTransientState(true)
        recycler!!.layoutManager=LinearLayoutManager(Base.activity)
        val list=Base.dataBase!!.getCategory("brunch")
        adapterFood= AdapterFood(Base.activity!!,list)
        recycler!!.adapter=adapterFood
    }

}