package com.example.proyectogrupal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.databinding.ActivityBuscarBinding
import com.example.proyectogrupal.ui.home.viewmodel.BuscarViewModel
import com.example.proyectogrupal.ui.home.viewmodel.StateBuscar
import com.squareup.picasso.Picasso

class Buscar : AppCompatActivity() {

    private lateinit var binding: ActivityBuscarBinding

    val viewmodel by viewModels<BuscarViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBuscarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        initUIA()
    }


    private fun initUIA() {
        configurarSearchView()
        observer()
    }


    fun call(breed: String){
        viewmodel.getDogsByBreeds(breed)
    }

    fun observer(){
        viewmodel.data.observe(this){
            when(it){
                is StateBuscar.Success -> {
                    hideLoading()
                    hideUps()
                    val urlList = it.info.message ?: listOf()
                    if (urlList.isNotEmpty()){

                        val randomImageUrl = urlList.random()
                        Picasso.get().load(randomImageUrl).into(binding.ivDog)

                        binding.ivDog.setOnClickListener { navigateToDetails(randomImageUrl) }
                    }
                }
                is StateBuscar.Error -> {
                    showUps()
                    hideLoading()
                    Picasso.get().load("https://s3-alpha-sig.figma.com/img/815a/6457/0f5e4eccfa4dde85209ea273cf8f1e3a?Expires=1716768000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=HhUSFRUo65n9vrtmL640bbpxNf5FVsfNb9Mm8OWomB4MPZ8LisKmXaCJzBYBh7t~M9fLryggyOKsJ7Vuh62BWDBf7XIuLFVpP-r1e9V4COwvD53UxdG59mrDJR0VTXF43wp0uB2B-ywXVN0v2WXUTVDuhynpfpm9eMTt5FaQ6iVJLc3Jq2x3imwPq1GXfqd6cXwLHhZ-HL7jidZ02k0Jwzd26xkcuPHJ8EgbzWqu2zmIyoEo5VBo~sDjhirtG83mnOVd-1100-~Ypwmw9oOQQ6RIB3EPC8fkCYp5OLGlEdRWgSV3i5rKKAdrVqHdVMTjxFhyzNWZxgbux8mVX9E-hQ__").into(binding.ivDog)
                    binding.ivDog.setOnClickListener {  }
                }
                is StateBuscar.Loading -> {
                    showLoading()
                }
            }
        }
    }


    fun showLoading(){
        binding.loading.visibility = View.VISIBLE
    }
    fun hideLoading(){
        binding.loading.visibility = View.GONE
    }
    fun showUps(){
        binding.tvUps.visibility = View.VISIBLE
    }
    fun hideUps(){
        binding.tvUps.visibility = View.GONE
    }


    private fun configurarSearchView() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    handleSearch(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Manejar los cambios en el texto de búsqueda
                return true
            }
        })
    }


    private fun handleSearch(query: String?) {
        if (!query.isNullOrEmpty()) {
            val queryLowerCase = query.lowercase()
            call(queryLowerCase)
            // Cerrar el teclado después de la búsqueda
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.svSearch.windowToken, 0)
        } else {
            Toast.makeText(this, "Por favor, ingrese un texto de búsqueda", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDetails(imageUrl: String) {
        val intent = Intent(this, Details::class.java)
        intent.putExtra("IMAGE_URL", imageUrl)
        startActivity(intent)
    }
}