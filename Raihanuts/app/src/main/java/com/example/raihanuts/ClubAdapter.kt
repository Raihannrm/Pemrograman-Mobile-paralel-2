package com.example.raihanuts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClubAdapter (private val context: Context,private val club: List<Club>, val listener: (Club) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>(){

    class ClubViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgeclub = view.findViewById<ImageView>(R.id.img_gambar)
        val nameclub = view.findViewById<TextView>(R.id.tv_item_name)
        val jlkclub = view.findViewById<TextView>(R.id.tv_item_jlk)
        val yearclub = view.findViewById<TextView>(R.id.tv_item_year)
        val homeclub = view.findViewById<TextView>(R.id.tv_item_homebase)
        val supclub = view.findViewById<TextView>(R.id.tv_item_sup)

        fun bindView(club: Club, listener: (Club) -> Unit){
            imgeclub.setImageResource(club.imgeclub)
            nameclub.text = club.nameclub
            jlkclub.text = club.jlkclub
            yearclub.text = club.yearclub
            homeclub.text = club.homeclub
            supclub.text = club.supclub
            itemView.setOnClickListener{ (listener(club))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_club, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindView(club[position], listener)
    }

    override fun getItemCount(): Int = club.size
}
