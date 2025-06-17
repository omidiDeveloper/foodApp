package com.example.appfoodkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.appfoodkotlin.App.SharedPref
import com.example.appfoodkotlin.R
import com.example.foodkotlin.App.Base

class SplashActivity : AppCompatActivity() {

    var login: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Base.sharedPref = SharedPref(this)

        login = Base.sharedPref!!.getLogin()!!
        if (login) {
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 4000)
        } else {

            Handler().postDelayed({
                //startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }, 4000)
        }

    }
}