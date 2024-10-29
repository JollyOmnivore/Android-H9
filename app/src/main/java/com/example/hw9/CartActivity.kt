package com.example.hw9

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var cartListView: ListView

class CartActivity : AppCompatActivity() {
    lateinit var pickDate : Button
    lateinit var pickTime : Button
    lateinit var submitOrder : Button
    lateinit var deliveryDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart2)
        //says hey we wanna use a toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cartListView = findViewById(R.id.cartListView)

        pickDate = findViewById(R.id.pickDate)
        pickTime = findViewById(R.id.pickTime)
        submitOrder = findViewById(R.id.submitOrder)
        deliveryDate = findViewById(R.id.deliveryDate)


        var dateOfOrder : String
        var timeOfOrder : String

        if (intent.getStringExtra("Time") != null){
            //Toast.makeText(this,"yippe", Toast.LENGTH_SHORT).show()
            timeOfOrder = intent.getStringExtra("Time").toString()
            CurrentTimeAndDate.Time = timeOfOrder
        }
        if (intent.getStringExtra("Date") != null){
            //Toast.makeText(this,"yippe", Toast.LENGTH_SHORT).show()
            dateOfOrder = intent.getStringExtra("Date").toString()
            CurrentTimeAndDate.Date = dateOfOrder
        }
        if (intent.getStringExtra("Date") != null && intent.getStringExtra("Time") != null){
            Toast.makeText(this,"it works", Toast.LENGTH_SHORT).show()
        }



        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_expandable_list_item_1,
            Model.cart
        )
        cartListView.adapter = adapter

        submitOrder.setOnClickListener {
            if (CurrentTimeAndDate.Date != "" && CurrentTimeAndDate.Time != ""){
                Toast.makeText(this,"Good to go", Toast.LENGTH_SHORT).show()// for testing

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Checkout")
                builder.setMessage("Delivery " + CurrentTimeAndDate.Time + " " + CurrentTimeAndDate.Date)

                builder.setPositiveButton("Yes") { dialog, which ->
                    // set time and date to ""
                    // clear cart
                    // send to order screen
                    deliveryDate.text = "Delivery " + CurrentTimeAndDate.Time + " " + CurrentTimeAndDate.Date
                    CurrentTimeAndDate.Time = ""
                    CurrentTimeAndDate.Date = ""
                    //Toast.makeText(this,"funny", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("No") { dialog, which ->
                    //nothing happens
                   // Toast.makeText(this,"sad", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
            else{
                Toast.makeText(this,"Please Select Time and Date of delivery", Toast.LENGTH_SHORT).show()
            }

        }

        pickDate.setOnClickListener {
            //Toast.makeText(this,"Test1", Toast.LENGTH_SHORT).show()
            val DateFragment = DateFragment()
            DateFragment.show(supportFragmentManager,null)

        }
        pickTime.setOnClickListener {
            //Toast.makeText(this,"Test2", Toast.LENGTH_SHORT).show()
            val TimeFragment = TimePicker()
            TimeFragment.show(supportFragmentManager,null)

        }



    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cart_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.itemA -> { // add the clear function then update
                Toast.makeText(this,"Cart Cleared", Toast.LENGTH_SHORT).show()
                Model.cart.clear()
                val adapter = ArrayAdapter(// im sorry I couldn't figure out to use notify change outside of main
                    applicationContext,
                    android.R.layout.simple_expandable_list_item_1,
                    Model.cart
                )
                cartListView.adapter = adapter
                //createOrUpdateAdapter(true)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}