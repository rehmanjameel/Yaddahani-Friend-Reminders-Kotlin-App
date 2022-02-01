package com.example.yaddahani.mainfragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class EmailVerificationFragmentDirections private constructor() {
  public companion object {
    public fun actionEmailVerificationFragmentToRegistrationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_emailVerificationFragment_to_registrationFragment)

    public fun actionEmailVerificationFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_emailVerificationFragment_to_loginFragment)
  }
}
