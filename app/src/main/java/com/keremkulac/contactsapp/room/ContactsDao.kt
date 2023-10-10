package com.keremkulac.contactsapp.room

import androidx.room.*
import com.keremkulac.contactsapp.entity.Person

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    suspend fun loadAllContacts() : List<Person>

    @Insert
    suspend fun insertContacts(person: Person)

    @Update
    suspend fun updateContacts(person: Person)

    @Delete
    suspend fun deleteContacts(person: Person)

    @Query("SELECT * FROM contacts WHERE person_name like '%' || :text || '%'")
    suspend fun search(text : String) : List<Person>
}