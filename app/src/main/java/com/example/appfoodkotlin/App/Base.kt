package com.example.foodkotlin.App

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.appfoodkotlin.App.SharedPref
import com.example.appfoodkotlin.R
import com.example.foodkotlin.dataBase.DataBase
import org.w3c.dom.Text

@SuppressLint("StaticFieldLeak")
object Base : Application() {
    var dataBase: DataBase? = null
    var context: Context? = null
    var activity: Activity? = null
    var sharedPref: SharedPref? = null

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}