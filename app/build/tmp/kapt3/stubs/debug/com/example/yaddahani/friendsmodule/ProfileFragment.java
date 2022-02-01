package com.example.yaddahani.friendsmodule;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SetTextI18n"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/example/yaddahani/friendsmodule/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "firstLastName", "Landroid/widget/TextView;", "getFirstLastName", "()Landroid/widget/TextView;", "setFirstLastName", "(Landroid/widget/TextView;)V", "personImage", "Lde/hdodenhof/circleimageview/CircleImageView;", "getPersonImage", "()Lde/hdodenhof/circleimageview/CircleImageView;", "setPersonImage", "(Lde/hdodenhof/circleimageview/CircleImageView;)V", "personUserName", "getPersonUserName", "setPersonUserName", "phoneNo", "getPhoneNo", "setPhoneNo", "popUpMenuIcon", "Landroid/widget/ImageView;", "getPopUpMenuIcon", "()Landroid/widget/ImageView;", "setPopUpMenuIcon", "(Landroid/widget/ImageView;)V", "progressBar", "Landroid/widget/ProgressBar;", "updateIconImage", "deleteAccount", "", "getProfile", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showPopup", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    private android.widget.ProgressBar progressBar;
    private android.widget.ImageView updateIconImage;
    public android.widget.TextView personUserName;
    public android.widget.TextView firstLastName;
    public android.widget.TextView phoneNo;
    public de.hdodenhof.circleimageview.CircleImageView personImage;
    public android.widget.ImageView popUpMenuIcon;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPersonUserName() {
        return null;
    }
    
    public final void setPersonUserName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getFirstLastName() {
        return null;
    }
    
    public final void setFirstLastName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPhoneNo() {
        return null;
    }
    
    public final void setPhoneNo(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.hdodenhof.circleimageview.CircleImageView getPersonImage() {
        return null;
    }
    
    public final void setPersonImage(@org.jetbrains.annotations.NotNull()
    de.hdodenhof.circleimageview.CircleImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPopUpMenuIcon() {
        return null;
    }
    
    public final void setPopUpMenuIcon(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
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
    
    private final void showPopup() {
    }
    
    private final void getProfile() {
    }
    
    private final void deleteAccount() {
    }
}