package com.example.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.to_dolist.databinding.ActivityHeaderPageBinding

class HeaderPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeaderPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeaderPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}