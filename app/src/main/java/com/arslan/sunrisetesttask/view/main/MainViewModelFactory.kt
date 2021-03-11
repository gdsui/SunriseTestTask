package com.arslan.sunrisetesttask.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arslan.sunrisetesttask.repository.TaskRepository

class MainViewModelFactory(private val repository: TaskRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel(repository)as T
    }

}
