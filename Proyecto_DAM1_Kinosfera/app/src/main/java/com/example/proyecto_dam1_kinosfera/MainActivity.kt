package com.example.proyecto_dam1_kinosfera
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_dam1_kinosfera.databinding.ActivityMainBinding
import com.example.proyecto_dam1_kinosfera.databinding.ActivityPlaymovieBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var adapterPremier: AdapterMovie
    private lateinit var adapterHorror:AdapterMovie
    private lateinit var adapterAccion:AdapterMovie
    private lateinit var adapterComedia:AdapterMovie
    private lateinit var adapterSeries:AdapterMovie
    private lateinit var adapterProximo:AdapterMovie

    private var listPremierMovie = mutableListOf<Movie>()
    private var listHorrorMovie = mutableListOf<Movie>()
    private var listAccionMovie = mutableListOf<Movie>()
    private var listComediaMovie = mutableListOf<Movie>()
    private var listSeriesMovie = mutableListOf<Movie>()
    private var listProximoMovie = mutableListOf<Movie>()

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //*funciona no tocar
        val registrar: ImageView = findViewById(R.id.iv_user)
        registrar.setOnClickListener{
            val intent: Intent = Intent(this, Lista_direc::class.java)
            startActivity(intent)
        }

        GlobalScope.launch(Dispatchers.IO){
            val service: Endpoints = Connection.ResposeEngine().create(Endpoints::class.java)
            val res: Response<MovieRes> = service.getDataMovies()
            runOnUiThread{
                if(res.isSuccessful){
                    for (pelicula in res.body()!!.estreno){
                        listPremierMovie.add(pelicula)
                        adapterPremier = AdapterMovie(listPremierMovie, this@MainActivity)
                        mBinding.rvPremiere.apply {
                            adapter = adapterPremier
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                    for (pelicula in res.body()!!.terror){
                        listHorrorMovie.add(pelicula)
                        adapterHorror = AdapterMovie(listHorrorMovie, this@MainActivity)
                        mBinding.rvHorror   .apply {
                            adapter = adapterHorror
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                    for (pelicula in res.body()!!.accion){
                        listAccionMovie.add(pelicula)
                        adapterAccion = AdapterMovie(listAccionMovie, this@MainActivity)
                        mBinding.rvAccion   .apply {
                            adapter = adapterAccion
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                    for (pelicula in res.body()!!.comedia){
                        listComediaMovie.add(pelicula)
                        adapterComedia = AdapterMovie(listComediaMovie, this@MainActivity)
                        mBinding.rvComedia   .apply {
                            adapter = adapterComedia
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                    for (pelicula in res.body()!!.series){
                        listSeriesMovie.add(pelicula)
                        adapterSeries = AdapterMovie(listSeriesMovie, this@MainActivity)
                        mBinding.rvSeries   .apply {
                            adapter = adapterSeries
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                    for (pelicula in res.body()!!.proximo){
                        listProximoMovie.add(pelicula)
                        adapterProximo = AdapterMovie(listProximoMovie, this@MainActivity)
                        mBinding.rvProximo   .apply {
                            adapter = adapterProximo
                            layoutManager= LinearLayoutManager(
                                this@MainActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )

                        }
                    }

                }
            }
        }
    }

    override fun onClick(movie: Movie) {
        super.onClick(movie)
        //val intent = Intent(baseContext, PlayMovieActivity::class.java)
        //intent.putExtra("url",movie.url)
        //startActivity(intent)
        Toast.makeText(baseContext, movie.title, Toast.LENGTH_SHORT ).show()
    }



}