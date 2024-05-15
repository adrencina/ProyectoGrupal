package com.example.proyectogrupal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.databinding.CardImgBinding
import com.squareup.picasso.Picasso

class HomeAdapter(private val homeLista: List<HomeData>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_img,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeLista.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.render(homeLista[position])
    }
}

class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
    val binding = CardImgBinding.bind(view)
    fun render(data: HomeData){
        Picasso.get().load(data.url).into(binding.imgHome)
    }
}