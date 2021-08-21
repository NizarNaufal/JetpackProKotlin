package id.dicodingnizar.belajarjetpackpro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DatumModel(
    var id: String,
    var name: String,
    var desc: String,
    var poster: String,
    var img_preview: String
) : Parcelable