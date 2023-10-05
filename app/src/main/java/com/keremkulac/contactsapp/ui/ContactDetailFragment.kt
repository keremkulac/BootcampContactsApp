package com.keremkulac.contactsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.keremkulac.contactsapp.databinding.FragmentContactDetailBinding


class ContactDetailFragment : Fragment() {

    private lateinit var binding : FragmentContactDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentContactDetailBinding.inflate(inflater)
        val bundle : ContactDetailFragmentArgs by navArgs()
        val person = bundle.person
        binding.personName.setText(person.personName)
        binding.personPhoneNumber.setText(person.personPhoneNumber)
        binding.update.setOnClickListener {
            val personName = binding.personName.text.toString()
            val personPhoneNumber = binding.personPhoneNumber.text.toString()
            update(person.id,personName,personPhoneNumber)
        }
        return binding.root
    }

    private fun update(personID : Int,personName : String,personPhoneNumber : String){
        Log.d("TAG","$personID \n $personName \n $personPhoneNumber")
    }

}