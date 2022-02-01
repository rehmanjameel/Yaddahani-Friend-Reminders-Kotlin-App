package com.example.yaddahani.adapters;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0017J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/yaddahani/adapters/SentRemindersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/yaddahani/adapters/SentRemindersAdapter$SentViewHolder;", "activity", "Landroid/app/Activity;", "sentReminderModel", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/SentRemindersListModel;", "Lkotlin/collections/ArrayList;", "(Landroid/app/Activity;Ljava/util/ArrayList;)V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "sendReminderToFriendFragment", "Lcom/example/yaddahani/reminders/SendReminderToFriendFragment;", "sentReminderActivity", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SentViewHolder", "app_debug"})
public final class SentRemindersAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.yaddahani.adapters.SentRemindersAdapter.SentViewHolder> {
    private final java.util.ArrayList<com.example.yaddahani.models.SentRemindersListModel> sentReminderModel = null;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private final android.app.Activity sentReminderActivity = null;
    private final com.example.yaddahani.reminders.SendReminderToFriendFragment sendReminderToFriendFragment = null;
    
    public SentRemindersAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.SentRemindersListModel> sentReminderModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.yaddahani.adapters.SentRemindersAdapter.SentViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.SentRemindersAdapter.SentViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/yaddahani/adapters/SentRemindersAdapter$SentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "sentView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class SentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public SentViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View sentView) {
            super(null);
        }
    }
}