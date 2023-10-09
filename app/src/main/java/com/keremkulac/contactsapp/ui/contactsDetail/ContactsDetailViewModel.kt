package com.keremkulac.contactsapp.ui.contactsDetail

import androidx.lifecycle.ViewModel
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsDetailViewModel : ViewModel() {

    private val contactsRepository = ContactsRepository()

    fun updateContacts(personID : Int, personName : String,personPhoneNumber : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.updateContacts(personID,personName,personPhoneNumber)
        }
    }
}