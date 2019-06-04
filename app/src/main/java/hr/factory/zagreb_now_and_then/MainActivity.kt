package hr.factory.zagreb_now_and_then

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import hr.factory.base_module.utils.setLocale
import hr.factory.base_module.view.MainController
import org.koin.core.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent, MainController{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLocale(this)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(setLocale(newBase))
    }

    override fun setStatusBarColor(@ColorRes colorRes: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,colorRes)
    }

    override fun setStatusBarVisibility(visible: Boolean) {
        if(visible)
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        else
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}
