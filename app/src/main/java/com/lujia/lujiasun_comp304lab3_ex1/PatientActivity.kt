package com.lujia.lujiasun_comp304lab3_ex1

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lujia.lujiasun_comp304lab3_ex1.databinding.ActivityPatientBinding
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient
import com.lujia.lujiasun_comp304lab3_ex1.viewmodel.PatientViewModel

class PatientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPatientBinding
    private val patientViewModel: PatientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddPatient.setOnClickListener {
            val patient = Patient(
                patientId = binding.editTextPatientId.text.toString().toInt(),
                firstname = binding.editTextFirstName.text.toString(),
                lastname = binding.editTextLastName.text.toString(),
                department = binding.editTextDepartment.text.toString(),
                nurseId = getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE).getInt("nurseId", -1),
                room = binding.editTextRoom.text.toString()
            )
            patientViewModel.insert(patient)
        }

        binding.buttonViewTests.setOnClickListener {
            val intent = Intent(this, ViewTestInfoActivity::class.java)
            intent.putExtra("patientId", binding.editTextPatientId.text.toString().toInt())
            startActivity(intent)
        }

        binding.buttonUpdateInfo.setOnClickListener {
            val intent = Intent(this, UpdateInfoActivity::class.java)
            intent.putExtra("patientId", binding.editTextPatientId.text.toString().toInt())
            startActivity(intent)
        }
    }
}
