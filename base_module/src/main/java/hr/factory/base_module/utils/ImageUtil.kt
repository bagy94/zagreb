package hr.factory.base_module.utils

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.setImageFromUrlWithGlide(
    imageUrl: String,
    vararg transformations: Transformation<Bitmap> = arrayOf()
) {
    if (transformations.isNotEmpty()) {
        Glide.with(this)
            .load(imageUrl)
            .transform(*transformations)
            .into(this)
    } else {
        Glide.with(this)
            .load(imageUrl)
            .into(this)
    }
}

fun ImageView.setCornerRadius(radius: Int) {
    val drawable = drawable
    Glide.with(this)
        .load(drawable)
        .transform(RoundedCorners(radius))
        .into(this)
}