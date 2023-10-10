package com.keremkulac.contactsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.databinding.FragmentHomeBinding
import com.keremkulac.contactsapp.util.switch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.homeObject = this
        binding.toolbarTitle = "Kişiler"
        viewModel.personList.observe(viewLifecycleOwner){
            val contactsAdapter = ContactsAdapter(requireContext(),it,viewModel)
            binding.contactAdapter = contactsAdapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

        })
        return binding.root
    }


    fun newContact(view : View){
        Navigation.switch(view,R.id.action_homeFragment_to_contactsRegistrationFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getContacts()
    }



}