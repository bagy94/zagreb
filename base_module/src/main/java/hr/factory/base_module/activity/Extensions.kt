package hr.factory.base_module.activity

import android.app.Activity
import android.content.Intent

fun Activity.reset(){
    val clasz = this::class.java
    val intent = Intent(this,clasz)
    startActivity(intent)
    finish()
}