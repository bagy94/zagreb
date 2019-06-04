package hr.factory.base_module.custom_view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import hr.factory.base_module.R
import kotlinx.android.synthetic.main.expendable_text_view.view.*

class ExpandableTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr), View.OnClickListener{

    var expandLabel:String? = null
        set(value) {
            field = value
            value?.let { applyExpandLabel() }
        }
    var expandLabelColor: Int? = null
        set(value) {
            field = value
            value?.let { applyExpandLabelColor() }
        }

    var collapsingLabel:String? = null

    var maxCollapsedLines:Int? = null
        set(value) {
            field = value
            value?.let { applyCollapsedMaxLines() }
        }

    var isCollapsed:Boolean = true

    var contentTextStyle:Int? = null
        set(value) {
            field = value
            value?.let { applyContentStyle() }
        }

    init {
        View.inflate(context,R.layout.expendable_text_view,this)
        setExpandableViewClickListener(this)
        context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView).apply {
            expandLabel = getString(R.styleable.ExpandableTextView_expendLabel)
            expandLabelColor = getColor(R.styleable.ExpandableTextView_expendableLabelColor, Color.GRAY)
            maxCollapsedLines = getInteger(R.styleable.ExpandableTextView_maxCollapsedLines, Int.MAX_VALUE)
            contentTextStyle = getInt(R.styleable.ExpandableTextView_contentStyle,android.R.style.TextAppearance_Material_Body1)
            collapsingLabel = getString(R.styleable.ExpandableTextView_collapsingLabel)
            recycle()
        }
    }
    fun setExpandableViewClickListener(onClickListener: OnClickListener){
        seeMoreClickable.setOnClickListener(onClickListener)
    }
    fun setCollapsingText(text:String){
        content.text = text
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.seeMoreClickable){
            if(isCollapsed){
                isCollapsed = false
                content.maxLines = Int.MAX_VALUE
                collapsingLabel?.let { seeMoreClickable.text = collapsingLabel }
            }else{
                isCollapsed = true
                content.maxLines = maxCollapsedLines ?: 0
                seeMoreClickable.text = expandLabel
            }
            content.invalidate()
        }
    }

    private fun applyExpandLabel(){
        seeMoreClickable.text = expandLabel
    }
    private fun applyExpandLabelColor(){

    }
    private fun applyContentStyle(){

    }
    private fun applyCollapsedMaxLines(){
        content.maxLines = maxCollapsedLines!!
    }


}