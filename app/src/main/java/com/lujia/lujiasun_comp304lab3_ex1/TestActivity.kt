package com.lujia.lujiasun_comp304lab3_ex1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lujia.lujiasun_comp304lab3_ex1.databinding.ActivityTestBinding
import com.lujia.lujiasun_comp304lab3_ex1.entity.Test
import com.lujia.lujiasun_comp304lab3_ex1.viewmodel.TestViewModel

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAddTest.setOnClickListener {
            val test = Test(
                testId = binding.editTextTestId.text.toString().toInt(),
                patientId = binding.editTextPatientId.text.toString().toInt(),
                nurseId = getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE).getInt("nurseId", -1),
                BPL = binding.editTextBPL.text.toString().toDouble(),
                BPH = binding.editTextBPH.text.toString().toDouble(),
                temperature = binding.editTextTemperature.text.toString().toDouble(),
                otherTest = binding.editTextOtherTest.text.toString()
            )
            testViewModel.insert(test)
        }
    }
}
