package com.lujia.lujiasun_comp304lab3_ex1.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.lujia.lujiasun_comp304lab3_ex1.dao.PatientDao
import com.lujia.lujiasun_comp304lab3_ex1.dao.TestDao
import com.lujia.lujiasun_comp304lab3_ex1.dao.NurseDao
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient
import com.lujia.lujiasun_comp304lab3_ex1.entity.Test
import com.lujia.lujiasun_comp304lab3_ex1.entity.Nurse

@Database(entities = [Patient::class, Test::class, Nurse::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun testDao(): TestDao
    abstract fun nurseDao(): NurseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hospital_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
