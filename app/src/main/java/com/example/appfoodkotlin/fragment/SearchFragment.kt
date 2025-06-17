package com.example.foodkotlin.activity.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodkotlin.R
import com.example.appfoodkotlin.model.Food
import com.example.foodkotlin.App.Base
import com.example.foodkotlin.adapter.AdapterSearch

class SearchFragment() : Fragment() {


    var layoutView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_search, container, false)
        cast()
        return layoutView
    }

    var recyclerView: RecyclerView? = null
    var editText: EditText? = null
    var list: ArrayList<Food>? = null
    var adapterSearch: AdapterSearch? = null
    var backSearch: RelativeLayout? = null
    private fun cast() {

        editText = layoutView!!.findViewById(R.id.ed_search)
        recyclerView = layoutView!!.findViewById(R.id.recycler_search)
        backSearch = layoutView!!.findViewById(R.id.rel_search)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = GridLayoutManager(Base.activity!!, 3)
        list = Base.dataBase!!.getAll()
        adapterSearch = AdapterSearch(Base.activity!!, list!!)
        recyclerView!!.adapter = adapterSearch
        showBack()
        editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    showBack()
                } else {
                    hideBack()
                    filterSearch(s.toString())
                }
            }
        })
    }

    private fun showBack() {
        backSearch!!.visibility = View.VISIBLE
        recyclerView!!.visibility = View.GONE
    }

    private fun hideBack() {
        backSearch!!.visibility = View.GONE
        recyclerView!!.visibility = View.VISIBLE
    }

    fun filterSearch(search: String) {
        val listSearch = ArrayList<Food>()
        for (food: Food in list!!) {
            if (food.nameFood!!.toLowerCase().contains(search)) {
                listSearch.add(food)
            }
        }
        adapterSearch!!.filter(listSearch)
    }
}