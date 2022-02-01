package com.example.yaddahani.friendsmodule

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.yaddahani.models.SearchUserModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SendFriendRequestFragmentArgs(
  public val searchUsers: SearchUserModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
      result.set("searchUsers", this.searchUsers as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
      result.set("searchUsers", this.searchUsers as Serializable)
    } else {
      throw UnsupportedOperationException(SearchUserModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SendFriendRequestFragmentArgs {
      bundle.setClassLoader(SendFriendRequestFragmentArgs::class.java.classLoader)
      val __searchUsers : SearchUserModel?
      if (bundle.containsKey("searchUsers")) {
        if (Parcelable::class.java.isAssignableFrom(SearchUserModel::class.java) ||
            Serializable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
          __searchUsers = bundle.get("searchUsers") as SearchUserModel?
        } else {
          throw UnsupportedOperationException(SearchUserModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__searchUsers == null) {
          throw IllegalArgumentException("Argument \"searchUsers\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"searchUsers\" is missing and does not have an android:defaultValue")
      }
      return SendFriendRequestFragmentArgs(__searchUsers)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        SendFriendRequestFragmentArgs {
      val __searchUsers : SearchUserModel?
      if (savedStateHandle.contains("searchUsers")) {
        if (Parcelable::class.java.isAssignableFrom(SearchUserModel::class.java) ||
            Serializable::class.java.isAssignableFrom(SearchUserModel::class.java)) {
          __searchUsers = savedStateHandle.get<SearchUserModel?>("searchUsers")
        } else {
          throw UnsupportedOperationException(SearchUserModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__searchUsers == null) {
          throw IllegalArgumentException("Argument \"searchUsers\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"searchUsers\" is missing and does not have an android:defaultValue")
      }
      return SendFriendRequestFragmentArgs(__searchUsers)
    }
  }
}
