package hr.factory.base_module.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun hasWriteExternalStoragePermission(context: Context)=
    ContextCompat.checkSelfPermission(context,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
