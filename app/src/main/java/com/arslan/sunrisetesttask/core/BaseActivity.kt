package com.arslan.sunrisetesttask.core

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.arslan.sunrisetesttask.utils.showToast

abstract class BaseActivity(val layout:Int):AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(layout)
    }

}