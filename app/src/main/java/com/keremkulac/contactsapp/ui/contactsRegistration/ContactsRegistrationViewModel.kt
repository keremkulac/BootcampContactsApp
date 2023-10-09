package com.keremkulac.contactsapp.ui.contactsRegistration

import androidx.lifecycle.ViewModel
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsRegistrationViewModel : ViewModel() {
    private val contactsRepository = ContactsRepository()

    fun saveContacts(personName : String,personPhoneNumber : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.saveContacts(personName,personPhoneNumber)
        }
    }
}