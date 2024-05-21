package com.example.proyectogrupal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.databinding.ActivityNosotrosBinding

class Nosotros : AppCompatActivity() {
    private lateinit var binding: ActivityNosotrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNosotrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.nosotros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nosotros)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}