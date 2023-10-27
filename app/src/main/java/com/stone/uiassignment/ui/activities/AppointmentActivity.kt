package com.stone.uiassignment.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.stone.uiassignment.R
import com.stone.uiassignment.adapter.DateSelectionAdapter
import com.stone.uiassignment.data.DateTimeVO
import com.stone.uiassignment.databinding.ActivityAppointmentBinding
import com.stone.uiassignment.ui.viewpods.CustomDropDown
import com.stone.uiassignment.utils.getAgeDummyData
import com.stone.uiassignment.utils.getTimeSlotDummyData
import java.text.SimpleDateFormat
import java.util.Calendar


class AppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentBinding

    private lateinit var dateSelectionAdapter: DateSelectionAdapter

    private var dateList : MutableList<DateTimeVO> = mutableListOf()

    companion object {
        fun getIntent(context: Context): Intent {
                return  Intent(context, AppointmentActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupRecyclerView()
        setupSpinner()
        setupListener()
        initDate()

        toggleGender(btnMain = binding.btnMale, btnSec = binding.btnFemale)

    }

    private fun setupListener() {
        binding.btnMale.setOnClickListener {
            toggleGender(btnMain = binding.btnMale, btnSec = binding.btnFemale)

        }
        binding.btnFemale.setOnClickListener {
            toggleGender(btnMain = binding.btnFemale, btnSec = binding.btnMale)
        }

        binding.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun toggleGender(btnMain: MaterialButton,btnSec: MaterialButton,) {
        btnMain.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
        btnSec.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))

        btnMain.setTextColor(ContextCompat.getColor(this, R.color.white))
        btnSec.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))

    }

    private fun setupSpinner() {

        val daysAdapter = CustomDropDown(
            context = applicationContext,
            R.layout.view_holder_drop_down,
            getTimeSlotDummyData
        )
        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTimeSlot.adapter = daysAdapter
        binding.spinnerTimeSlot.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        val ageArrayAdapter = CustomDropDown(
            context = applicationContext,
            R.layout.view_holder_drop_down,
            getAgeDummyData
        )
        ageArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerAge.adapter = ageArrayAdapter
        binding.spinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }

    private fun setupRecyclerView() {
        dateSelectionAdapter = DateSelectionAdapter {

            dateList.forEach{vo->
                vo.isSelected = vo.titleDate == it.titleDate
            }
            dateSelectionAdapter.submitList(dateList)
            dateSelectionAdapter.notifyDataSetChanged()



        }
        binding.rvSelectDate.adapter = dateSelectionAdapter

    }

    private fun initDate(){
        val calendar = Calendar.getInstance()

        for (i in 0..13) {

            val fDay = SimpleDateFormat("EEE")
            val fDate = SimpleDateFormat("dd")
            val dateVO = DateTimeVO(
                titleDate = fDate.format(calendar.time),
                titleDay = fDay.format(calendar.time),
                isSelected = false
            )
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            dateList.add(dateVO)
        }
        dateList[0].isSelected = true


        dateSelectionAdapter.submitList(dateList)


    }



}