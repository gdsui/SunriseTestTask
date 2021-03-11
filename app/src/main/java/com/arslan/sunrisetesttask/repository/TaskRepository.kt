package com.arslan.sunrisetesttask.repository

import com.arslan.sunrisetesttask.data.remote.api.RetrofitInstance
import com.arslan.sunrisetesttask.data.model.TaskModel
import retrofit2.Response

class TaskRepository() {
    suspend fun getDataFromApi(): Response<List<TaskModel>> {
        return RetrofitInstance.api.getDataFromApi()
    }
    suspend fun getNewDataFromApi(): Response<List<TaskModel>> {
        return RetrofitInstance.api.getNewDataFromApi()
    }
}