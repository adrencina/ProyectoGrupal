package com.example.proyectogrupal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.data.dto.response.DataIntegrantes
import com.example.proyectogrupal.databinding.ActivityNosotrosBinding
import com.example.proyectogrupal.ui.home.adapter.IntegrantesAdapter

class Nosotros : AppCompatActivity() {
    private lateinit var binding: ActivityNosotrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNosotrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_nosotros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nosotros)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = IntegrantesAdapter(getLista())
        binding.recyclerIntegrantes.adapter = adapter
    }

    fun getLista(): List<DataIntegrantes>{
        return listOf<DataIntegrantes>(
            DataIntegrantes(url = "https://4.bp.blogspot.com/-SLL0Vvo9cBY/UWxVgeCsClI/AAAAAAAAADM/QQ_FxRnKtCk/s1600/bigstock_Happy_Young_Man_Looking_At_Cam_3690139.jpg"),
            DataIntegrantes(url= "https://img.huffingtonpost.es/files/image_720_480/uploads/2023/06/22/un-perro-de-raza-labrador.jpeg"),
            DataIntegrantes(url= "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal_recorte1.jpg"),


            )
    }
}