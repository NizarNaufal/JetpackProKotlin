package id.dicodingnizar.belajarjetpackpro.utils

import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.dicodingnizar.belajarjetpackpro.R

fun ImageView.loadImageWithCache(url: String) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_thumbnail)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .into(this)
}

fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}

