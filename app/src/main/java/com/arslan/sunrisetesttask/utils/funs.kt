package com.arslan.sunrisetesttask.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showToast(msg:String,context: Context){
    Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
}