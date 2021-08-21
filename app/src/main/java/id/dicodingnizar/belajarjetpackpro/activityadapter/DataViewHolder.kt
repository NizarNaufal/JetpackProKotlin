package id.dicodingnizar.belajarjetpackpro.activityadapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.dicodingnizar.belajarjetpackpro.databinding.ItemRowDataBinding
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.utils.loadImageWithCache

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemRowDataBinding.bind(itemView)


    @SuppressLint("SetTextI18n")
    fun bindTo(data: DatumModel, context: Context) {
        with(binding) {
            itemView.apply {
                imgData.loadImageWithCache(data.poster)
                tvDataTitle.text = data.name
                tvDataDesc.text = data.desc
            }
        }
    }
}