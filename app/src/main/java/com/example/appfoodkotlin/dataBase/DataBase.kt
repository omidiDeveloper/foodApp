package com.example.foodkotlin.dataBase

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.text.IDNA
import android.util.Log
import com.example.appfoodkotlin.model.Food
import com.example.foodkotlin.dataBase.Info_db.dbName
import com.example.foodkotlin.dataBase.Info_db.packageData
import com.example.foodkotlin.dataBase.Info_db.source
import java.io.File
import java.io.FileOutputStream

class DataBase(val context: Context) :
    SQLiteOpenHelper(context, dbName, null, Info_db.dbVersion) {
    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    init {
        initDataBase()
    }

    fun initDataBase() {
        var file = File(packageData)
        if (file.exists()) {

        } else {
            file.mkdirs()
        }
        file = context.getDatabasePath(Info_db.dbName)
        if (file.exists()) {

        } else {
            copyDataBase()
        }
    }

    fun copyDataBase() {
        val inputStream = context.assets.open(source)
        val outFile = packageData + dbName
        val uotPutStream = FileOutputStream(outFile)
        val buffer = ByteArray(1024)
        var lenght = 0
        while (inputStream.read(buffer).also({ lenght = it }) > 0)
            uotPutStream.write(buffer, 0, lenght)
        uotPutStream.flush()
        uotPutStream.close()
        inputStream.close()
    }

    @SuppressLint("Range")
    fun getAll(): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine"
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(Info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbRawmat))
                food.category = cursor.getString(cursor.getColumnIndex(Info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(Info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(Info_db.dbDescripotion))
                food.id = cursor.getInt(cursor.getColumnIndex(Info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(Info_db.fav))
                list.add(food)

            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list
    }

    @SuppressLint("Range")
    fun getCategory(category: String): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine WHERE category = '$category'"
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(Info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbRawmat))
                food.category = cursor.getString(cursor.getColumnIndex(Info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(Info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(Info_db.dbDescripotion))
                food.id = cursor.getInt(cursor.getColumnIndex(Info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(Info_db.fav))
                list.add(food)
                Log.d(
                    "message",
                    "Log DataBase name ==> ${food.nameFood} and category === > ${food.category}"
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list
    }

    @SuppressLint("Range")
    fun getFav(): ArrayList<Food> {
        val db = readableDatabase
        val query = "SELECT * FROM zine WHERE fav = 1"
        val list: ArrayList<Food> = ArrayList()
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val food = Food()
                food.nameFood = cursor.getString(cursor.getColumnIndex(Info_db.dbNameFood))
                food.typeRawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbTypeRawMat))
                food.rawMat = cursor.getString(cursor.getColumnIndex(Info_db.dbRawmat))
                food.category = cursor.getString(cursor.getColumnIndex(Info_db.dbCategory))
                food.image = cursor.getString(cursor.getColumnIndex(Info_db.dbImage))
                food.description = cursor.getString(cursor.getColumnIndex(Info_db.dbDescripotion))
                food.id = cursor.getInt(cursor.getColumnIndex(Info_db.dbId))
                food.fav = cursor.getInt(cursor.getColumnIndex(Info_db.fav))
                list.add(food)

            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list
    }

    @SuppressLint("Range")
    fun getValue(id: Int): Int {
        val db = readableDatabase
        val query = "SELECT ${Info_db.fav} FROM zine WHERE ${Info_db.dbId} = $id"
        var value = 0
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndex(Info_db.fav))
            do {

            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return value
    }

    fun getStatus(status: Int, id: Int) {
        val db = readableDatabase
        val query = "UPDATE zine SET ${Info_db.fav} = $status WHERE ${Info_db.dbId} = $id"
        db.execSQL(query)
        db.close()
    }

}