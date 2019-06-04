package hr.factory.base_module.utils

import android.content.res.Resources

fun Int.asDp():Int = (this * Resources.getSystem().displayMetrics.density).toInt()