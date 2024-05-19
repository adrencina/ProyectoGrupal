package com.example.proyectogrupal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.databinding.ActivityHomeBinding
import com.example.proyectogrupal.ui.home.adapter.HomeAdapter
import com.example.proyectogrupal.ui.home.viewmodel.HomeViewmodel

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    val viewmodel by viewModels<HomeViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        call()
        initNavigation()
    }

    fun call(){
        viewmodel.getDogs()
    }


    fun observer(){
        viewmodel.data.observe(this){data->

        }
    }

    fun initRecyclerView(list: List<String>) {

        val adapter = HomeAdapter(list)
        binding.listaHome.adapter = adapter


    }



    //navegacion a otras interfaces
    private fun initNavigation() {
        binding.boton2.setOnClickListener {
            val intentPerritos = Intent(this, Perritos::class.java)
            startActivity(intentPerritos)
        }
    }
}