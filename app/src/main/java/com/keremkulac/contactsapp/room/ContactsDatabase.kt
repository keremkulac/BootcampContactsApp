package com.keremkulac.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keremkulac.contactsapp.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class ContactsDatabase : RoomDatabase(){
    abstract fun getContactsDao() : ContactsDao
}