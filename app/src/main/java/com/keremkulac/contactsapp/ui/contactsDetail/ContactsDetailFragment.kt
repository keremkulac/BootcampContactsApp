package com.keremkulac.contactsapp.ui.contactsDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.databinding.FragmentContactsDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsDetailFragment : Fragment() {

    private lateinit var binding : FragmentContactsDetailBinding
    private val viewModel by viewModels<ContactsDetailViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_detail,container,false)
        binding.contactDetailObject = this
        binding.toolbarTitle = "Kişi Detay"
        val bundle : ContactsDetailFragmentArgs by navArgs()
        binding.person = bundle.person
        return binding.root
    }

    fun update(personID : Int,personName : String,personPhoneNumber : String){
        viewModel.updateContacts(personID,personName,personPhoneNumber)
    }

}