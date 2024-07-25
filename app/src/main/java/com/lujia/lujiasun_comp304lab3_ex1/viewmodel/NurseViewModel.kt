package com.lujia.lujiasun_comp304lab3_ex1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lujia.lujiasun_comp304lab3_ex1.database.AppDatabase
import com.lujia.lujiasun_comp304lab3_ex1.entity.Nurse
import com.lujia.lujiasun_comp304lab3_ex1.repository.NurseRepository
import kotlinx.coroutines.launch

class NurseViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NurseRepository

    init {
        val nurseDao = AppDatabase.getDatabase(application).nurseDao()
        repository = NurseRepository(nurseDao)
    }

    fun getNurseById(id: Int): LiveData<Nurse> {
        return repository.getNurseById(id)
    }

    fun login(id: Int, password: String): LiveData<Nurse?> {
        val result = MutableLiveData<Nurse?>()
        viewModelScope.launch {
            result.postValue(repository.login(id, password))
        }
        return result
    }

    fun insert(nurse: Nurse) = viewModelScope.launch {
        repository.insert(nurse)
    }
}
