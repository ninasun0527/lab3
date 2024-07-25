package com.lujia.lujiasun_comp304lab3_ex1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lujia.lujiasun_comp304lab3_ex1.databinding.ActivityViewTestInfoBinding
import com.lujia.lujiasun_comp304lab3_ex1.viewmodel.TestViewModel

class ViewTestInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewTestInfoBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewTestInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val patientId = intent.getIntExtra("patientId", -1)
        testViewModel.getTestsByPatientId(patientId).observe(this, { tests ->
            // Display the tests in the UI
        })
    }
}
