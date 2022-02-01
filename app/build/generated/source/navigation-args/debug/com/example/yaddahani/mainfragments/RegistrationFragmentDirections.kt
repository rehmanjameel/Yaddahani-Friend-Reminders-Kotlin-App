package com.example.yaddahani.mainfragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class RegistrationFragmentDirections private constructor() {
  public companion object {
    public fun actionRegistrationFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registrationFragment_to_loginFragment)

    public fun actionRegistrationFragmentToEmailVerificationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registrationFragment_to_emailVerificationFragment)
  }
}
