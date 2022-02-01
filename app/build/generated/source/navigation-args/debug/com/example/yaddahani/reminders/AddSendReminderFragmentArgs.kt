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

public data class AddSendReminderFragmentArgs(
  public val sendReminderToFriend: FriendModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java)) {
      result.putParcelable("sendReminderToFriend", this.sendReminderToFriend as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
      result.putSerializable("sendReminderToFriend", this.sendReminderToFriend as Serializable)
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
      result.set("sendReminderToFriend", this.sendReminderToFriend as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
      result.set("sendReminderToFriend", this.sendReminderToFriend as Serializable)
    } else {
      throw UnsupportedOperationException(FriendModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AddSendReminderFragmentArgs {
      bundle.setClassLoader(AddSendReminderFragmentArgs::class.java.classLoader)
      val __sendReminderToFriend : FriendModel?
      if (bundle.containsKey("sendReminderToFriend")) {
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          __sendReminderToFriend = bundle.get("sendReminderToFriend") as FriendModel?
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sendReminderToFriend == null) {
          throw IllegalArgumentException("Argument \"sendReminderToFriend\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sendReminderToFriend\" is missing and does not have an android:defaultValue")
      }
      return AddSendReminderFragmentArgs(__sendReminderToFriend)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        AddSendReminderFragmentArgs {
      val __sendReminderToFriend : FriendModel?
      if (savedStateHandle.contains("sendReminderToFriend")) {
        if (Parcelable::class.java.isAssignableFrom(FriendModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendModel::class.java)) {
          __sendReminderToFriend = savedStateHandle.get<FriendModel?>("sendReminderToFriend")
        } else {
          throw UnsupportedOperationException(FriendModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sendReminderToFriend == null) {
          throw IllegalArgumentException("Argument \"sendReminderToFriend\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sendReminderToFriend\" is missing and does not have an android:defaultValue")
      }
      return AddSendReminderFragmentArgs(__sendReminderToFriend)
    }
  }
}
