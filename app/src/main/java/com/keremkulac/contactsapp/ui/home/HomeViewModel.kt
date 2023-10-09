package com.keremkulac.contactsapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import com.keremkulac.contactsapp.entity.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val contactsRepository = ContactsRepository()
    val personList = MutableLiveData<List<Person>>()

    init {
        getContacts()
    }
    fun deleteContacts(id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.deleteContacts(id)
            getContacts()
        }
    }

    fun getContacts(){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = contactsRepository.getContacts()
        }
    }
    fun search(text : String){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = contactsRepository.search(text)
        }
    }


}