package id.dicodingnizar.belajarjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.utils.DatumDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DatumModel> = DatumDummy.generateDataMovieDummy() as ArrayList<DatumModel>
    private fun getListTvShow(): ArrayList<DatumModel> = DatumDummy.generateDataTvShowDummy() as ArrayList<DatumModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DatumModel {
        lateinit var result: DatumModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DatumModel {
        lateinit var result: DatumModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }

}