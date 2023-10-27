package com.stone.uiassignment.data

import android.content.res.Resources
import com.stone.uiassignment.R

data  class SpecialtiesVO (
    val id : Int,
    val name : String,
    val resource : Int
)
val dummySpecialties :List<SpecialtiesVO> = arrayListOf(
    SpecialtiesVO(0,"Workplace", R.drawable.ic_workspace),
    SpecialtiesVO(1,"Abuse", R.drawable.ic_abuse),
    SpecialtiesVO(2,"Anxiety", R.drawable.ic_anxiety),
    SpecialtiesVO(3,"Disorder", R.drawable.ic_disorder),
    SpecialtiesVO(4,"Depression", R.drawable.ic_depression),
    SpecialtiesVO(5,"Youth Support", R.drawable.ic_youth_support),
    SpecialtiesVO(6,"Sex Edu", R.drawable.ic_sex_edu),
    SpecialtiesVO(7,"LGBTQ+", R.drawable.ic_equality),

    )