package com.example.appfoodkotlin.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodkotlin.R
import com.example.foodkotlin.adapter.AdapterFood
import com.example.foodkotlin.dataBase.DataBase

class FilterFragment : Fragment() {

    private lateinit var checkMeat: CheckBox
    private lateinit var checkOnion: CheckBox
    private lateinit var checkTomato: CheckBox
    private lateinit var checkPepper: CheckBox
    private lateinit var checkChicken: CheckBox
    private lateinit var checkCheese: CheckBox
    private lateinit var checkEgge: CheckBox
    private lateinit var btnFilter: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterFood
    private lateinit var database: DataBase

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filter, container, false)

        // Initialize Views
        checkMeat = view.findViewById(R.id.checkboxMeat)
        checkOnion = view.findViewById(R.id.checkboxOnion)
        checkTomato = view.findViewById(R.id.checkboxTomato)
        checkChicken = view.findViewById(R.id.checkboxChicken)
        checkPepper = view.findViewById(R.id.checkboxPepper)
        checkCheese = view.findViewById(R.id.checkboxCheese)
        checkEgge = view.findViewById(R.id.checkboxEgge)

        btnFilter = view.findViewById(R.id.btnFilter)
        recyclerView = view.findViewById(R.id.recycler_foods)

        database = DataBase(requireContext())

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterFood(requireContext(), ArrayList())
        recyclerView.adapter = adapter

        btnFilter.setOnClickListener {
            filterFoods()
        }

        return view
    }

    private fun filterFoods() {
        val selectedIngredients = mutableListOf<String>()

        if (checkMeat.isChecked) selectedIngredients.add("گوشت")
        if (checkOnion.isChecked) selectedIngredients.add("پیاز")
        if (checkTomato.isChecked) selectedIngredients.add("رب")
        if (checkPepper.isChecked) selectedIngredients.add("فلفل")
        if (checkChicken.isChecked) selectedIngredients.add("مرغ")
        if (checkCheese.isChecked) selectedIngredients.add("پنیر")
        if (checkEgge.isChecked) selectedIngredients.add("تخم مرغ")

        if (selectedIngredients.isEmpty()) {
            Toast.makeText(requireContext(), "لطفا حداقل یک مورد را انتخاب کنید", Toast.LENGTH_SHORT).show()
            return
        }

        val allFoods = database.getAll()

        val filteredFoods = allFoods.filter { food ->
            selectedIngredients.all { ingredient ->
                food.typeRawMat!!.contains(ingredient)
            }
        }

        adapter.updateList(filteredFoods)
    }
}
