package com.stone.uiassignment.ui.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.stone.uiassignment.adapter.CategoryAdapter
import com.stone.uiassignment.adapter.DoctorAdapter
import com.stone.uiassignment.data.CategoryVO
import com.stone.uiassignment.data.DoctorVO
import com.stone.uiassignment.databinding.ViewPodDoctorListBinding

class DoctorListViewPod  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {
    lateinit var doctorAdapter: DoctorAdapter
    lateinit var categoryAdapter: CategoryAdapter


    lateinit var binding : ViewPodDoctorListBinding
//    init {
//        binding = ViewPodDoctorListBinding.inflate(LayoutInflater.from(context),this,false)
//
//        addView(binding.root)
//    }
    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodDoctorListBinding.bind(this)
    }

    private  fun setUpDoctorListView() {
        doctorAdapter = DoctorAdapter()
        binding.rvDoctor.adapter = doctorAdapter

        categoryAdapter = CategoryAdapter()
        binding.rvCategory.adapter = categoryAdapter
    }

    fun setUpDoctorListViewPod(title:String,showCategory:Boolean){
        setUpDoctorListView()
        binding.title.text = title

        if (showCategory){
            binding.rvCategory.visibility = View.VISIBLE
        }else {
            binding.rvCategory.visibility = View.GONE
        }
    }

    fun setData(doctorList:List<DoctorVO>,categoryList:List<CategoryVO>){
        categoryAdapter.submitList(categoryList)
        doctorAdapter.submitList(doctorList)
    }

}