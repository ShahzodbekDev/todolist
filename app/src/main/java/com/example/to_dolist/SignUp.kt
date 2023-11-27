package com.example.to_dolist

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.to_dolist.databinding.ActivitySignInBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)


        binding.signInBtn.setOnClickListener {

            val name = binding.nameEt.text.toString()
            val surname = binding.surNameEt.text.toString()
            val email = binding.emaitEt.text.toString()

            if (name.isNotBlank()&&surname.isNotBlank()&&email.isNotBlank()){

                sharedPreferences.edit().putString("name",name).apply()
                sharedPreferences.edit().putString("surname",surname).apply()
                sharedPreferences.edit().putString("email",email).apply()

                val intent = Intent(this,HeaderPageActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Tepadagi bolimlar toldirilishi shart!!!", Toast.LENGTH_SHORT).show()
            }
        }




    }


}