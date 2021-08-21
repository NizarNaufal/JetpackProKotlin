package id.dicodingnizar.belajarjetpackpro.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import id.dicodingnizar.belajarjetpackpro.R
import id.dicodingnizar.belajarjetpackpro.commonbase.BaseActivity
import id.dicodingnizar.belajarjetpackpro.databinding.ActivityMainBinding
import id.dicodingnizar.belajarjetpackpro.ui.movie.MovieFragment
import id.dicodingnizar.belajarjetpackpro.ui.movieTV.TvShowFragment

class HomeActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this@HomeActivity,
            ViewModelProvider.NewInstanceFactory()
        )[HomeViewModel::class.java]
        setupToolbar()
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_movie, R.id.navigation_tv_show).build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.elevation = 8F
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}