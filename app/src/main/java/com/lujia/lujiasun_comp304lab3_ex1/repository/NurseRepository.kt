package com.lujia.lujiasun_comp304lab3_ex1.repository

import androidx.lifecycle.LiveData
import com.lujia.lujiasun_comp304lab3_ex1.dao.NurseDao
import com.lujia.lujiasun_comp304lab3_ex1.entity.Nurse

class NurseRepository(private val nurseDao: NurseDao) {
    fun getNurseById(id: Int): LiveData<Nurse> {
        return nurseDao.getNurseById(id)
    }

    suspend fun login(id: Int, password: String): Nurse? {
        return nurseDao.login(id, password)
    }

    suspend fun insert(nurse: Nurse) {
        nurseDao.insert(nurse)
    }
}
