package com.example.yaddahani.mainfragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.yaddahani.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToRegistrationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_registrationFragment)
  }
}
