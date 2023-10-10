package com.keremkulac.contactsapp.ui.contactsDetail

import androidx.lifecycle.ViewModel
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsDetailViewModel @Inject constructor(var contactsRepository: ContactsRepository): ViewModel() {

    fun updateContacts(personID : Int, personName : String,personPhoneNumber : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.updateContacts(personID,personName,personPhoneNumber)
        }
    }
}