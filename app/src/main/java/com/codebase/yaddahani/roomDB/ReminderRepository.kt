package com.codebase.yaddahani.roomDB

import androidx.lifecycle.LiveData
import com.codebase.yaddahani.models.FriendsRemindersListModel

class ReminderRepository(private val friendReminderDao: ReminderDao) {

    val gettingAllReminders: LiveData<List<FriendsRemindersListModel>> = friendReminderDao.getAllReminders()

    private val unArchive: Boolean = false
    val unArchivedReminder: LiveData<List<FriendsRemindersListModel>> = friendReminderDao.getArchivedReminders(unArchive)

    private val archive: Boolean = true
    val archivedReminders: LiveData<List<FriendsRemindersListModel>> = friendReminderDao.getArchivedReminders(archive)

    suspend fun addReminders(remindersListModel: ArrayList<FriendsRemindersListModel>) {
        friendReminderDao.addReminders(remindersListModel)
    }

    suspend fun adReminder(remindersListModel: FriendsRemindersListModel) {
        friendReminderDao.addReminder(remindersListModel)
    }
    suspend fun deleteAllReminders() {
        friendReminderDao.deleteReminders()
    }

    suspend fun deleteReminder(reminderId: Int) {
        friendReminderDao.deleteReminder(reminderId)
    }

    suspend fun reminderIsArchived(archived: Boolean, id : Int) {
        friendReminderDao.reminderArchived(archived, id)
    }
 }