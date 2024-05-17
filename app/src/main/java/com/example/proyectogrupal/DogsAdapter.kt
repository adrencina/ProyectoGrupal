package com.example.proyectogrupal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.databinding.ItemGridDogsBinding
import com.squareup.picasso.Picasso

class DogsAdapter(private val list: List<DogsData>) :RecyclerView.Adapter<DogsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_dogs, parent, false)
        return DogsHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DogsHolder, position: Int) {
        holder.render(list[position])
    }

}


class DogsHolder(val view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemGridDogsBinding.bind(view)
    fun render(data: DogsData){
        Picasso.get().load(data.url).into(binding.ivDog)
    }
}