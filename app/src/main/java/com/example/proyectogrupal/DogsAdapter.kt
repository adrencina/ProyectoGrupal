package com.example.proyectogrupal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.databinding.ItemGridDogsBinding
import com.squareup.picasso.Picasso

class DogsAdapter(private val list: List<DogsData>) : RecyclerView.Adapter<DogsAdapter.DogsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsHolder {
        val binding = ItemGridDogsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogsHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DogsHolder, position: Int) {
        holder.render(list[position])
    }

    class DogsHolder(private val binding: ItemGridDogsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun render(data: DogsData) {
            Picasso.get().load(data.url).into(binding.ivDog)
        }
    }
}
