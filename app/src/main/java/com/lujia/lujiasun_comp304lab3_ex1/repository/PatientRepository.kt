package com.lujia.lujiasun_comp304lab3_ex1.repository

import androidx.lifecycle.LiveData
import com.lujia.lujiasun_comp304lab3_ex1.dao.PatientDao
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient

class PatientRepository(private val patientDao: PatientDao) {
    val allPatients: LiveData<List<Patient>> = patientDao.getAllPatients()

    fun getPatientById(id: Int): LiveData<Patient> {
        return patientDao.getPatientById(id)
    }

    suspend fun insert(patient: Patient) {
        patientDao.insert(patient)
    }

    suspend fun update(patient: Patient) {
        patientDao.update(patient)
    }
}
