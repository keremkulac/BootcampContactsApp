package com.keremkulac.contactsapp.data.dataSource
import com.keremkulac.contactsapp.entity.Person
import com.keremkulac.contactsapp.room.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var contactsDao: ContactsDao) {
   suspend fun saveContacts(personName : String,personPhoneNumber : String){
       val person = Person(0,personName,personPhoneNumber)
       contactsDao.insertContacts(person)
    }

    suspend fun updateContacts(personID : Int,personName : String,personPhoneNumber : String){
        val updatedPerson = Person(personID,personName,personPhoneNumber)
        contactsDao.updateContacts(updatedPerson)
    }

    suspend fun deleteContacts(personID : Int){
        val deletedPerson = Person(personID,"","")
        contactsDao.deleteContacts(deletedPerson)
    }
    suspend fun getContacts() : List<Person> =
        withContext(Dispatchers.IO){
            return@withContext  contactsDao.loadAllContacts()
        }

    suspend fun search(text : String) : List<Person> =
        withContext(Dispatchers.IO){
            return@withContext contactsDao.search(text)
        }
}