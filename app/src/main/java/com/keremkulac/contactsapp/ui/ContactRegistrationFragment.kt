package com.keremkulac.contactsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.databinding.FragmentContactRegistrationBinding


class ContactRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentContactRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_registration,container,false)
        binding.contactRegistrationObject = this
        binding.toolbarTitle = "Kişi Kayıt"

        return binding.root
    }

    fun saveContact(personName : String,personPhoneNumber : String){
        Log.d("TAG","$personName $personPhoneNumber")
    }


}