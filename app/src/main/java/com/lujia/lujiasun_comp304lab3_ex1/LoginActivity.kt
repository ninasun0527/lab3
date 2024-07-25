package com.lujia.lujiasun_comp304lab3_ex1

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lujia.lujiasun_comp304lab3_ex1.databinding.ActivityLoginBinding
import com.lujia.lujiasun_comp304lab3_ex1.viewmodel.NurseViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val nurseViewModel: NurseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val nurseId = binding.editTextNurseId.text.toString().toInt()
            val password = binding.editTextPassword.text.toString()
            nurseViewModel.login(nurseId, password).observe(this, { nurse ->
                if (nurse != null) {
                    getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE).edit()
                        .putInt("nurseId", nurseId).apply()
                    startActivity(Intent(this, PatientActivity::class.java))
                } else {
                    // Handle login failure
                }
            })
        }
    }
}
