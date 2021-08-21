package id.dicodingnizar.belajarjetpackpro.ui.movie

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
import id.dicodingnizar.belajarjetpackpro.databinding.FragmentMovieBinding
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.ui.HomeViewModel
import id.dicodingnizar.belajarjetpackpro.utils.Constant
import id.dicodingnizar.belajarjetpackpro.utils.DatumCallback
import id.dicodingnizar.belajarjetpackpro.utils.navigateSafe

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate),
    DatumCallback {

    private lateinit var viewModel: HomeViewModel
    private lateinit var movieAdapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listMovie = viewModel.getListMovie()
        setupRecyclerView(listMovie)
    }

    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvMovie.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
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
        bundle.putString("extraType",Constant.TYPE_MOVIE)
        findNavController().navigateSafe(R.id.action_to_detail_movie,bundle)
    }

}
