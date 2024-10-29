package com.example.hw9

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw9.DetailActivity
import com.example.hw9.ItemAdapter


class MainActivity : AppCompatActivity(),ItemAdapter.ItemAdapterListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //code | (future self) "ah yes code"
        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        val itemAdapter= ItemAdapter(this)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.itemA -> {
                Toast.makeText(this,"A was clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, CartActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun click(position: Int) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("DETAIL",position)
        startActivity(intent)
    }

}