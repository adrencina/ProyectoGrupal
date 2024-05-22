package com.example.proyectogrupal.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectogrupal.Details
import com.example.proyectogrupal.R
import com.example.proyectogrupal.databinding.CardImgBinding
import com.squareup.picasso.Picasso

class HomeAdapter(private val list: List<String>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_img,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.render(list[position])
    }
}

class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {


    private val binding = CardImgBinding.bind(view)
    private var url =""

    init {
        itemView.setOnClickListener(this)
    }
    fun render(image: String){
        Picasso.get().load(image).into(binding.imgHome)
        url = image
    }

    override fun onClick(v: View?) {
        val context = itemView.context
        val intent = Intent(context, Details::class.java)
        intent.putExtra("IMAGE_URL", url)
        context.startActivity(intent)
    }


}