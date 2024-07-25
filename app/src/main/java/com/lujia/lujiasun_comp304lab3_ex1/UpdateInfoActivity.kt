package com.lujia.lujiasun_comp304lab3_ex1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lujia.lujiasun_comp304lab3_ex1.databinding.ActivityUpdateInfoBinding
import com.lujia.lujiasun_comp304lab3_ex1.entity.Patient
import com.lujia.lujiasun_comp304lab3_ex1.viewmodel.PatientViewModel

class UpdateInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateInfoBinding
    private val patientViewModel: PatientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val patientId = intent.getIntExtra("patientId", -1)
        patientViewModel.getPatientById(patientId).observe(this, { patient ->
            if (patient != null) {
                binding.editTextPatientId.setText(patient.patientId.toString())
                binding.editTextFirstName.setText(patient.firstname)
                binding.editTextLastName.setText(patient.lastname)
                binding.editTextDepartment.setText(patient.department)
                binding.editTextRoom.setText(patient.room)
            }
        })

        binding.buttonUpdatePatient.setOnClickListener {
            val patient = Patient(
                patientId = binding.editTextPatientId.text.toString().toInt(),
                firstname = binding.editTextFirstName.text.toString(),
                lastname = binding.editTextLastName.text.toString(),
                department = binding.editTextDepartment.text.toString(),
                nurseId = getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE).getInt("nurseId", -1),
                room = binding.editTextRoom.text.toString()
            )
            patientViewModel.update(patient)
        }
    }
}
