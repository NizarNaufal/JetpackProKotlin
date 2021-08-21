package id.dicodingnizar.belajarjetpackpro.ui

import androidx.lifecycle.ViewModel
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.utils.DatumDummy

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<DatumModel> = DatumDummy.generateDataMovieDummy()

    fun getListTvShow(): List<DatumModel> = DatumDummy.generateDataTvShowDummy()

}