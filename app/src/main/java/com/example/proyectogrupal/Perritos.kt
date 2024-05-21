package com.example.proyectogrupal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectogrupal.databinding.ActivityPerritosBinding
import com.example.proyectogrupal.ui.home.adapter.DogsAdapter

class Perritos : AppCompatActivity() {

    private lateinit var binding: ActivityPerritosBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPerritosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rv_perritos)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.botonDer.setOnClickListener(clickListener)
        binding.botonIzq.setOnClickListener(clickListener)
        binding.textoBoton.setOnClickListener(clickListener)
        binding.iconoBoton.setOnClickListener(clickListener)

        initUIA()
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


    private fun initUIA() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.rvPerritos.layoutManager = GridLayoutManager(this, 3)
        val adapter = DogsAdapter(getList())
        binding.rvPerritos.adapter = adapter
    }

    private fun getList(): List<DogsData> {
        return listOf(
            DogsData(url="https://th.bing.com/th/id/R.df756a251a62d8fb09b9cf66711c1c09?rik=SKtoKItSIRDsqQ&riu=http%3a%2f%2fcms.softindustries.com%2fmultimedia%2f12%2f200808%2fBichon-maltes_1_2.jpg&ehk=Gd8ncrL%2ffQ5KRPk3D5iiXPywZz1Ih8YwBHfkzAM8z8E%3d&risl=&pid=ImgRaw&r=0", id = "hola"),

        )
    }


}