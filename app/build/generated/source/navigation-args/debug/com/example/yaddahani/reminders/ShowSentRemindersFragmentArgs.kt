package com.example.yaddahani.reminders

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.yaddahani.models.SentRemindersListModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ShowSentRemindersFragmentArgs(
  public val sentReminders: SentRemindersListModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
      result.putParcelable("sentReminders", this.sentReminders as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
      result.putSerializable("sentReminders", this.sentReminders as Serializable)
    } else {
      throw UnsupportedOperationException(SentRemindersListModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
      result.set("sentReminders", this.sentReminders as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
      result.set("sentReminders", this.sentReminders as Serializable)
    } else {
      throw UnsupportedOperationException(SentRemindersListModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ShowSentRemindersFragmentArgs {
      bundle.setClassLoader(ShowSentRemindersFragmentArgs::class.java.classLoader)
      val __sentReminders : SentRemindersListModel?
      if (bundle.containsKey("sentReminders")) {
        if (Parcelable::class.java.isAssignableFrom(SentRemindersListModel::class.java) ||
            Serializable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
          __sentReminders = bundle.get("sentReminders") as SentRemindersListModel?
        } else {
          throw UnsupportedOperationException(SentRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sentReminders == null) {
          throw IllegalArgumentException("Argument \"sentReminders\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sentReminders\" is missing and does not have an android:defaultValue")
      }
      return ShowSentRemindersFragmentArgs(__sentReminders)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        ShowSentRemindersFragmentArgs {
      val __sentReminders : SentRemindersListModel?
      if (savedStateHandle.contains("sentReminders")) {
        if (Parcelable::class.java.isAssignableFrom(SentRemindersListModel::class.java) ||
            Serializable::class.java.isAssignableFrom(SentRemindersListModel::class.java)) {
          __sentReminders = savedStateHandle.get<SentRemindersListModel?>("sentReminders")
        } else {
          throw UnsupportedOperationException(SentRemindersListModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sentReminders == null) {
          throw IllegalArgumentException("Argument \"sentReminders\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sentReminders\" is missing and does not have an android:defaultValue")
      }
      return ShowSentRemindersFragmentArgs(__sentReminders)
    }
  }
}
