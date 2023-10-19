package com.example.to_dolist

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.to_dolist.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)

        binding.nameTv.text = sharedPreferences.getString("name", "")
        binding.surnameTv.text = sharedPreferences.getString("surname", "")
        binding.emailTv.text = sharedPreferences.getString("email", "")

        binding.logOutBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            finish()
        }


    }
}