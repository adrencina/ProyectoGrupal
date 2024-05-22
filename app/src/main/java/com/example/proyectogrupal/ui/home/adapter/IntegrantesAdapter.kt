package com.example.proyectogrupal.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.R
import com.example.proyectogrupal.data.dto.response.DataIntegrantes
import com.example.proyectogrupal.databinding.ItemIntegrantesBinding
import com.squareup.picasso.Picasso

class IntegrantesAdapter(val list: List<DataIntegrantes>): RecyclerView.Adapter<IntegrantesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntegrantesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_integrantes, parent, false)
        return IntegrantesHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: IntegrantesHolder, position: Int) {
        holder.render(list[position])
    }
}

class IntegrantesHolder(val view: View): RecyclerView.ViewHolder(view){

    val binding = ItemIntegrantesBinding.bind(view)
    fun render(data : DataIntegrantes, ){
        Picasso.get().load(data.url).into(binding.image)

    }

}