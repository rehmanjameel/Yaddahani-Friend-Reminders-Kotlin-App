package com.example.yaddahani.friendsmodule;

import java.lang.System;

@android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0002J6\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001a2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001cj\b\u0012\u0004\u0012\u00020\u001f`&2\u0006\u0010\'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020)J.\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001a2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001cj\b\u0012\u0004\u0012\u00020\u001f`&2\u0006\u0010\'\u001a\u00020\nJ\u000e\u0010,\u001a\u00020#2\u0006\u0010(\u001a\u00020)J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0016J\b\u00107\u001a\u00020#H\u0016J\u001a\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/example/yaddahani/friendsmodule/FriendListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterFriendList", "Lcom/example/yaddahani/adapters/FriendListAdapter;", "getAdapterFriendList", "()Lcom/example/yaddahani/adapters/FriendListAdapter;", "setAdapterFriendList", "(Lcom/example/yaddahani/adapters/FriendListAdapter;)V", "adapterPendingRequest", "Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter;", "getAdapterPendingRequest", "()Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter;", "setAdapterPendingRequest", "(Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter;)V", "alarmReceiver", "Lcom/example/yaddahani/AlarmReceiver;", "getAlarmReceiver", "()Lcom/example/yaddahani/AlarmReceiver;", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "floatingActionButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "i", "", "modelFriendList", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendModel;", "modelPendingRequest", "Lcom/example/yaddahani/models/SearchUserModel;", "progressBar", "Landroid/widget/ProgressBar;", "acceptRequest", "", "position", "friendsModelArray", "Lkotlin/collections/ArrayList;", "adapter", "context", "Landroid/content/Context;", "addedFriendsList", "declineRequest", "getFriendRequest", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStop", "onViewCreated", "view", "Companion", "app_debug"})
public final class FriendListFragment extends androidx.fragment.app.Fragment {
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.yaddahani.friendsmodule.FriendListFragment.Companion Companion = null;
    private static boolean isForeGround = false;
    public static androidx.recyclerview.widget.RecyclerView recyclerPendingRequest;
    public static androidx.recyclerview.widget.RecyclerView recyclerViewFriendList;
    private android.widget.ProgressBar progressBar;
    private int i = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.yaddahani.AlarmReceiver alarmReceiver = null;
    private com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton;
    public com.example.yaddahani.adapters.FriendsPendingRequestAdapter adapterPendingRequest;
    public com.example.yaddahani.adapters.FriendListAdapter adapterFriendList;
    private final java.util.ArrayList<com.example.yaddahani.models.SearchUserModel> modelPendingRequest = null;
    private final java.util.ArrayList<com.example.yaddahani.models.FriendModel> modelFriendList = null;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private java.util.HashMap _$_findViewCache;
    
    public FriendListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.yaddahani.AlarmReceiver getAlarmReceiver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.yaddahani.adapters.FriendsPendingRequestAdapter getAdapterPendingRequest() {
        return null;
    }
    
    public final void setAdapterPendingRequest(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendsPendingRequestAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.yaddahani.adapters.FriendListAdapter getAdapterFriendList() {
        return null;
    }
    
    public final void setAdapterFriendList(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendListAdapter p0) {
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
    
    public final void addedFriendsList(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void getFriendRequest(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void acceptRequest(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.SearchUserModel> friendsModelArray, @org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendsPendingRequestAdapter adapter, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void declineRequest(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.SearchUserModel> friendsModelArray, @org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendsPendingRequestAdapter adapter) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/example/yaddahani/friendsmodule/FriendListFragment$Companion;", "", "()V", "isForeGround", "", "()Z", "setForeGround", "(Z)V", "recyclerPendingRequest", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerPendingRequest", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerPendingRequest", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewFriendList", "getRecyclerViewFriendList", "setRecyclerViewFriendList", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isForeGround() {
            return false;
        }
        
        public final void setForeGround(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRecyclerPendingRequest() {
            return null;
        }
        
        public final void setRecyclerPendingRequest(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRecyclerViewFriendList() {
            return null;
        }
        
        public final void setRecyclerViewFriendList(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
    }
}