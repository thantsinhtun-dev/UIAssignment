package com.stone.uiassignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stone.uiassignment.R
import com.stone.uiassignment.adapter.SpecialtiesAdapter
import com.stone.uiassignment.data.dummyCategoryVO
import com.stone.uiassignment.data.dummyDoctorVO
import com.stone.uiassignment.data.dummySpecialties
import com.stone.uiassignment.databinding.FragmentAppointmentBinding
import com.stone.uiassignment.databinding.FragmentHomeBinding
import com.stone.uiassignment.ui.viewpods.DoctorListViewPod

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var specialtiesAdapter: SpecialtiesAdapter
    lateinit var topDoctorList : DoctorListViewPod
    lateinit var availableDoctorList : DoctorListViewPod


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setUpViewPods()

        initialData()
    }

    private fun setUpViewPods() {
        topDoctorList = binding.vpTopDoctor.root
        topDoctorList.setUpDoctorListViewPod("Top Doctors",true)

        availableDoctorList = binding.vpAvailableDoctor.root
        availableDoctorList.setUpDoctorListViewPod("Available Doctors",false)

    }

    private fun initialData(){
        topDoctorList.setData(dummyDoctorVO, dummyCategoryVO)
        availableDoctorList.setData(dummyDoctorVO, dummyCategoryVO)

    }

    private fun setupRecyclerView() {

        specialtiesAdapter = SpecialtiesAdapter()
        binding.rvSpecialties.adapter = specialtiesAdapter
        specialtiesAdapter.submitList(dummySpecialties)
    }
}