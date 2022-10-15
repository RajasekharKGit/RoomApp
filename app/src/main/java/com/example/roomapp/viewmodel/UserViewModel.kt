package com.example.roomapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapp.data.ContactDatabase
import com.example.roomapp.repository.UserRepository
import com.example.roomapp.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Contact>>
    private val repository: UserRepository

    init {
        val contactDao = ContactDatabase.getDatabase(
            application
        ).contactDao()
        repository = UserRepository(contactDao)
        readAllData = repository.readAllData
    }

    fun addUser(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(contact)
        }
    }

    fun updateUser(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateContact(contact)
        }
    }

    fun deleteUser(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteContact(contact)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllContacts()
        }
    }

}