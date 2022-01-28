package com.example.yaddahani.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "receivedRemindersTable")
class FriendsRemindersListModel(
    @PrimaryKey(autoGenerate = true)
    val reminderTableId: Int,
    val reminderId: Int,
    val reminderText: String,
    val reminderDate: String,
    val reminderFrom: String,
    val reminderTo: String,
    val reminderStatus: String,
    var isExpand: Boolean = false,
    var isArchived: Boolean = false
) : Serializable