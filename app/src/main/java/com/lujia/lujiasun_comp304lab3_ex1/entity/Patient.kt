package com.lujia.lujiasun_comp304lab3_ex1.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patient")
data class Patient(
    @PrimaryKey val patientId: Int,
    val firstname: String,
    val lastname: String,
    val department: String,
    val nurseId: Int,
    val room: String
)
