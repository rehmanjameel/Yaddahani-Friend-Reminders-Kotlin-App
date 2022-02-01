package com.example.yaddahani.friendsmodule

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R
import com.example.yaddahani.models.FriendModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FriendListFragmentDirections private constructor() {
  private data class ActionFriendListFragmentIdToReminderFriendFragment(
    public val friendsList: FriendModel
  ) : NavDirections {
    public override val actionId: Int = R.id.action_friendListFragmentId_to_reminderFriendFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java)) {
          result.putParcelable("friendsList", this.friendsList as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          result.putSerializable("friendsList", this.friendsList as Serializable)
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionFriendListFragmentIdToSearchFriendFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_friendListFragmentId_to_searchFriendFragment)

    public fun actionFriendListFragmentIdToReminderFriendFragment(friendsList: FriendModel):
        NavDirections = ActionFriendListFragmentIdToReminderFriendFragment(friendsList)
  }
}
