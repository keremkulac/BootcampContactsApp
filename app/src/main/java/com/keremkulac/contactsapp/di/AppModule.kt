package com.keremkulac.contactsapp.di

import com.keremkulac.contactsapp.data.dataSource.ContactsDataSource
import com.keremkulac.contactsapp.data.repository.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource() : ContactsDataSource {
        return ContactsDataSource()
    }
    @Provides
    @Singleton
    fun provideContactsRepository(contactsDataSource: ContactsDataSource) : ContactsRepository{
        return ContactsRepository(contactsDataSource)
    }
}