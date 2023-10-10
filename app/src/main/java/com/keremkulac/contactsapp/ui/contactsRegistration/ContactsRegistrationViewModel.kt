package com.keremkulac.contactsapp.ui.contactsRegistration

import androidx.lifecycle.ViewModel
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsRegistrationViewModel @Inject constructor(var contactsRepository: ContactsRepository): ViewModel() {

    fun saveContacts(personName : String,personPhoneNumber : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.saveContacts(personName,personPhoneNumber)
        }
    }
}