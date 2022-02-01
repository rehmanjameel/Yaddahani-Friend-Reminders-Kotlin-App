package com.example.yaddahani.reminders

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R
import com.example.yaddahani.models.FriendModel
import com.example.yaddahani.models.SentRemindersListModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SendReminderToFriendFragmentDirections private constructor() {
  private data class ActionReminderFriendFragmentToAddSendReminderFragment(
    public val sendReminderToFriend: FriendModel
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_reminderFriendFragment_to_addSendReminderFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java)) {
          result.putParcelable("sendReminderToFriend", this.sendReminderToFriend as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          result.putSerializable("sendReminderToFriend", this.sendReminderToFriend as Serializable)
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  private data class ActionReminderFriendFragmentToShowSentRemindersFragment(
    public val sentReminders: SentRemindersListModel
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_reminderFriendFragment_to_showSentRemindersFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
          result.putParcelable("sentReminders", this.sentReminders as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
          result.putSerializable("sentReminders", this.sentReminders as Serializable)
        } else {
          throw UnsupportedOperationException(SentRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionReminderFriendFragmentToFriendListFragmentId(): NavDirections =
        ActionOnlyNavDirections(R.id.action_reminderFriendFragment_to_friendListFragmentId)

    public
        fun actionReminderFriendFragmentToAddSendReminderFragment(sendReminderToFriend: FriendModel):
        NavDirections = ActionReminderFriendFragmentToAddSendReminderFragment(sendReminderToFriend)

    public
        fun actionReminderFriendFragmentToShowSentRemindersFragment(sentReminders: SentRemindersListModel):
        NavDirections = ActionReminderFriendFragmentToShowSentRemindersFragment(sentReminders)
  }
}
