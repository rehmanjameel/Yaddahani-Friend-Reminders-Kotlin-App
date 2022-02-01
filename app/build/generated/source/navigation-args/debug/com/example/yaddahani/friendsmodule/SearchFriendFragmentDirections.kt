package com.example.yaddahani.friendsmodule

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R
import com.example.yaddahani.models.SearchUserModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SearchFriendFragmentDirections private constructor() {
  private data class ActionSearchFriendFragmentToSendFriendRequestFragment(
    public val searchUsers: SearchUserModel
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_searchFriendFragment_to_sendFriendRequestFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
          result.putParcelable("searchUsers", this.searchUsers as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
          result.putSerializable("searchUsers", this.searchUsers as Serializable)
        } else {
          throw UnsupportedOperationException(SearchUserModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionSearchFriendFragmentToFriendListFragmentId(): NavDirections =
        ActionOnlyNavDirections(R.id.action_searchFriendFragment_to_friendListFragmentId)

    public fun actionSearchFriendFragmentToSendFriendRequestFragment(searchUsers: SearchUserModel):
        NavDirections = ActionSearchFriendFragmentToSendFriendRequestFragment(searchUsers)
  }
}
