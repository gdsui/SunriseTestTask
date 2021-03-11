package com.arslan.sunrisetesttask.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arslan.sunrisetesttask.data.model.TaskModel
import com.arslan.sunrisetesttask.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: TaskRepository) : ViewModel() {
     val myResponse: MutableLiveData<Response<List<TaskModel>>> = MutableLiveData()
     val myNewResponse: MutableLiveData<Response<List<TaskModel>>> = MutableLiveData()

    fun getDataFromApi() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.getDataFromApi()
            myResponse.value = response
        }
    }

    fun getNewDataFromApi() {
        viewModelScope.launch(Dispatchers.Main) {
            val newResponse = repository.getNewDataFromApi()
            myNewResponse.value = newResponse
        }

    }
}