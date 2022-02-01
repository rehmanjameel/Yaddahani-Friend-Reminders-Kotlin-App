package com.example.yaddahani.reminders

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class ShowReceivedRemindersFragmentDirections private constructor() {
  public companion object {
    public fun actionShowReceivedRemindersFragmentToFriendReminderFragmentId(): NavDirections =
        ActionOnlyNavDirections(R.id.action_showReceivedRemindersFragment_to_friendReminderFragmentId)
  }
}
