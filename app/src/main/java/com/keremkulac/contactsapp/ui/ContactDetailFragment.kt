package com.keremkulac.contactsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.databinding.FragmentContactDetailBinding


class ContactDetailFragment : Fragment() {

    private lateinit var binding : FragmentContactDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_detail,container,false)
        binding.contactDetailObject = this
        binding.toolbarTitle = "Kişi Detay"
        val bundle : ContactDetailFragmentArgs by navArgs()
        binding.person = bundle.person
        return binding.root
    }

    fun update(personID : Int,personName : String,personPhoneNumber : String){
        Log.d("TAG","$personID \n $personName \n $personPhoneNumber")
    }

}