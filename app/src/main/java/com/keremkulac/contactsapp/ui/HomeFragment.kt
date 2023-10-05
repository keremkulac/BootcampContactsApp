package com.keremkulac.contactsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.data.Person
import com.keremkulac.contactsapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.homeToolbar.title = "Kişiler"
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val personList = ArrayList<Person>()
        val person1 = Person(0,"Ahmet","145345")
        val person2 = Person(1,"Hasan","4562")
        val person3 = Person(2,"Merve","86554")
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)
        val contactAdapter = ContactAdapter(requireContext(),personList)
        binding.recyclerView.adapter = contactAdapter
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_contactRegistrationFragment)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

        })
        return binding.root
    }

    fun search(text : String){
        Log.d("TAG",text)
    }


}