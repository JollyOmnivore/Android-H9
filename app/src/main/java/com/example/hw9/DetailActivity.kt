package com.example.hw9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    lateinit var bookName : TextView
    lateinit var bookDescription : TextView
    lateinit var bookImage : ImageView
    lateinit var addToCart : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        bookName = findViewById(R.id.bookName)
        bookDescription = findViewById(R.id.bookDescription)
        bookImage = findViewById(R.id.bookImage)
        addToCart = findViewById(R.id.addToCart)

        val intent = intent
        val position = intent.getIntExtra("DETAIL",0)
        val item = Model.items[position]


        bookName.text = item.name.toString()
        bookDescription.text = item.description.toString()
        bookImage.setImageResource(item.ImageReasourceID)

        addToCart.setOnClickListener {
            Model.cart.add(item)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }
}