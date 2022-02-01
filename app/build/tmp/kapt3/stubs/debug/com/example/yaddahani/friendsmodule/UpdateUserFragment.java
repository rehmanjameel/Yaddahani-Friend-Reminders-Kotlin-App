package com.example.yaddahani.friendsmodule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001dH\u0003J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/yaddahani/friendsmodule/UpdateUserFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "galleryActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "imageRealPath", "", "imageUri", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "setImageUri", "(Landroid/net/Uri;)V", "radioButtonText", "radioButtons", "Landroid/widget/RadioButton;", "radioGroup", "Landroid/widget/RadioGroup;", "realPathUtil", "Lcom/example/yaddahani/RealPathUtils;", "updateBackArrowImageView", "Landroid/widget/ImageView;", "getRadioButtonText", "", "imagePath", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "pickImage", "showToast", "message", "updateProfile", "app_debug"})
public final class UpdateUserFragment extends androidx.fragment.app.Fragment {
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    private android.widget.ImageView updateBackArrowImageView;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private java.lang.String radioButtonText = "";
    private android.widget.RadioGroup radioGroup;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageUri;
    private android.widget.RadioButton radioButtons;
    private com.example.yaddahani.RealPathUtils realPathUtil;
    private java.lang.String imageRealPath = "";
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> galleryActivityResultLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public UpdateUserFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImageUri() {
        return null;
    }
    
    public final void setImageUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showToast(java.lang.String message) {
    }
    
    @android.annotation.SuppressLint(value = {"WrongConstant"})
    private final void pickImage() {
    }
    
    private final void imagePath() {
    }
    
    private final void getRadioButtonText() {
    }
    
    private final void updateProfile() {
    }
}