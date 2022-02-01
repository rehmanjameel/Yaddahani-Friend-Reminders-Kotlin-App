package com.example.yaddahani.adapters;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SimpleDateFormat", "NotifyDataSetChanged", "SetTextI18n"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u001e\u0010\u0019\u001a\u00020\u00122\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/yaddahani/adapters/ArchivedRemindersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/yaddahani/adapters/ArchivedRemindersAdapter$ArchivedRemindersViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "application", "Landroid/app/Application;", "archivedRemindersArrayList", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "friendViewModel", "Lcom/example/yaddahani/roomDB/RemindersViewModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setReminderData", "reminders", "Lkotlin/collections/ArrayList;", "ArchivedRemindersViewHolder", "app_debug"})
public final class ArchivedRemindersAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.yaddahani.adapters.ArchivedRemindersAdapter.ArchivedRemindersViewHolder> {
    private java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> archivedRemindersArrayList;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private com.example.yaddahani.roomDB.RemindersViewModel friendViewModel;
    private final android.app.Application application = null;
    
    public ArchivedRemindersAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.yaddahani.adapters.ArchivedRemindersAdapter.ArchivedRemindersViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.ArchivedRemindersAdapter.ArchivedRemindersViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setReminderData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> reminders) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/yaddahani/adapters/ArchivedRemindersAdapter$ArchivedRemindersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "archivedView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class ArchivedRemindersViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ArchivedRemindersViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View archivedView) {
            super(null);
        }
    }
}