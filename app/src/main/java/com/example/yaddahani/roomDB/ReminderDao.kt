package com.example.yaddahani.roomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.yaddahani.models.FriendsRemindersListModel

@Dao
interface ReminderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReminders(reminders: ArrayList<FriendsRemindersListModel>)

    @Insert
    suspend fun addReminder(reminder: FriendsRemindersListModel)

    @Query("Select * from receivedRemindersTable order by reminderTableId ASC")
    fun getAllReminders() : LiveData<List<FriendsRemindersListModel>>

    @Query("Select * from receivedRemindersTable where isArchived = :archived order by reminderTableId DESC")
    fun getArchivedReminders(archived: Boolean) : LiveData<List<FriendsRemindersListModel>>

    @Query("Delete from receivedRemindersTable")
    suspend fun deleteReminders()

    @Query("Delete from receivedRemindersTable where reminderId = :deleteReminderId")
    suspend fun deleteReminder(deleteReminderId: Int)

    @Query("Update receivedRemindersTable set isArchived = :archived where reminderId = :id")
    suspend fun reminderArchived(archived: Boolean, id: Int)
}