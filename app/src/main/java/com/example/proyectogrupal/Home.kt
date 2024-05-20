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
import com.example.proyectogrupal.ui.home.viewmodel.State

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewmodel by viewModels<HomeViewmodel>()

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
        observer()

        binding.btnAleatorio.setOnClickListener{
            navRandomdog()
        }

        binding.btnPerritos.setOnClickListener{
            navPerritos()
        }

        binding.btnNosotros.setOnClickListener{
            navNosotros()
        }


//
//        binding.imgHome.setOnClickListener{
//            navDetails()
//        }

//
//        binding.boton4.setOnClickListener{
//            navRandomdog()
//        }

    }

    private fun navRandomdog(){
        val intent = Intent(this, RandomDog::class.java) //Para ir a random_dog.xml
        startActivity(intent)
        finish()
    }

    private fun navPerritos(){
        val intent = Intent(this, Perritos::class.java) //Para ir a perritos.xml
        startActivity(intent)
        finish()
    }

//
//    private fun navBuscar(){
//        val intent = Intent(this, Buscar::class.java) //Para ir a Buscar.xml
//        startActivity(intent)
//        finish()
//    }

    private fun navNosotros(){
        val intent = Intent(this, Nosotros::class.java) //Para ir a Nosotros.xml
        startActivity(intent)
        finish()
    }

    private fun navDetails(){
        val intent = Intent(this, Details::class.java) //Para ir a Details.xml
        startActivity(intent)
        finish()
    }



    private fun call() {
        viewmodel.getDogs()
    }






    private fun observer() {
        viewmodel.data.observe(this) {
            when (it) {
                is State.Success -> {
                    initRecyclerView(it.info.message ?: listOf())
                }

                is State.Loading -> {

                }

                is State.Error -> {

                }
            }
        }
    }


    private fun initRecyclerView(list: List<String>) {

        val adapter = HomeAdapter(list)
        binding.listaHome.adapter = adapter


    }
}

//
//
//    //navegacion a otras interfaces
//    private fun initNavigation() {
//        binding.boton2.setOnClickListener {
//            val intentPerritos = Intent(this, Perritos::class.java)
//            startActivity(intentPerritos)
//        }
//    }
//}