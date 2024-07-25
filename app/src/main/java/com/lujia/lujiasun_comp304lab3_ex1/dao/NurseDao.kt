package com.lujia.lujiasun_comp304lab3_ex1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lujia.lujiasun_comp304lab3_ex1.entity.Nurse

@Dao
interface NurseDao {
    @Insert
    suspend fun insert(nurse: Nurse)

    @Query("SELECT * FROM nurse WHERE nurseId = :id")
    fun getNurseById(id: Int): LiveData<Nurse>

    @Query("SELECT * FROM nurse WHERE nurseId = :id AND password = :password")
    suspend fun login(id: Int, password: String): Nurse?
}