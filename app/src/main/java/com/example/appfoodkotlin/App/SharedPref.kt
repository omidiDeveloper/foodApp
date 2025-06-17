package com.example.appfoodkotlin.App

import android.content.Context
import android.content.SharedPreferences
import com.example.foodkotlin.App.keyName

class SharedPref(context: Context) {
    val login = "LOGIN"
    var sharedPreferences: SharedPreferences = context.getSharedPreferences(login, 0)
    var editor: SharedPreferences.Editor = sharedPreferences.edit()

    val keyNameSH = "keyNameSh"
    val keyPhoneSH = "keyPhoneSh"

    fun setName(name: String) {
        editor.putString(keyNameSH, name)
        editor.commit()
    }

    fun getName(): String? {
        return sharedPreferences.getString(keyNameSH,"null")
    }

    fun setPhone(phone: String) {
        editor.putString(keyPhoneSH, phone)
        editor.commit()
    }

    fun getPhone(): String? {
        return sharedPreferences.getString(keyPhoneSH,"null")
    }

    val keyLogin = "keyLoginSh"

    fun setLogin(login: Boolean) {
        editor.putBoolean(keyLogin, login)
        editor.commit()
    }

    fun getLogin(): Boolean? {
        return sharedPreferences.getBoolean(keyLogin, false)
    }
}