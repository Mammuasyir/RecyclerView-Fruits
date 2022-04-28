package com.muasyir.recyclerviewfruit

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class BuahAdapter(
    val namaBuah: Array<String>,
    val gambarBuah: Array<Int>,
    val suaraBuah: Array<Int>
) : Adapter<BuahAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvBuah = view.findViewById<TextView>(R.id.item_tv_buah)
        val imgBuah = view.findViewById<ImageView>(R.id.item_img)
    }

    // 1. call layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_buah, parent, false)
        return MyViewHolder(view)
    }

    //2. mengatur posisi antar data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvBuah.text = namaBuah[position]
        holder.imgBuah.setImageResource(gambarBuah[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "buah ${namaBuah[position]}", Toast.LENGTH_SHORT).show()
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, suaraBuah[position])
            mediaPlayer.start()
        }
    }

    //3. Count Data /Menampoilkan Data sebanyak data yang ad
    override fun getItemCount(): Int {

        return namaBuah.size
    }

}