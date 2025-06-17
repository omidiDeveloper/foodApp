package com.example.foodkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodkotlin.R
import com.example.foodkotlin.App.Base
import com.example.foodkotlin.adapter.AdapterSearch

class PersonFragment() : Fragment() {


    var layoutView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_person, container, false)
        cast()
        return layoutView
    }

    private fun cast() {
        val recyclerView = layoutView!!.findViewById<RecyclerView>(R.id.recycler_favorite)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(Base.activity, 2)
        val list = Base.dataBase!!.getFav()
        val adapterFav = AdapterSearch(Base.activity!!, list)
        recyclerView.adapter = adapterFav
    }


}


//        val name=layoutView!!.findViewById<TextView>(R.id.txt_name_person)
//        val phone=layoutView!!.findViewById<TextView>(R.id.txt_phone_person)
//        name.text=" نام کابری : "+Base.sharedPref!!.getName()
//        phone.text="شماره کاربر : "+Base.sharedPref!!.getPhone()
