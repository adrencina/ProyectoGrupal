package com.example.proyectogrupal.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.Details
import com.example.proyectogrupal.R
import com.example.proyectogrupal.databinding.CardImgBinding
import com.example.proyectogrupal.databinding.CardImgRandomBinding
import com.squareup.picasso.Picasso

class RandomDogAdapter(private val imgList: List<String>) : RecyclerView.Adapter<RandomDogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomDogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_img_random,parent,false)
        return RandomDogViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomDogViewHolder, position: Int) {
        holder.render(imgList[position])
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

}

class RandomDogViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{

    private val binding = CardImgRandomBinding.bind(view)

    init {
        itemView.setOnClickListener(this)
    }
    fun render(image: String){

        Picasso.get().load(image).into(binding.imgRandom)
    }

    override fun onClick(v: View?) {
        val context = itemView.context
        val intent = Intent(context, Details::class.java)
        context.startActivity(intent)
    }

}