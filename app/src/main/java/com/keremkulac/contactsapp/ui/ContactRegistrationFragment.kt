package com.keremkulac.contactsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.keremkulac.contactsapp.databinding.FragmentContactRegistrationBinding


class ContactRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentContactRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentContactRegistrationBinding.inflate(inflater)
        binding.registrationToolbar.title = "Kişi Kayıt"
        binding.save.setOnClickListener {
            save(binding.personName.text.toString(),binding.personPhoneNumber.text.toString())
        }
        return binding.root
    }

   private fun save(personName : String,personPhoneNumber : String){
        Log.d("TAG","$personName $personPhoneNumber")
    }


}