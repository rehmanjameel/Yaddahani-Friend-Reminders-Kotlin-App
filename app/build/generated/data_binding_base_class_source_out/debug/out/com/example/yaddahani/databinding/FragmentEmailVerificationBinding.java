// Generated by view binder compiler. Do not edit!
package com.example.yaddahani.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.yaddahani.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEmailVerificationBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView countDownTimerId;

  @NonNull
  public final Button emailVerificationButtonId;

  @NonNull
  public final TextInputEditText otpVerifyETId;

  @NonNull
  public final Button resendOTPButtonId;

  @NonNull
  public final TextView verificationEmailId;

  @NonNull
  public final ImageView verifyEmailBackArrowId;

  private FragmentEmailVerificationBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView countDownTimerId, @NonNull Button emailVerificationButtonId,
      @NonNull TextInputEditText otpVerifyETId, @NonNull Button resendOTPButtonId,
      @NonNull TextView verificationEmailId, @NonNull ImageView verifyEmailBackArrowId) {
    this.rootView = rootView;
    this.countDownTimerId = countDownTimerId;
    this.emailVerificationButtonId = emailVerificationButtonId;
    this.otpVerifyETId = otpVerifyETId;
    this.resendOTPButtonId = resendOTPButtonId;
    this.verificationEmailId = verificationEmailId;
    this.verifyEmailBackArrowId = verifyEmailBackArrowId;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEmailVerificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEmailVerificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_email_verification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEmailVerificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.countDownTimerId;
      TextView countDownTimerId = ViewBindings.findChildViewById(rootView, id);
      if (countDownTimerId == null) {
        break missingId;
      }

      id = R.id.emailVerificationButtonId;
      Button emailVerificationButtonId = ViewBindings.findChildViewById(rootView, id);
      if (emailVerificationButtonId == null) {
        break missingId;
      }

      id = R.id.otpVerifyETId;
      TextInputEditText otpVerifyETId = ViewBindings.findChildViewById(rootView, id);
      if (otpVerifyETId == null) {
        break missingId;
      }

      id = R.id.resendOTPButtonId;
      Button resendOTPButtonId = ViewBindings.findChildViewById(rootView, id);
      if (resendOTPButtonId == null) {
        break missingId;
      }

      id = R.id.verificationEmailId;
      TextView verificationEmailId = ViewBindings.findChildViewById(rootView, id);
      if (verificationEmailId == null) {
        break missingId;
      }

      id = R.id.verifyEmailBackArrowId;
      ImageView verifyEmailBackArrowId = ViewBindings.findChildViewById(rootView, id);
      if (verifyEmailBackArrowId == null) {
        break missingId;
      }

      return new FragmentEmailVerificationBinding((RelativeLayout) rootView, countDownTimerId,
          emailVerificationButtonId, otpVerifyETId, resendOTPButtonId, verificationEmailId,
          verifyEmailBackArrowId);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}