package com.example.proyectogrupal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.proyectogrupal.data.dto.response.RandomDogResponse
import com.example.proyectogrupal.databinding.ActivityRandomDogBinding
import com.example.proyectogrupal.ui.home.adapter.HomeAdapter
import com.example.proyectogrupal.ui.home.viewmodel.HomeViewmodel
import com.example.proyectogrupal.ui.home.viewmodel.RandomDogViewModel
import com.example.proyectogrupal.ui.home.viewmodel.State
import com.example.proyectogrupal.ui.home.viewmodel.StateBuscar
import com.example.proyectogrupal.ui.home.viewmodel.StateRandomDog
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomDog : AppCompatActivity() {

    private lateinit var binding: ActivityRandomDogBinding

    private val viewmodel by viewModels<RandomDogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRandomDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.random_dog)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        call()
        observer()

        binding.botonDer.setOnClickListener(clickListener)
        binding.botonIzq.setOnClickListener(clickListener)
        binding.textoBoton.setOnClickListener(clickListener)
        binding.iconoBoton.setOnClickListener(clickListener)
    }


    private fun call() {
        viewmodel.getRandomDog()
    }

    private fun observer() {
        viewmodel.data.observe(this) {
            when (it) {
                is StateRandomDog.Success -> {
                    initRecyclerView(it.data.imgDog ?: listOf())
                }

                is StateRandomDog.Loading -> {

                }

                is StateRandomDog.Error -> {

                }
            }
        }
    }

    private fun initRecyclerView(list: List<String>) {

        val adapter = HomeAdapter(list)
        binding.rvRandomDog.adapter = adapter


    }





    private fun navigateToDetails(imageUrl: String) {
        val intent = Intent(this, Details::class.java)
        intent.putExtra("IMAGE_URL", imageUrl)
        startActivity(intent)
    }


    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.boton_der, R.id.boton_izq, R.id.texto_boton, R.id.icono_boton -> {
                navVolver()
            }
        }
    }

    private fun navVolver(){
        val intent = Intent(this, Home::class.java) //Para volver a Home.xml
        startActivity(intent)
        finish()
    }

}

