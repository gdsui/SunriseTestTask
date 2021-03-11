package com.arslan.sunrisetesttask.view.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arslan.sunrisetesttask.adapter.TaskAdapter
import com.arslan.sunrisetesttask.databinding.ActivityMainBinding
import com.arslan.sunrisetesttask.repository.TaskRepository

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { TaskAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupRecycler()
        initFields()
        getData()
        setupListener()

    }

    private fun getNewData() {
        viewModel.getNewDataFromApi()
        viewModel.myNewResponse.observe(this, Observer {
            if (it.isSuccessful){
                it.body().let {
                    if (it!=null){
                        adapter.update(it)
                    }
                }
            }
        })
    }

    private fun setupRecycler() {
        mainBinding.recyclerTask.adapter=adapter
        mainBinding.recyclerTask.layoutManager=LinearLayoutManager(this)

    }

    private fun setupListener() {
        mainBinding.btnObno.setOnClickListener {
            getNewData()
        }
    }

    private fun getData() {
        viewModel.getDataFromApi()
        viewModel.myResponse.observe(this, Observer {response->
            if (response.isSuccessful) {
                response.body().let {
                    if (it != null) {
                        adapter.update(it)
                    }
                }
              // mainBinding.tvResponse.text= response.body()?.get(0).toString()
            } else {
                Log.e("TAG", "onCreate: ${response.errorBody()}")
                //mainBinding.tvResponse.text=response.errorBody().toString()
            }
        })

    }

    private fun initFields() {
        val repository = TaskRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }

}