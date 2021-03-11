package com.arslan.sunrisetesttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arslan.sunrisetesttask.databinding.ListTaskBinding
import com.arslan.sunrisetesttask.data.model.TaskModel

class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private lateinit var mBinding: ListTaskBinding
    private var myList = emptyList<TaskModel>()

    inner class TaskViewHolder(mBinding: ListTaskBinding) : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(taskModel: TaskModel) {
            mBinding.tvTaskId.text = taskModel.id.toString()
            mBinding.tvTaskType.text = taskModel.type
            mBinding.tvTaskSetup.text = taskModel.setup
            mBinding.tvTaskPunchline.text = taskModel.punchline

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        mBinding = ListTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(myList.get(position))
    }

    fun update(newList: List<TaskModel>) {
        myList = newList
        notifyDataSetChanged()
    }
}