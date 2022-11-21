package com.example.pertemuan5mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSucculent: RecyclerView
    private var list: ArrayList<Succulent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSucculent = findViewById(R.id.rv_id)
        rvSucculent.setHasFixedSize(true)

        list.addAll(SucculentData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvSucculent.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListSucculentAdapter(list)
        rvSucculent.adapter = listHeroAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {

            }
            R.id.about_me -> {

            }

        }
    }
}