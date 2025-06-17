package com.example.appfoodkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appfoodkotlin.R
import com.example.appfoodkotlin.fragment.FilterFragment
import com.example.foodkotlin.App.Base
import com.example.foodkotlin.activity.fragment.SearchFragment
import com.example.foodkotlin.dataBase.DataBase
import com.example.foodkotlin.fragment.HomeFragment
import com.example.foodkotlin.fragment.PersonFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {    var bottomNavigationView: BottomNavigationView? = null
    var txtCategory: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        txtCategory = findViewById(R.id.txt_category_bottom)
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment())
            .commit()
        Base.dataBase = DataBase(this)
        Base.activity = this
        txtCategory!!.text = "خانه"
        bottomNavigationView!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, HomeFragment()).commit()
                    txtCategory!!.text = "خانه"
                }
                R.id.bottom_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment()).commit()
                    txtCategory!!.text = "جستجو"
                }
                R.id.bottom_person -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, PersonFragment()).commit()
                    txtCategory!!.text = "شخصی"
                }
                R.id.bottom_filter -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, FilterFragment()).commit()
                    txtCategory!!.text = "پخت و پز"
                }
            }
            true
        }
    }
}