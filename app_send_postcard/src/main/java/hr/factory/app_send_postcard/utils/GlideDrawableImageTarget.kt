package hr.factory.app_send_postcard.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.request.target.DrawableImageViewTarget

class GlideDrawableImageTarget(imageView:ImageView): DrawableImageViewTarget(imageView) {

    private var onResourceSet:(ImageView)->Unit = {}

    override fun setResource(resource: Drawable?) {
        super.setResource(resource)
        onResourceSet(view)
    }

    fun setOnResourceSetListener(listener:(imageView: ImageView)->Unit){
        onResourceSet = listener
    }
}