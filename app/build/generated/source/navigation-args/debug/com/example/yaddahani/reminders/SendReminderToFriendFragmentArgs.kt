package com.example.yaddahani.reminders

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.yaddahani.models.FriendModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SendReminderToFriendFragmentArgs(
  public val friendsList: FriendModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java)) {
      result.set("friendsList", this.friendsList as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
      result.set("friendsList", this.friendsList as Serializable)
    } else {
      throw UnsupportedOperationException(FriendModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SendReminderToFriendFragmentArgs {
      bundle.setClassLoader(SendReminderToFriendFragmentArgs::class.java.classLoader)
      val __friendsList : FriendModel?
      if (bundle.containsKey("friendsList")) {
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          __friendsList = bundle.get("friendsList") as FriendModel?
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__friendsList == null) {
          throw IllegalArgumentException("Argument \"friendsList\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"friendsList\" is missing and does not have an android:defaultValue")
      }
      return SendReminderToFriendFragmentArgs(__friendsList)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        SendReminderToFriendFragmentArgs {
      val __friendsList : FriendModel?
      if (savedStateHandle.contains("friendsList")) {
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          __friendsList = savedStateHandle.get<FriendModel?>("friendsList")
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__friendsList == null) {
          throw IllegalArgumentException("Argument \"friendsList\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"friendsList\" is missing and does not have an android:defaultValue")
      }
      return SendReminderToFriendFragmentArgs(__friendsList)
    }
  }
}
