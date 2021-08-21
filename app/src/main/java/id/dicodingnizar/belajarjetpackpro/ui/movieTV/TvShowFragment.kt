package id.dicodingnizar.belajarjetpackpro.ui.movieTV

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.dicodingnizar.belajarjetpackpro.R
import id.dicodingnizar.belajarjetpackpro.activityadapter.DataAdapter
import id.dicodingnizar.belajarjetpackpro.commonbase.BaseFragment
import id.dicodingnizar.belajarjetpackpro.databinding.FragmentTvShowBinding
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.ui.HomeViewModel
import id.dicodingnizar.belajarjetpackpro.utils.Constant
import id.dicodingnizar.belajarjetpackpro.utils.DatumCallback
import id.dicodingnizar.belajarjetpackpro.utils.navigateSafe

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : BaseFragment<FragmentTvShowBinding>(FragmentTvShowBinding::inflate),
    DatumCallback {

    private lateinit var viewModel: HomeViewModel
    private lateinit var tvShowAdapter: DataAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listTvShow = viewModel.getListTvShow()
        setupRecyclerView(listTvShow)
    }

    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvTvshow.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = tvShowAdapter
            }.also {
                it.adapter.let { adapter ->
                    when (adapter) {
                        is DataAdapter -> {
                            adapter.setData(data)
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DatumModel) {
        val bundle = Bundle()
        bundle.putString("extraData",data.id)
        bundle.putString("extraType", Constant.TYPE_MOVIE)
        findNavController().navigateSafe(R.id.action_to_detail_movie,bundle)
    }

}
