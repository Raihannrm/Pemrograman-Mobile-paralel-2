package com.example.raihanuts

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailClubActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val club = intent.getParcelableExtra<Club>(MainActivity.EXTRA_CLUB)

        val imgeclub = findViewById<ImageView>(R.id.img_gambar)
        val nameclub = findViewById<TextView>(R.id.tv_item_name)
        val jlkclub = findViewById<TextView>(R.id.tv_item_jlk)
        val yearclub = findViewById<TextView>(R.id.tv_item_year)
        val homeclub = findViewById<TextView>(R.id.tv_item_homebase)
        val supclub = findViewById<TextView>(R.id.tv_item_sup)
        val deskripclub = findViewById<TextView>(R.id.tv_item_des)

        imgeclub.setImageResource(club?.imgeclub!!)
        nameclub.text = club.nameclub
        jlkclub.text = club.jlkclub
        yearclub.text = club.yearclub
        homeclub.text = club.homeclub
        supclub.text = club.supclub
        deskripclub.text = club.deskripclub

    }
    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}