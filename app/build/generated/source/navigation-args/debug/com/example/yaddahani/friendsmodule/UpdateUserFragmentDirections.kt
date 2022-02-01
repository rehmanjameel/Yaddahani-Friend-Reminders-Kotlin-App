package com.example.yaddahani.friendsmodule

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class UpdateUserFragmentDirections private constructor() {
  public companion object {
    public fun actionUpdateUserFragmentToProfileFragmentId(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateUserFragment_to_profileFragmentId)
  }
}
