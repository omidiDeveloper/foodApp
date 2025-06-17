package com.example.appfoodkotlin.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.appfoodkotlin.R
import com.example.foodkotlin.App.*
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    var txtName: TextView? = null
    var txtTypeRawMat: TextView? = null
    var txtRawMat: TextView? = null
    var txtDescription: TextView? = null
    var imageView: ImageView? = null


    var btnFavorite: ImageView? = null
    var id: Int? = null
    var value: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        cast()
        getData()

        checkFav()

        btnFavorite!!.setOnClickListener {
            addOrRemove()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getData() {
        val intent: Bundle? = intent.extras
        txtName!!.text = " ${intent!!.getString(keyCategory)} : ${intent.getString(keyName)} "
        txtTypeRawMat!!.text = intent.getString(key_type_raw_mat)
        txtRawMat!!.text = intent.getString(key_raw_mat)
        txtDescription!!.text = intent.getString(key_description)
        Picasso.get().load(intent.getString(key_image)).into(imageView)
        id = intent.getInt(key_id)
    }

    private fun cast() {
        txtName = findViewById(R.id.txt_name_food_detail)
        txtTypeRawMat = findViewById(R.id.txt_type_raw_mat)
        txtRawMat = findViewById(R.id.txt_raw_mat)
        txtDescription = findViewById(R.id.txt_description)
        imageView = findViewById(R.id.image_detail)
        btnFavorite = findViewById(R.id.btn_favorite)
        val back = findViewById<ImageView>(R.id.btn_back_detail)
        back.setOnClickListener {
            finish()
        }
    }

    private fun checkFav() {
        value = Base.dataBase!!.getValue(id!!)
        if (value == 0) {
            btnFavorite!!.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        } else if (value == 1) {
            btnFavorite!!.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }

    private fun addOrRemove(){
        value=Base.dataBase!!.getValue(id!!)
        if (value==0){
            Base.dataBase!!.getStatus(1,id!!)
            btnFavorite!!.setImageResource(R.drawable.ic_baseline_favorite_24)
            Toast.makeText(this,"بهد قسمت مورد علاقه ها اضافه شد",Toast.LENGTH_LONG).show()
        }else if (value ==1){
            Base.dataBase!!.getStatus(0,id!!)
            btnFavorite!!.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            Toast.makeText(this,"از قسمت مورد علاقه ها حذف شد",Toast.LENGTH_LONG).show()

        }
    }
}