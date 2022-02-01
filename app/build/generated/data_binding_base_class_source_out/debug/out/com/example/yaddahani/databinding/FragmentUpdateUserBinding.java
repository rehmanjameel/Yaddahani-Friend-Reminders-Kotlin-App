// Generated by view binder compiler. Do not edit!
package com.example.yaddahani.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.yaddahani.R;
import com.google.android.material.textfield.TextInputEditText;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUpdateUserBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RadioButton femaleRadioButtonId;

  @NonNull
  public final RadioButton maleRadioButtonId;

  @NonNull
  public final RadioButton ratherNotSayRadioButtonId;

  @NonNull
  public final ImageView updateBackArrowId;

  @NonNull
  public final TextInputEditText updateContactETId;

  @NonNull
  public final TextInputEditText updateFirstNameETId;

  @NonNull
  public final TextInputEditText updateLastNameETId;

  @NonNull
  public final Button updateProfileButtonId;

  @NonNull
  public final CircleImageView updateProfileImageView;

  @NonNull
  public final RadioGroup updateRadioGroupId;

  private FragmentUpdateUserBinding(@NonNull RelativeLayout rootView,
      @NonNull RadioButton femaleRadioButtonId, @NonNull RadioButton maleRadioButtonId,
      @NonNull RadioButton ratherNotSayRadioButtonId, @NonNull ImageView updateBackArrowId,
      @NonNull TextInputEditText updateContactETId, @NonNull TextInputEditText updateFirstNameETId,
      @NonNull TextInputEditText updateLastNameETId, @NonNull Button updateProfileButtonId,
      @NonNull CircleImageView updateProfileImageView, @NonNull RadioGroup updateRadioGroupId) {
    this.rootView = rootView;
    this.femaleRadioButtonId = femaleRadioButtonId;
    this.maleRadioButtonId = maleRadioButtonId;
    this.ratherNotSayRadioButtonId = ratherNotSayRadioButtonId;
    this.updateBackArrowId = updateBackArrowId;
    this.updateContactETId = updateContactETId;
    this.updateFirstNameETId = updateFirstNameETId;
    this.updateLastNameETId = updateLastNameETId;
    this.updateProfileButtonId = updateProfileButtonId;
    this.updateProfileImageView = updateProfileImageView;
    this.updateRadioGroupId = updateRadioGroupId;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUpdateUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUpdateUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_update_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUpdateUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.femaleRadioButtonId;
      RadioButton femaleRadioButtonId = ViewBindings.findChildViewById(rootView, id);
      if (femaleRadioButtonId == null) {
        break missingId;
      }

      id = R.id.maleRadioButtonId;
      RadioButton maleRadioButtonId = ViewBindings.findChildViewById(rootView, id);
      if (maleRadioButtonId == null) {
        break missingId;
      }

      id = R.id.ratherNotSayRadioButtonId;
      RadioButton ratherNotSayRadioButtonId = ViewBindings.findChildViewById(rootView, id);
      if (ratherNotSayRadioButtonId == null) {
        break missingId;
      }

      id = R.id.updateBackArrowId;
      ImageView updateBackArrowId = ViewBindings.findChildViewById(rootView, id);
      if (updateBackArrowId == null) {
        break missingId;
      }

      id = R.id.updateContactETId;
      TextInputEditText updateContactETId = ViewBindings.findChildViewById(rootView, id);
      if (updateContactETId == null) {
        break missingId;
      }

      id = R.id.updateFirstNameETId;
      TextInputEditText updateFirstNameETId = ViewBindings.findChildViewById(rootView, id);
      if (updateFirstNameETId == null) {
        break missingId;
      }

      id = R.id.updateLastNameETId;
      TextInputEditText updateLastNameETId = ViewBindings.findChildViewById(rootView, id);
      if (updateLastNameETId == null) {
        break missingId;
      }

      id = R.id.updateProfileButtonId;
      Button updateProfileButtonId = ViewBindings.findChildViewById(rootView, id);
      if (updateProfileButtonId == null) {
        break missingId;
      }

      id = R.id.updateProfileImageView;
      CircleImageView updateProfileImageView = ViewBindings.findChildViewById(rootView, id);
      if (updateProfileImageView == null) {
        break missingId;
      }

      id = R.id.updateRadioGroupId;
      RadioGroup updateRadioGroupId = ViewBindings.findChildViewById(rootView, id);
      if (updateRadioGroupId == null) {
        break missingId;
      }

      return new FragmentUpdateUserBinding((RelativeLayout) rootView, femaleRadioButtonId,
          maleRadioButtonId, ratherNotSayRadioButtonId, updateBackArrowId, updateContactETId,
          updateFirstNameETId, updateLastNameETId, updateProfileButtonId, updateProfileImageView,
          updateRadioGroupId);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}