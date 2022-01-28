package com.example.yaddahani.roomDB

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.yaddahani.models.FriendsRemindersListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemindersViewModel(application: Application): AndroidViewModel(Application()) {
    val readAllReminders: LiveData<List<FriendsRemindersListModel>>
    private val repository: ReminderRepository
    val reminderArchived: LiveData<List<FriendsRemindersListModel>>
    val reminderUnArchived: LiveData<List<FriendsRemindersListModel>>

    init {
        val reminderDao = ReminderDataBase.getDataBase(application).reminderDao()
        repository = ReminderRepository(reminderDao)
        readAllReminders = repository.gettingAllReminders

        reminderArchived = repository.archivedReminders
        reminderUnArchived = repository.unArchivedReminder
    }

    fun addReminder(friendsRemindersListModel: ArrayList<FriendsRemindersListModel>){
        viewModelScope.launch (Dispatchers.IO){
            repository.addReminders(friendsRemindersListModel)
        }
    }

    fun addingReminder(reminder: FriendsRemindersListModel) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.adReminder(reminder)
        }
    }

    fun deleteReceivedReminders() {
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteAllReminders()
        }
    }

    fun deleteReminder(reminderId: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteReminder(reminderId)
        }
    }

    fun updateReminderArchived(reminderIsArchive: Boolean, id: Int) {
        viewModelScope.launch {
            repository.reminderIsArchived(reminderIsArchive, id)
        }
    }
}