package com.stone.uiassignment.adapter


import com.stone.uiassignment.data.SpecialtiesVO
import com.stone.uiassignment.databinding.ItemSpecialtiesBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stone.uiassignment.R
import com.stone.uiassignment.data.DoctorVO
import com.stone.uiassignment.databinding.ItemDoctorBinding

class DoctorAdapter() : ListAdapter<DoctorVO,DoctorAdapter.DoctorViewHolder >(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return DoctorViewHolder(
            ItemDoctorBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.doctorName.text = item.name
    }

    inner class DoctorViewHolder(val binding: ItemDoctorBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}
private val DIFF_CALLBACK
    get() = object : DiffUtil.ItemCallback<DoctorVO>() {
        override fun areItemsTheSame(oldItem: DoctorVO, newItem: DoctorVO): Boolean {
            return (oldItem == newItem)

        }

        override fun areContentsTheSame(oldItem: DoctorVO, newItem: DoctorVO): Boolean {
            return (oldItem == newItem)
        }
    }