package com.stone.uiassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stone.uiassignment.data.CategoryVO
import com.stone.uiassignment.databinding.ItemDoctorCategoryBinding


class CategoryAdapter() : ListAdapter<CategoryVO, CategoryAdapter.DoctorViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return DoctorViewHolder(
            ItemDoctorCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.title.text = item.name
    }

    inner class DoctorViewHolder(val binding: ItemDoctorCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}
private val DIFF_CALLBACK
    get() = object : DiffUtil.ItemCallback<CategoryVO>() {
        override fun areItemsTheSame(oldItem: CategoryVO, newItem: CategoryVO): Boolean {
            return (oldItem == newItem)

        }

        override fun areContentsTheSame(oldItem: CategoryVO, newItem: CategoryVO): Boolean {
            return (oldItem == newItem)
        }
    }