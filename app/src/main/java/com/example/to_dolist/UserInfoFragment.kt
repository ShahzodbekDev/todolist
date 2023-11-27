package com.example.to_dolist


import android.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.to_dolist.databinding.FragmentUserInfoBinding


class UserInfoFragment : Fragment() {
    var _binding :FragmentUserInfoBinding? = null
    val binding get() = _binding!!
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        // Fragment ichida Context ni olish
        val context = requireContext()

        // SharedPreferences dan ma'lumot olish

        // SharedPreferences dan ma'lumot olish
        val preferences = context.getSharedPreferences("db", Context.MODE_PRIVATE)
        val nameTitle = preferences.getString("name", "Default value")
        val surnameTitle = preferences.getString("surname", "Default value")
        val emailTitle = preferences.getString("email", "Default value")

        binding.nameTv.text = nameTitle
        binding.surnameTv.text = surnameTitle
        binding.emailTv.text = emailTitle

        binding.logoutBtn.setOnClickListener {
            preferences.edit().clear().apply()
            getActivity()?.finish()

        }

    }


}