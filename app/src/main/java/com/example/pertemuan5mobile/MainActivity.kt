package com.example.pertemuan5mobile

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    //declaring recycleview variable
    private lateinit var rvSucculent: RecyclerView
    //delaring arraylist variable with Succulent class of data
    private var list: ArrayList<Succulent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initiating viewgroup for recyclerview and assigning it to variable
        rvSucculent = findViewById(R.id.rv_id)
        rvSucculent.setHasFixedSize(true)

        //Adding Data from succulent arraylist to eisting arraylist in this class
        list.addAll(SucculentData.listData)
        //run this function
        showRecyclerList()
    }
    private fun showRecyclerList() {
        //inflating layout manager for the recyclerview with this class as context,with type of linear layout
        rvSucculent.layoutManager = LinearLayoutManager(this)
        //assigning variable with class adapter constructed
        val listSucAdapter = ListSucculentAdapter(list)
        //assigning adapterobject to recyclerview
        rvSucculent.adapter = listSucAdapter
    }
    private fun showRecyclerGrid() {
        rvSucculent.layoutManager = GridLayoutManager(this, 2)
        val gridHSucAdapter = GridSucculentAdapter(list)
        rvSucculent.adapter = gridHSucAdapter
    }
    //implementing menu on create
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //implementing menu option select with MenuItem parameter
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //running setmode function
        setMode(item.itemId)
        //returning to superclass
        return super.onOptionsItemSelected(item)
    }
    //selecting mode when clicked, with ID of item as parameter
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            //detecting ID of item
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.about_me -> {

            }

        }
    }
}