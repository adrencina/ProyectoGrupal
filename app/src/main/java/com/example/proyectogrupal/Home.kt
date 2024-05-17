package com.example.proyectogrupal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectogrupal.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

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

        initRecyclerView()
        initNavigation()
    }




    private fun initRecyclerView() {

        val adapter = HomeAdapter(getLista())
        binding.listaHome.adapter = adapter


    }


    // esto es para probar el recycler... //

    fun getLista(): List<HomeData> {
        return listOf<HomeData>(
            HomeData(url = "https://s3-alpha-sig.figma.com/img/59e4/1642/a689a0d00901ba42477ab362c4e49d0b?Expires=1716768000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=iB3Ahm9vNq8pO65E3MMFLx-czRRuoXv6Wl5FWnn-z75wIY~Zb9O2fyRJa-UeJFAD9df~Zm0zLTSL~gl~Nqku9n8Qy0tuIS4IoRlaLF8puAY6p8fw4jjdR9sjxdfN7DOv14IYioJhedWuDJOsRpliFaovPtqIGNVPI6c18qM86g8m6pVn19AHrLR2p1~FjfNbstJPP12IufTdw~FTHKVhWbQFfUHJEAViJ340RrEe8JVj5BiS78vbTK5krkIFxJ7zLmY1s8y4I0L-2SOCtNHioy2Ysbh81jznSw1DjpLOmxgN1hTeb7a2WzGqQ8nO516gZPXnoiK3bmo5f~qxthZqVw__"),
            HomeData(url = "https://s3-alpha-sig.figma.com/img/e127/bfbd/787c0fea89d31aae014da75a508c6b25?Expires=1716768000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=SvcydwKzPQYiNWwFnStPL-N36MCDZszUZL7arQ~Los5X6JxtRX~5oYPUNMrwlGT0LXSoV1Zus6zl5sefzH2AnI7a1XLrpLmrUukIK7WRlPiEcqBehy4mWmgqw-6K~2D4Eef-QWMY0dZPW~LNqI~twMAis4GG4skb8Saw9kzg3pCsbeY8Bsw8Ggr40K28VP3YehuFQPFXMau1Y-8GL~0zcROrzA~t-1bakualrud~-coQal2j9E-dZCLIocMwHNPr0qrtqirPE3ksv1NvwagrXiTCJfESmHEVbwSo0rilgUi1iLKG5XHxO0ojzjgYH3cv7UtR5FFNSoV48IkeCSULgA__"),
            HomeData(url = "https://s3-alpha-sig.figma.com/img/8e73/c420/39cace682da3a536cd44cc26b6a01792?Expires=1716768000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=JRXdeq0p3FHef6GslrtYGNdkCFipVxxBz~aSBW8pSlSn8Urx3leB42KYTRPUZN0AoLEE-tObM6ZisPfzwmgRpwikryGNGhIbt8-jBge1pmtuuPzCMlPgGziD7x1gJx3UwgvYuhd64QerG5zJBuz15fOSUY7XGpzEOr5R1t1l-4urkp3yCYHJl7G0w6V8xdNdd4uYq9PZZ~AK9bjtfilmY~KwLyQjP4hMhoUDJpYz1RO4~1cNUxXOwAf9Kb~ntByy1QaushzGdmN~rAxR3A5KrsoisCbompo7Is-GCLMKbuPZ9AOtDasvkXyRVjfoEiiERgcld3ntejmotjCU82Axrg__")
        )
    }


    //navegacion a otras interfaces
    private fun initNavigation() {
        binding.boton2.setOnClickListener {
            val intentPerritos = Intent(this, Perritos::class.java)
            startActivity(intentPerritos)
        }
    }
}