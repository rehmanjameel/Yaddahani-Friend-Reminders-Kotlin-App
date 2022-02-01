// Generated by view binder compiler. Do not edit!
package com.example.yaddahani.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.yaddahani.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView deleteProfileIconId;

  @NonNull
  public final CircleImageView profileImageId;

  @NonNull
  public final TextView profileNameId;

  @NonNull
  public final TextView profilePhoneId;

  @NonNull
  public final ProgressBar profileProgressBar;

  @NonNull
  public final TextView profileUserNameId;

  @NonNull
  public final ImageView updateUserIconId;

  private FragmentProfileBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView deleteProfileIconId, @NonNull CircleImageView profileImageId,
      @NonNull TextView profileNameId, @NonNull TextView profilePhoneId,
      @NonNull ProgressBar profileProgressBar, @NonNull TextView profileUserNameId,
      @NonNull ImageView updateUserIconId) {
    this.rootView = rootView;
    this.deleteProfileIconId = deleteProfileIconId;
    this.profileImageId = profileImageId;
    this.profileNameId = profileNameId;
    this.profilePhoneId = profilePhoneId;
    this.profileProgressBar = profileProgressBar;
    this.profileUserNameId = profileUserNameId;
    this.updateUserIconId = updateUserIconId;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.deleteProfileIconId;
      ImageView deleteProfileIconId = ViewBindings.findChildViewById(rootView, id);
      if (deleteProfileIconId == null) {
        break missingId;
      }

      id = R.id.profileImageId;
      CircleImageView profileImageId = ViewBindings.findChildViewById(rootView, id);
      if (profileImageId == null) {
        break missingId;
      }

      id = R.id.profileNameId;
      TextView profileNameId = ViewBindings.findChildViewById(rootView, id);
      if (profileNameId == null) {
        break missingId;
      }

      id = R.id.profilePhoneId;
      TextView profilePhoneId = ViewBindings.findChildViewById(rootView, id);
      if (profilePhoneId == null) {
        break missingId;
      }

      id = R.id.profileProgress_Bar;
      ProgressBar profileProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (profileProgressBar == null) {
        break missingId;
      }

      id = R.id.profileUserNameId;
      TextView profileUserNameId = ViewBindings.findChildViewById(rootView, id);
      if (profileUserNameId == null) {
        break missingId;
      }

      id = R.id.updateUserIconId;
      ImageView updateUserIconId = ViewBindings.findChildViewById(rootView, id);
      if (updateUserIconId == null) {
        break missingId;
      }

      return new FragmentProfileBinding((RelativeLayout) rootView, deleteProfileIconId,
          profileImageId, profileNameId, profilePhoneId, profileProgressBar, profileUserNameId,
          updateUserIconId);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
