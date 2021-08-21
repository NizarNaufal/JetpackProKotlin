package id.dicodingnizar.belajarjetpackpro.utils

import id.dicodingnizar.belajarjetpackpro.model.DatumModel

interface DatumCallback  {
    fun onItemClicked(data: DatumModel)
}