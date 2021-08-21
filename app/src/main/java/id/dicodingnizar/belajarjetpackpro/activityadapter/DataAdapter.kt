package id.dicodingnizar.belajarjetpackpro.activityadapter

import android.view.LayoutInflater
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.dicodingnizar.belajarjetpackpro.R
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.utils.DatumCallback
import java.util.*

class DataAdapter(private val context:Context,private val callback: DatumCallback) :
    RecyclerView.Adapter<DataViewHolder>() {
    private val listData = ArrayList<DatumModel>()

    fun setData(data: List<DatumModel>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        )

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindTo(listData[position],context)
        holder.itemView.setOnClickListener {
            callback.onItemClicked(listData[position])
        }
    }

}
