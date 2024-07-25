package com.lujia.lujiasun_comp304lab3_ex1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient

@Dao
interface PatientDao {
    @Insert
    suspend fun insert(patient: Patient): Long

    @Update
    suspend fun update(patient: Patient): Int

    @Query("SELECT * FROM patient WHERE patientId = :id")
    fun getPatientById(id: Int): LiveData<Patient>

    @Query("SELECT * FROM patient")
    fun getAllPatients(): LiveData<List<Patient>>
}
