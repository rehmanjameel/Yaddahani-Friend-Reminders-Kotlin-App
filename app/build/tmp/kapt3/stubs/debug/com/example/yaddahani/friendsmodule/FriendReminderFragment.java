package com.example.yaddahani.friendsmodule;

import java.lang.System;

@android.annotation.SuppressLint(value = {"NotifyDataSetChanged", "StaticFieldLeak"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/yaddahani/friendsmodule/FriendReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "actionMoreButton", "Landroid/widget/ImageView;", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "getReminderListModel", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "i", "", "progressBar", "Landroid/widget/ProgressBar;", "getAllFriendsReminders", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "showPopup", "Companion", "app_debug"})
public final class FriendReminderFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.yaddahani.friendsmodule.FriendReminderFragment.Companion Companion = null;
    private static boolean onForeGround = false;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderId = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderFromName = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderToName = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderText = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderDate = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String friendReminderStatus = "";
    public static androidx.recyclerview.widget.RecyclerView recyclerView;
    private static com.example.yaddahani.roomDB.RemindersViewModel remindersViewModel;
    private static com.example.yaddahani.adapters.FriendsRemindersListAdapter getReminderListAdapter;
    private static java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> getRemindersDBList;
    private static com.example.yaddahani.models.FriendsRemindersListModel reminder;
    private static java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> remindersListModel;
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    private android.widget.ProgressBar progressBar;
    private int i = 0;
    private android.widget.ImageView actionMoreButton;
    private final java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> getReminderListModel = null;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private java.util.HashMap _$_findViewCache;
    
    public FriendReminderFragment() {
        super();
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void showPopup() {
    }
    
    public final void getAllFriendsReminders() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/example/yaddahani/friendsmodule/FriendReminderFragment$Companion;", "", "()V", "friendReminderDate", "", "getFriendReminderDate", "()Ljava/lang/String;", "setFriendReminderDate", "(Ljava/lang/String;)V", "friendReminderFromName", "getFriendReminderFromName", "setFriendReminderFromName", "friendReminderId", "getFriendReminderId", "setFriendReminderId", "friendReminderStatus", "getFriendReminderStatus", "setFriendReminderStatus", "friendReminderText", "getFriendReminderText", "setFriendReminderText", "friendReminderToName", "getFriendReminderToName", "setFriendReminderToName", "getReminderListAdapter", "Lcom/example/yaddahani/adapters/FriendsRemindersListAdapter;", "getRemindersDBList", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "onForeGround", "", "getOnForeGround", "()Z", "setOnForeGround", "(Z)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "reminder", "remindersListModel", "remindersViewModel", "Lcom/example/yaddahani/roomDB/RemindersViewModel;", "onExpand", "", "position", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getOnForeGround() {
            return false;
        }
        
        public final void setOnForeGround(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderId() {
            return null;
        }
        
        public final void setFriendReminderId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderFromName() {
            return null;
        }
        
        public final void setFriendReminderFromName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderToName() {
            return null;
        }
        
        public final void setFriendReminderToName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderText() {
            return null;
        }
        
        public final void setFriendReminderText(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderDate() {
            return null;
        }
        
        public final void setFriendReminderDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFriendReminderStatus() {
            return null;
        }
        
        public final void setFriendReminderStatus(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
            return null;
        }
        
        public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
        
        public final void onExpand(int position) {
        }
    }
}