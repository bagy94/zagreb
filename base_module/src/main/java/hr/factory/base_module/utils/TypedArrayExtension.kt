package hr.factory.base_module.utils

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet

fun TypedArray.use(codeBlock:TypedArray.()->Unit){
    try{
        codeBlock()
    }finally {
        recycle()
    }
}
fun Context.getCustomAttributes(attributeSet: AttributeSet?, styleArray: IntArray, block: TypedArray.() -> Unit) =
        this.obtainStyledAttributes(attributeSet, styleArray, 0, 0).use(block)
