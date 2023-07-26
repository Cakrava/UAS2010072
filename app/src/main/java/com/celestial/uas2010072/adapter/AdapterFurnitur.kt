package com.celestial.uas2010072.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.celestial.uas2010072.R
import com.celestial.uas2010072.model.FurniturModel
import kotlin.collections.ArrayList

class AdapterFurnitur(var activity: Activity, var data: ArrayList<FurniturModel>): RecyclerView.Adapter<AdapterFurnitur.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kdfurnitur = view.findViewById<TextView>(R.id.kdfurnitur)
        val model = view.findViewById<TextView>(R.id.model)
        val jumlah = view.findViewById<TextView>(R.id.jumlah)
        val harga = view.findViewById<TextView>(R.id.harga)
        val foto = view.findViewById<ImageView>(R.id.foto)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.furnitur, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.kdfurnitur.text = a.kdfurnitur
        holder.model.text = a.model
        holder.jumlah.text = a.jumlah
        holder.harga.text = a.harga.toString()


        // Menampilkan gambar menggunakan Glide
        Glide.with(context)
            .load("http://10.234.201.90/laravel_1/storage/app/public/${a.foto}")
            .into(holder.foto)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
