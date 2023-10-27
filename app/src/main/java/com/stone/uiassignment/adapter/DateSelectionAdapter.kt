package com.stone.uiassignment.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stone.uiassignment.R
import com.stone.uiassignment.data.DateTimeVO
import com.stone.uiassignment.data.DoctorVO
import com.stone.uiassignment.databinding.ItemDoctorBinding
import com.stone.uiassignment.databinding.ItemSelectDateBinding
import java.util.Date


class DateSelectionAdapter(
    val clickListener: (DateTimeVO) -> Unit
) : ListAdapter<DateTimeVO, DateSelectionAdapter.DateSelectionViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateSelectionViewHolder {
        return DateSelectionViewHolder(
            ItemSelectDateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: DateSelectionViewHolder, position: Int) {

        holder.bindDate(getItem(position))

    }

    inner class DateSelectionViewHolder(val binding: ItemSelectDateBinding) : RecyclerView.ViewHolder(binding.root) {

        var dateTimeVO : DateTimeVO? = null
        init {
            dateTimeVO?.let {vo->
                Log.i("Test","click")
                itemView.setOnClickListener{
                    clickListener(vo)
                    Log.i("Test","click")


                }
            }

        }

        fun bindDate(vo : DateTimeVO){
            dateTimeVO = vo
            binding.day.text = vo.titleDay
            binding.date.text = vo.titleDate

            if (vo.isSelected){
                binding.container.setBackgroundResource(R.drawable.background_date_selected)
                binding.date.setTextColor(Color.parseColor("#3E64FF"))
                binding.day.setTextColor(Color.parseColor("#3E64FF"))

            }else{
                binding.date.setTextColor(Color.parseColor("#262C3D"))
                binding.day.setTextColor(Color.parseColor("#262C3D"))

                binding.container.setBackgroundResource(R.drawable.background_date_unselected)

            }
            binding.container.setOnClickListener{
                clickListener(vo)
            }

        }
    }


}
private val DIFF_CALLBACK
    get() = object : DiffUtil.ItemCallback<DateTimeVO>() {
        override fun areItemsTheSame(oldItem: DateTimeVO, newItem: DateTimeVO): Boolean {
            return (oldItem.isSelected == newItem.isSelected)

        }

        override fun areContentsTheSame(oldItem: DateTimeVO, newItem: DateTimeVO): Boolean {
            return (oldItem.isSelected == newItem.isSelected)
        }
    }