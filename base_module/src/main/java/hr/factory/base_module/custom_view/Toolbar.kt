package hr.factory.base_module.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import hr.factory.base_module.R
import hr.factory.base_module.utils.getCustomAttributes
import kotlinx.android.synthetic.main.toolbar.view.*

class Toolbar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr){

    init {
        View.inflate(context, R.layout.toolbar,this)
        attrs?.let {
            context.getCustomAttributes(it,R.styleable.Toolbar){
                val shareState = getBoolean(R.styleable.Toolbar_share_visible,false)
                toolbarMenu.visibility = if(shareState) View.VISIBLE else View.INVISIBLE
            }
        }
    }

    fun bindDrawer(drawer:DrawerLayout){
        burgerMenu.setOnClickListener {
            if(drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START)
            }else{
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }
    fun setToolbarLogo(@DrawableRes drawableId : Int){
        toolbarLogo.setImageResource(drawableId)
    }
    fun setNavIcon(@DrawableRes iconId:Int){
        burgerMenu.setImageResource(iconId)
    }
    fun setOnNavIconListener(listener:OnClickListener){
        burgerMenu.setOnClickListener(listener)
    }
    fun setOnShareClickListener(listener:OnClickListener){
        toolbarMenu.setOnClickListener(listener)
    }
}