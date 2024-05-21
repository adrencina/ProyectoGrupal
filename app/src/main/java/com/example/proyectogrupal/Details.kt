package com.example.proyectogrupal

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.ImageViewCompat
import androidx.lifecycle.Observer
import com.example.proyectogrupal.databinding.ActivityDetailsBinding
import com.example.proyectogrupal.ui.home.viewmodel.DetailsViewModel
import com.ncorti.slidetoact.SlideToActView
import com.squareup.picasso.Picasso

class Details : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    private val viewmodel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val imageUrl = intent.getStringExtra("IMAGE_URL")
        if (imageUrl != null && imageUrl.isNotEmpty()) {
            Picasso.get().load(imageUrl).into(binding.ivDogBackground)
        } else {
            // Maneja el caso donde la URL de la imagen es nula o vacía
            // Puedes mostrar una imagen por defecto o un mensaje de error
            binding.ivDogBackground.setImageResource(R.drawable.dog_api)
        }


        initUIA()

        initListeners()



    }

    private fun initListeners() {
        binding.sBoton.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                val intent = Intent(this@Details, Home::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.tvAdopt.setOnClickListener {
            val intent = Intent(this, Thanks::class.java)
            startActivity(intent)
        }
        binding.ivDog.setOnClickListener {
            val intent = Intent(this, Thanks::class.java)
            startActivity(intent)
        }
    }

    private fun initUIA() {
        val selectedColor = ContextCompat.getColor(this, R.color.gris)
        val deselectedColor = ContextCompat.getColor(this, R.color.white)

        viewmodel.text.observe(this, Observer {
            binding.etDetails.text = it
        })

        viewmodel.btnId.observe(this, Observer {
            updateButtonColors(it, selectedColor, deselectedColor)
        })

        binding.ivFeeder.setOnClickListener {
            viewmodel.updateText(getString(R.string.proof_text))
            viewmodel.updateBtn(R.id.ivFeeder)
        }

        binding.ivStethoscope.setOnClickListener {
            viewmodel.updateText(getString(R.string.health_text))
            viewmodel.updateBtn(R.id.ivStethoscope)
        }

        binding.ivHome.setOnClickListener {
            viewmodel.updateText(getString(R.string.home_text))
            viewmodel.updateBtn(R.id.ivHome)
        }

        binding.ivPaw.setOnClickListener {
            viewmodel.updateText(getString(R.string.hobbies_text))
            viewmodel.updateBtn(R.id.ivPaw)
        }
    }


    private fun updateButtonColors(selectedButtonId: Int, selectedColor: Int, deselectedColor: Int) {
        val buttons = listOf(binding.ivFeeder, binding.ivStethoscope, binding.ivHome, binding.ivPaw)
        buttons.forEach { button ->
            if (button.id == selectedButtonId) {
                button.backgroundTintList = ColorStateList.valueOf(selectedColor)
            } else {
                button.backgroundTintList = ColorStateList.valueOf(deselectedColor)
            }
        }
    }
}