package com.lujia.lujiasun_comp304lab3_ex1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lujia.lujiasun_comp304lab3_ex1.database.AppDatabase
import com.lujia.lujiasun_comp304lab3_ex1.entity.Test
import com.lujia.lujiasun_comp304lab3_ex1.repository.TestRepository
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TestRepository

    init {
        val testDao = AppDatabase.getDatabase(application).testDao()
        repository = TestRepository(testDao)
    }

    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>> {
        return repository.getTestsByPatientId(patientId)
    }

    fun insert(test: Test) = viewModelScope.launch {
        repository.insert(test)
    }

    fun update(test: Test) = viewModelScope.launch {
        repository.update(test)
    }
}
