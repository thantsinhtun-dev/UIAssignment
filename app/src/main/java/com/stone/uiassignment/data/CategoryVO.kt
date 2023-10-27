package com.stone.uiassignment.data

import com.stone.uiassignment.R

data class CategoryVO (
    val name:String
)
val dummyCategoryVO :List<CategoryVO> = arrayListOf(
    CategoryVO("All"),
    CategoryVO("General"),
    CategoryVO("Abuse Recovery"),
    CategoryVO("Eating Disorder"),
    CategoryVO("Workplace Mental Health"),
    )