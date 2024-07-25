package com.lujia.lujiasun_comp304lab3_ex1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lujia.lujiasun_comp304lab3_ex1.database.AppDatabase
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient
import com.lujia.lujiasun_comp304lab3_ex1.repository.PatientRepository
import kotlinx.coroutines.launch

class PatientViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PatientRepository
    val allPatients: LiveData<List<Patient>>

    init {
        val patientDao = AppDatabase.getDatabase(application).patientDao()
        repository = PatientRepository(patientDao)
        allPatients = repository.allPatients
    }

    fun getPatientById(id: Int): LiveData<Patient> {
        return repository.getPatientById(id)
    }

    fun insert(patient: Patient) = viewModelScope.launch {
        repository.insert(patient)
    }

    fun update(patient: Patient) = viewModelScope.launch {
        repository.update(patient)
    }
}
