package com.example.yaddahani.models

import java.io.Serializable

class SentRemindersListModel(
    val sentReminderId: Int,
    val sentReminderText: String,
    val sentReminderDate: String,
    val sentReminderFrom: String,
    val sentReminderTo: String,
    val sentReminderStatus: String,
    var isExpand: Boolean = false
) : Serializable