package com.example.yaddahani.friendsmodule

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class SendFriendRequestFragmentDirections private constructor() {
  public companion object {
    public fun actionSendFriendRequestFragmentToSearchFriendFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_sendFriendRequestFragment_to_searchFriendFragment)
  }
}
