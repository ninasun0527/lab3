package com.lujia.lujiasun_comp304lab3_ex1.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class Test(
    @PrimaryKey val testId: Int,
    val patientId: Int,
    val nurseId: Int,
    val BPL: Double,
    val BPH: Double,
    val temperature: Double,
    val otherTest: String
)
