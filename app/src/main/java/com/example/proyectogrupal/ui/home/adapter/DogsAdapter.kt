package com.example.proyectogrupal.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.Details
import com.example.proyectogrupal.DogsData
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

    class DogsHolder(private val binding: ItemGridDogsBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        private lateinit var data: DogsData

        init {
            itemView.setOnClickListener(this)
        }
        fun render(data: DogsData) {
            this.data = data
            Picasso.get().load(data.url).into(binding.ivDog)
        }


        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, Details::class.java)
            intent.putExtra("IMAGE_URL", data.url) // assuming `id` is a property of `DogsData`
            context.startActivity(intent)
        }

    }
}
