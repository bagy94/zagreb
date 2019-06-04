package hr.factory.base_module.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import hr.factory.base_module.R
import kotlinx.android.synthetic.main.progress_bar.view.*

class CustomProgressBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.progress_bar,this)
    }

    fun setVisible(isVisible:Boolean){
        if(isVisible){
            visibility = View.VISIBLE
            bringToFront()
        }else{
            visibility = View.GONE
        }
    }

    fun setLoadingText(text:String){
        progressText.text = text
    }
}