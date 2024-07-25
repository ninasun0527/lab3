package com.lujia.lujiasun_comp304lab3_ex1.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nurse")
data class Nurse(
    @PrimaryKey val nurseId: Int,
    val firstname: String,
    val lastname: String,
    val department: String,
    val password: String
)
