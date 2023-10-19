package com.example.to_dolist

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.to_dolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toDoLogoImg.startAnimation(AnimationUtils.loadAnimation(this,R.anim.main_page_img_anim))

        val handler = Handler()
        val delayInMillis = 5000


        handler.postDelayed({
            val sharedPref = getSharedPreferences("db", MODE_PRIVATE)
            val name = sharedPref.getString("name", "").toString()

            val intent = if (name.isNotBlank()) {
                Intent(this, UserInfoActivity::class.java)
            } else {
                Intent(this, SignUp::class.java)
            }

            startActivity(intent)
            finish()

        }, delayInMillis.toLong())


    }


}