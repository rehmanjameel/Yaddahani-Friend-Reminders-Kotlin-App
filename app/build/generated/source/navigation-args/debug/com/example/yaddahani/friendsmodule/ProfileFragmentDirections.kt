package com.example.yaddahani.friendsmodule

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileFragmentIdToUpdateUserFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragmentId_to_updateUserFragment)
  }
}
