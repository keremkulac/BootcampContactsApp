package com.keremkulac.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.keremkulac.contactsapp.data.dataSource.ContactsDataSource
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import com.keremkulac.contactsapp.room.ContactsDao
import com.keremkulac.contactsapp.room.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDao(@ApplicationContext context : Context) : ContactsDao{
        val contactsDatabase = Room.databaseBuilder(context,ContactsDatabase::class.java,"contacts.sqlite")
            .createFromAsset("contacts.sqlite").build()
        return contactsDatabase.getContactsDao()
    }
    @Provides
    @Singleton
    fun provideContactsDataSource(contactsDao: ContactsDao) : ContactsDataSource {
        return ContactsDataSource(contactsDao)
    }
    @Provides
    @Singleton
    fun provideContactsRepository(contactsDataSource: ContactsDataSource) : ContactsRepository{
        return ContactsRepository(contactsDataSource)
    }
}