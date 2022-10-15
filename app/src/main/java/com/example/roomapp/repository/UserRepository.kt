package com.example.roomapp.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.data.ContactDao
import com.example.roomapp.model.Contact

class UserRepository(private val userDao: ContactDao) {

    val readAllData: LiveData<List<Contact>> = userDao.readAllData()

    suspend fun addUser(contact: Contact){
        userDao.addContact(contact)
    }

    suspend fun updateContact(contact: Contact){
        userDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact){
        userDao.deleteContact(contact)
    }

    suspend fun deleteAllContacts(){
        userDao.deleteAllContacts()
    }

}