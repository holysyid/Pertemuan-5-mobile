package com.example.pertemuan5mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class DetailedActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var currentImage: ImageView
    private lateinit var succulentName: TextView
    private lateinit var commonName: TextView
    private lateinit var succulentDetail: TextView
    private lateinit var sun_asp: TextView
    private lateinit var grow_asp: TextView
    private lateinit var water_asp: TextView
    private lateinit var temp_asp: TextView
    private lateinit var prop_asp: TextView
    private lateinit var tox_asp: TextView
    private lateinit var dor_asp: TextView



    companion object {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        val btnbuy: Button = findViewById(R.id.buy)
        btnbuy.setOnClickListener(this)
        val btnBack: TextView = findViewById(R.id.backToMain)
        btnBack.setOnClickListener(this)

        setDataFiles()

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.backToMain->{
                val backIntent = Intent(this@DetailedActivity, MainActivity::class.java)
            startActivity(backIntent)
            }
            R.id.buy->{
                //val halo = intent.getStringExtra(DATA_NAME)
                //Toast.makeText(this, "$halo Will Be Coming Soon", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun setDataFiles() {

        succulentName = findViewById(R.id.sucname)
        commonName  =   findViewById(R.id.comname)
        succulentDetail = findViewById(R.id.detailed)
        sun_asp = findViewById(R.id.sunval)
        grow_asp = findViewById(R.id.growval)
        water_asp = findViewById(R.id.waterval)
        temp_asp = findViewById(R.id.tempval)
        prop_asp = findViewById(R.id.propval)
        tox_asp = findViewById(R.id.toxval)
        dor_asp = findViewById(R.id.dorval)

        //val dataImage = intent.getIntExtra(DATA_PICT, 0)
        val item : Succulent? = intent.getParcelableExtra("items")
        currentImage = findViewById(R.id.image_placeholder)
        currentImage.setImageResource(item!!.picture)
        succulentName.text=item.name
        commonName.text=item.common_name
        succulentDetail.text=item.detail
        sun_asp.text=item.sun
        grow_asp.text=item.grow
        water_asp.text=item.water
        temp_asp.text=item.temp
        prop_asp.text=item.propagation
        tox_asp.text=item.toxic
        dor_asp.text=item.dormant
    }



}