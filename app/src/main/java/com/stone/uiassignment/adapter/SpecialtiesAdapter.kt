package com.stone.uiassignment.adapter

import com.stone.uiassignment.data.SpecialtiesVO
import com.stone.uiassignment.databinding.ItemSpecialtiesBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stone.uiassignment.R

class SpecialtiesAdapter() : ListAdapter<SpecialtiesVO,SpecialtiesAdapter.SpecialtiesViewHolder >(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesViewHolder {
        return SpecialtiesViewHolder(
            ItemSpecialtiesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: SpecialtiesViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.img.setImageResource(item.resource)
        holder.binding.title.text = item.name
    }

    inner class SpecialtiesViewHolder(val binding: ItemSpecialtiesBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}
private val DIFF_CALLBACK
    get() = object : DiffUtil.ItemCallback<SpecialtiesVO>() {
        override fun areItemsTheSame(oldItem: SpecialtiesVO, newItem: SpecialtiesVO): Boolean {
            return (oldItem == newItem)

        }

        override fun areContentsTheSame(oldItem: SpecialtiesVO, newItem: SpecialtiesVO): Boolean {
            return (oldItem == newItem)
        }
    }