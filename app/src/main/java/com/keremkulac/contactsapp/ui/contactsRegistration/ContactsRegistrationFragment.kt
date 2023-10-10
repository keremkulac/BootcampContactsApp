package com.keremkulac.contactsapp.ui.contactsRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.databinding.FragmentContactsRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentContactsRegistrationBinding
    private val viewModel by viewModels<ContactsRegistrationViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_registration,container,false)
        binding.contactRegistrationObject = this
        binding.toolbarTitle = "Kişi Kayıt"

        return binding.root
    }

    fun saveContact(personName : String,personPhoneNumber : String){
        viewModel.saveContacts(personName,personPhoneNumber)
    }

}