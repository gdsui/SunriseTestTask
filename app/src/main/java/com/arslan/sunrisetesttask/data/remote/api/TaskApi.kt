package com.arslan.sunrisetesttask.data.remote.api

import com.arslan.sunrisetesttask.data.model.TaskModel
import com.arslan.sunrisetesttask.utils.Constants.Companion.END_POINT
import com.arslan.sunrisetesttask.utils.Constants.Companion.END_POINT_NEW
import retrofit2.Response
import retrofit2.http.GET

interface TaskApi {
    @GET(END_POINT)
    suspend fun getDataFromApi(): Response<List<TaskModel>>

    @GET(END_POINT_NEW)
    suspend fun getNewDataFromApi():Response<List<TaskModel>>
}