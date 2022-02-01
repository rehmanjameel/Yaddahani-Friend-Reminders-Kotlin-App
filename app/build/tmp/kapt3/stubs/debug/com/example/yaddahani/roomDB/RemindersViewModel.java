package com.example.yaddahani.roomDB;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0014j\b\u0012\u0004\u0012\u00020\b`\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/yaddahani/roomDB/RemindersViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "readAllReminders", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "getReadAllReminders", "()Landroidx/lifecycle/LiveData;", "reminderArchived", "getReminderArchived", "reminderUnArchived", "getReminderUnArchived", "repository", "Lcom/example/yaddahani/roomDB/ReminderRepository;", "addReminder", "", "friendsRemindersListModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addingReminder", "reminder", "deleteReceivedReminders", "deleteReminder", "reminderId", "", "updateReminderArchived", "reminderIsArchive", "", "id", "app_debug"})
public final class RemindersViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> readAllReminders = null;
    private final com.example.yaddahani.roomDB.ReminderRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> reminderArchived = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> reminderUnArchived = null;
    
    public RemindersViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getReadAllReminders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getReminderArchived() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getReminderUnArchived() {
        return null;
    }
    
    public final void addReminder(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> friendsRemindersListModel) {
    }
    
    public final void addingReminder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.models.FriendsRemindersListModel reminder) {
    }
    
    public final void deleteReceivedReminders() {
    }
    
    public final void deleteReminder(int reminderId) {
    }
    
    public final void updateReminderArchived(boolean reminderIsArchive, int id) {
    }
}