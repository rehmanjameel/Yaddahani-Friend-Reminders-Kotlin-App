package com.example.yaddahani.friendsmodule

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.yaddahani.R
import com.example.yaddahani.models.FriendsRemindersListModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FriendReminderFragmentDirections private constructor() {
  private data class ActionFriendReminderFragmentIdToShowReceivedRemindersFragment(
    public val receivedReminders: FriendsRemindersListModel
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_friendReminderFragmentId_to_showReceivedRemindersFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
          result.putParcelable("receivedReminders", this.receivedReminders as Parcelable)
        } else if
            (Serializable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
          result.putSerializable("receivedReminders", this.receivedReminders as Serializable)
        } else {
          throw UnsupportedOperationException(FriendsRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public
        fun actionFriendReminderFragmentIdToShowReceivedRemindersFragment(receivedReminders: FriendsRemindersListModel):
        NavDirections =
        ActionFriendReminderFragmentIdToShowReceivedRemindersFragment(receivedReminders)
  }
}
