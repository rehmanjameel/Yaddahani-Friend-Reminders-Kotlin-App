package com.example.yaddahani.adapters;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SimpleDateFormat", "SetTextI18n"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J \u0010\u001c\u001a\u00020\u00152\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u001eH\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/yaddahani/adapters/FriendsRemindersListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/yaddahani/adapters/FriendsRemindersListAdapter$RemindersViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "friendViewModel", "Lcom/example/yaddahani/roomDB/RemindersViewModel;", "friendsReminderModel", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "reminderContext", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setReminderData", "reminders", "Lkotlin/collections/ArrayList;", "RemindersViewHolder", "app_debug"})
public final class FriendsRemindersListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.yaddahani.adapters.FriendsRemindersListAdapter.RemindersViewHolder> {
    private java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> friendsReminderModel;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private final android.content.Context reminderContext = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    private com.example.yaddahani.roomDB.RemindersViewModel friendViewModel;
    
    public FriendsRemindersListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.yaddahani.adapters.FriendsRemindersListAdapter.RemindersViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendsRemindersListAdapter.RemindersViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setReminderData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> reminders) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/yaddahani/adapters/FriendsRemindersListAdapter$RemindersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "remindersView", "Landroid/view/View;", "(Landroid/view/View;)V", "statusText", "Landroid/widget/TextView;", "getStatusText", "()Landroid/widget/TextView;", "app_debug"})
    public static final class RemindersViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView statusText = null;
        
        public RemindersViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View remindersView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getStatusText() {
            return null;
        }
    }
}