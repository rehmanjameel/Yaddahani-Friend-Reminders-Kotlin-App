package com.example.yaddahani.reminders

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.yaddahani.models.FriendsRemindersListModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ShowReceivedRemindersFragmentArgs(
  public val receivedReminders: FriendsRemindersListModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
      result.putParcelable("receivedReminders", this.receivedReminders as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
      result.putSerializable("receivedReminders", this.receivedReminders as Serializable)
    } else {
      throw UnsupportedOperationException(FriendsRemindersListModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
      result.set("receivedReminders", this.receivedReminders as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
      result.set("receivedReminders", this.receivedReminders as Serializable)
    } else {
      throw UnsupportedOperationException(FriendsRemindersListModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ShowReceivedRemindersFragmentArgs {
      bundle.setClassLoader(ShowReceivedRemindersFragmentArgs::class.java.classLoader)
      val __receivedReminders : FriendsRemindersListModel?
      if (bundle.containsKey("receivedReminders")) {
        if (Parcelable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
          __receivedReminders = bundle.get("receivedReminders") as FriendsRemindersListModel?
        } else {
          throw UnsupportedOperationException(FriendsRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__receivedReminders == null) {
          throw IllegalArgumentException("Argument \"receivedReminders\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"receivedReminders\" is missing and does not have an android:defaultValue")
      }
      return ShowReceivedRemindersFragmentArgs(__receivedReminders)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        ShowReceivedRemindersFragmentArgs {
      val __receivedReminders : FriendsRemindersListModel?
      if (savedStateHandle.contains("receivedReminders")) {
        if (Parcelable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java) ||
            Serializable::class.java.isAssignableFrom(FriendsRemindersListModel::class.java)) {
          __receivedReminders =
              savedStateHandle.get<FriendsRemindersListModel?>("receivedReminders")
        } else {
          throw UnsupportedOperationException(FriendsRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__receivedReminders == null) {
          throw IllegalArgumentException("Argument \"receivedReminders\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"receivedReminders\" is missing and does not have an android:defaultValue")
      }
      return ShowReceivedRemindersFragmentArgs(__receivedReminders)
    }
  }
}
