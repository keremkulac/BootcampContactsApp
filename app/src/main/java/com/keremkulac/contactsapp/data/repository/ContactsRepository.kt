package com.keremkulac.contactsapp.data.repository

import com.keremkulac.contactsapp.entity.Person
import com.keremkulac.contactsapp.data.dataSource.ContactsDataSource

class ContactsRepository {
    var contactsDataSource = ContactsDataSource()
    suspend fun saveContacts(personName : String,personPhoneNumber : String) =
        contactsDataSource.saveContacts(personName,personPhoneNumber)

    suspend fun updateContacts(personID : Int,personName : String,personPhoneNumber : String) =
        contactsDataSource.updateContacts(personID,personName,personPhoneNumber)

    suspend fun deleteContacts(id : Int) = contactsDataSource.deleteContacts(id)

    suspend fun getContacts() : List<Person> = contactsDataSource.getContacts()

    suspend fun search(text : String) : List<Person> = contactsDataSource.search(text)
}
