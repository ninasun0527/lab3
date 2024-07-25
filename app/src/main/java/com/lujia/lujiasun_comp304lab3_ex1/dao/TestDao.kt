package com.lujia.lujiasun_comp304lab3_ex1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lujia.lujiasun_comp304lab3_ex1.entity.Test

@Dao
interface TestDao {
    @Insert
    suspend fun insert(test: Test)

    @Update
    suspend fun update(test: Test)

    @Query("SELECT * FROM test WHERE patientId = :patientId")
    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>>
}