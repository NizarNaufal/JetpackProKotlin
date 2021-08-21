package id.dicodingnizar.belajarjetpackpro.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import id.dicodingnizar.belajarjetpackpro.R
import id.dicodingnizar.belajarjetpackpro.commonbase.BaseFragment
import id.dicodingnizar.belajarjetpackpro.databinding.ActivityDetailBinding
import id.dicodingnizar.belajarjetpackpro.model.DatumModel
import id.dicodingnizar.belajarjetpackpro.utils.loadImageWithCache


class DetailFragment : BaseFragment<ActivityDetailBinding>(ActivityDetailBinding::inflate) {

    private lateinit var result: DatumModel
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        setupToolbar()


        if (args.extraData.equals(args.extraData, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))
            id.toString().let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()

        } else if (args.extraType.equals(args.extraType, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))
            id.toString().let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        with(binding) {
            incSubDetail.tvDetailName.text = result.name
            incSubDetail.tvDetailDesc.text = result.desc
            incSubDetail.imgDetailPoster.loadImageWithCache(result.poster)
            imgDetailHightlight.loadImageWithCache(result.img_preview)
        }
    }


    private fun setupToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
        (activity as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)
    }

    private fun setupToolbarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }
}