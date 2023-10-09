package com.keremkulac.contactsapp.data.dataSource
import android.util.Log
import com.keremkulac.contactsapp.entity.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource {
   suspend fun saveContacts(personName : String,personPhoneNumber : String){
        Log.d("TAG","$personName $personPhoneNumber")
    }

    suspend fun updateContacts(personID : Int,personName : String,personPhoneNumber : String){
        Log.d("TAG","$personID \n $personName \n $personPhoneNumber")
    }

    suspend fun deleteContacts(personID : Int,personName : String,personPhoneNumber : String){
        Log.d("TAG","$personID \n $personName \n $personPhoneNumber")
    }
    suspend fun deleteContacts(id : Int){
        Log.d("TAG","$id silindi")
    }
    suspend fun getContacts() : List<Person> =
        withContext(Dispatchers.IO){
            val personList = ArrayList<Person>()
            val person1 = Person(0,"Ahmet","145345")
            val person2 = Person(1,"Hasan","4562")
            val person3 = Person(2,"Merve","86554")
            personList.add(person1)
            personList.add(person2)
            personList.add(person3)
            return@withContext personList
        }

    suspend fun search(text : String) : List<Person> =
        withContext(Dispatchers.IO){
            val personList = ArrayList<Person>()
            val person1 = Person(0,"Ahmet","145345")
            personList.add(person1)
            return@withContext personList
        }
}