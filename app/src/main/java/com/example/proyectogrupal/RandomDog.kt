package com.example.proyectogrupal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.databinding.ActivityRandomDogBinding

class RandomDog : AppCompatActivity() {

    private lateinit var binding: ActivityRandomDogBinding

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

        binding.botonDer.setOnClickListener(clickListener)
        binding.botonIzq.setOnClickListener(clickListener)
        binding.textoBoton.setOnClickListener(clickListener)
        binding.iconoBoton.setOnClickListener(clickListener)

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