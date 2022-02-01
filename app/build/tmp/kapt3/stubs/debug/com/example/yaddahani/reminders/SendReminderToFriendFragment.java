package com.example.yaddahani.reminders;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@android.annotation.SuppressLint(value = {"SetTextI18n", "SimpleDateFormat", "NotifyDataSetChanged", "StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0002J@\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\f2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`&2\u0006\u0010\'\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020\u001fH\u0002J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u001fH\u0016J\u001a\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\u0016\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/example/yaddahani/reminders/SendReminderToFriendFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "getAppGlobals", "()Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "friendListFragment", "Lcom/example/yaddahani/friendsmodule/FriendListFragment;", "i", "", "moreActionButton", "Landroid/widget/ImageView;", "getMoreActionButton", "()Landroid/widget/ImageView;", "setMoreActionButton", "(Landroid/widget/ImageView;)V", "progressBar", "Landroid/widget/ProgressBar;", "reminderArgs", "Lcom/example/yaddahani/reminders/SendReminderToFriendFragmentArgs;", "getReminderArgs", "()Lcom/example/yaddahani/reminders/SendReminderToFriendFragmentArgs;", "reminderArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "sentReminderModelArray", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/SentRemindersListModel;", "deleteReminderAPI", "", "reminder", "deleteUserDialog", "activity", "Landroid/app/Activity;", "position", "sentReminderArray", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/example/yaddahani/adapters/SentRemindersAdapter;", "getAllSentFriendsReminders", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "showPopup", "context", "Landroid/content/Context;", "updateReminderDialog", "sentRemindersListModel", "Companion", "app_debug"})
public final class SendReminderToFriendFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.yaddahani.reminders.SendReminderToFriendFragment.Companion Companion = null;
    private static androidx.recyclerview.widget.RecyclerView recyclerView;
    public static com.example.yaddahani.adapters.SentRemindersAdapter sentReminderAdapter;
    private android.widget.ProgressBar progressBar;
    private final com.example.yaddahani.friendsmodule.FriendListFragment friendListFragment = null;
    private int i = 0;
    public android.widget.ImageView moreActionButton;
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    private final java.util.ArrayList<com.example.yaddahani.models.SentRemindersListModel> sentReminderModelArray = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private final androidx.navigation.NavArgsLazy reminderArgs$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public SendReminderToFriendFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getMoreActionButton() {
        return null;
    }
    
    public final void setMoreActionButton(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.yaddahani.AppGlobals getAppGlobals() {
        return null;
    }
    
    private final com.example.yaddahani.reminders.SendReminderToFriendFragmentArgs getReminderArgs() {
        return null;
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
    
    private final void showPopup(android.content.Context context) {
    }
    
    private final void getAllSentFriendsReminders() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void deleteUserDialog(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.models.SentRemindersListModel reminder, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.SentRemindersListModel> sentReminderArray, @org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.SentRemindersAdapter adapter) {
    }
    
    private final void deleteReminderAPI(com.example.yaddahani.models.SentRemindersListModel reminder) {
    }
    
    public final void updateReminderDialog(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.models.SentRemindersListModel sentRemindersListModel, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/example/yaddahani/reminders/SendReminderToFriendFragment$Companion;", "", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sentReminderAdapter", "Lcom/example/yaddahani/adapters/SentRemindersAdapter;", "getSentReminderAdapter", "()Lcom/example/yaddahani/adapters/SentRemindersAdapter;", "setSentReminderAdapter", "(Lcom/example/yaddahani/adapters/SentRemindersAdapter;)V", "onExpand", "", "position", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.yaddahani.adapters.SentRemindersAdapter getSentReminderAdapter() {
            return null;
        }
        
        public final void setSentReminderAdapter(@org.jetbrains.annotations.NotNull()
        com.example.yaddahani.adapters.SentRemindersAdapter p0) {
        }
        
        public final void onExpand(int position) {
        }
    }
}