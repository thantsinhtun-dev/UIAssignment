package com.stone.uiassignment.data

data class DoctorVO(
    val name: String,
    val position: String
)

val dummyDoctorVO: List<DoctorVO> = arrayListOf(
    DoctorVO("Dr. Myo", "SRE Lead at Onenex"),
    DoctorVO("Dr. Aung", "Therapist"),
    DoctorVO("Dr. Khin", "General Practitioner"),
    DoctorVO("Dr. Sandy", "Therapist")

)