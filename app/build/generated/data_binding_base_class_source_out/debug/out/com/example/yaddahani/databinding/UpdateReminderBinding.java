// Generated by view binder compiler. Do not edit!
package com.example.yaddahani.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.yaddahani.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class UpdateReminderBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText updateReminderDatePickerETId;

  @NonNull
  public final TextInputEditText updateReminderTextETId;

  @NonNull
  public final TimePicker updateReminderTimePickerId;

  @NonNull
  public final TextView updateTimeTextView;

  private UpdateReminderBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText updateReminderDatePickerETId,
      @NonNull TextInputEditText updateReminderTextETId,
      @NonNull TimePicker updateReminderTimePickerId, @NonNull TextView updateTimeTextView) {
    this.rootView = rootView;
    this.updateReminderDatePickerETId = updateReminderDatePickerETId;
    this.updateReminderTextETId = updateReminderTextETId;
    this.updateReminderTimePickerId = updateReminderTimePickerId;
    this.updateTimeTextView = updateTimeTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UpdateReminderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UpdateReminderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.update_reminder, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UpdateReminderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.updateReminderDatePickerETId;
      EditText updateReminderDatePickerETId = ViewBindings.findChildViewById(rootView, id);
      if (updateReminderDatePickerETId == null) {
        break missingId;
      }

      id = R.id.updateReminderTextETId;
      TextInputEditText updateReminderTextETId = ViewBindings.findChildViewById(rootView, id);
      if (updateReminderTextETId == null) {
        break missingId;
      }

      id = R.id.updateReminderTimePickerId;
      TimePicker updateReminderTimePickerId = ViewBindings.findChildViewById(rootView, id);
      if (updateReminderTimePickerId == null) {
        break missingId;
      }

      id = R.id.updateTimeTextView;
      TextView updateTimeTextView = ViewBindings.findChildViewById(rootView, id);
      if (updateTimeTextView == null) {
        break missingId;
      }

      return new UpdateReminderBinding((RelativeLayout) rootView, updateReminderDatePickerETId,
          updateReminderTextETId, updateReminderTimePickerId, updateTimeTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}