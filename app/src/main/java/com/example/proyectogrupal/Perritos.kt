package com.example.proyectogrupal

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectogrupal.databinding.ActivityPerritosBinding

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

        initUIA()
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
            DogsData(url="https://th.bing.com/th/id/R.df756a251a62d8fb09b9cf66711c1c09?rik=SKtoKItSIRDsqQ&riu=http%3a%2f%2fcms.softindustries.com%2fmultimedia%2f12%2f200808%2fBichon-maltes_1_2.jpg&ehk=Gd8ncrL%2ffQ5KRPk3D5iiXPywZz1Ih8YwBHfkzAM8z8E%3d&risl=&pid=ImgRaw&r=0"),
            DogsData(url="https://supercurioso.com/wp-content/uploads/2019/06/Razas-de-Perros-Bonitos-del-Mundo.jpg"),
            DogsData(url="https://www.anipedia.net/imagenes/que-comen-los-perros.jpg"),
            DogsData(url="https://th.bing.com/th/id/R.ccc88491566075e736cdfbb19ab8767b?rik=NEsJEj7Qsr2nPg&pid=ImgRaw&r=0"),
            DogsData(url="https://www.hogarmania.com/archivos/201609/boyero-berna-perro-raza-XxXx80.jpg"),
            DogsData(url="https://www.hogarmania.com/archivos/201604/san-bernardo-raza-perro-XxXx80.jpg"),
            DogsData(url="https://th.bing.com/th/id/R.609805ff50890ad93a786f427d8465ad?rik=8EyQlLidtdrI4w&riu=http%3a%2f%2f1.bp.blogspot.com%2f-b3p87ghqlIM%2fUGMBITbD_OI%2fAAAAAAAAoio%2fMBMNCCEjyos%2fs1600%2fPerro-Dachshund_Fondos-de-Pantalla-de-Perros.jpg&ehk=LwvuEO54t8wzH3TVsKMH2PQx3LvLnDbogwQfea2eIp4%3d&risl=&pid=ImgRaw&r=0"),
            DogsData(url="https://th.bing.com/th/id/R.ff79e584cee263d8a500c6a111ef017d?rik=1H0hhpCr7pES7w&riu=http%3a%2f%2fwww.perrosamigos.com%2fUploads%2fperrosamigos.com%2fImagenesGrandes%2fraza-perros-rottweiler.jpg&ehk=h2KrLoT21fl3n2OQ7XnIkM3709FwUsI8QDJ8mUrd8i4%3d&risl=&pid=ImgRaw&r=0"),
            DogsData(url="https://2.bp.blogspot.com/-p6f_0lixi9w/WM5rgo1XXvI/AAAAAAAAANo/hf13cyhwMSMhVRU5JcSE70s3rsK5zH6nQCLcB/s1600/Fondo%2Bde%2Bpantalla%2Bperros%2B1.jpeg"),
            DogsData(url="https://th.bing.com/th/id/R.13d89888ff99d40467f98c858c2e0835?rik=4o6jZxRVfVsoHQ&riu=http%3a%2f%2f3.bp.blogspot.com%2f-T5eHPh01NkQ%2fT9N5O-n8aPI%2fAAAAAAAAe9Q%2f-7c63qGPdfc%2fs1600%2fPerro-Husky-Siberiano_Fondos-de-Pantalla-de-Animales.jpg&ehk=ddVDAfbDCvluZ3vtUshgIClZn0QSfRjyj3hGslNyf7k%3d&risl=&pid=ImgRaw&r=0"),
            DogsData(url="https://th.bing.com/th/id/R.aff7b4587618ecfc8bf9e4d0154aeb51?rik=idXzWm%2bk70UUxA&pid=ImgRaw&r=0"),
            DogsData(url="https://1.bp.blogspot.com/-QehmKgU_5Sw/XO2bxZHtxQI/AAAAAAAAADw/lsyAgXcBBXMPqgcrqKIm1olcY0SKKxSXQCEwYBhgL/s1600/Thor.jpg")

        )
    }


}