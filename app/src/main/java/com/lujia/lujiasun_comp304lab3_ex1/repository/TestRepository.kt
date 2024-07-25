package com.lujia.lujiasun_comp304lab3_ex1.repository

import androidx.lifecycle.LiveData
import com.lujia.lujiasun_comp304lab3_ex1.dao.TestDao
import com.lujia.lujiasun_comp304lab3_ex1.entity.Test

class TestRepository(private val testDao: TestDao) {
    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>> {
        return testDao.getTestsByPatientId(patientId)
    }

    suspend fun insert(test: Test) {
        testDao.insert(test)
    }

    suspend fun update(test: Test) {
        testDao.update(test)
    }
}
