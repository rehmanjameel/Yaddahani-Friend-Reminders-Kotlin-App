package com.example.yaddahani.roomDB;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\u00032\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0013H\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\'J!\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/yaddahani/roomDB/ReminderDao;", "", "addReminder", "", "reminder", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "(Lcom/example/yaddahani/models/FriendsRemindersListModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addReminders", "reminders", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReminder", "deleteReminderId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReminders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllReminders", "Landroidx/lifecycle/LiveData;", "", "getArchivedReminders", "archived", "", "reminderArchived", "id", "(ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ReminderDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object addReminders(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> reminders, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object addReminder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.models.FriendsRemindersListModel reminder, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from receivedRemindersTable order by reminderTableId ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getAllReminders();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from receivedRemindersTable where isArchived = :archived order by reminderTableId DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getArchivedReminders(boolean archived);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete from receivedRemindersTable")
    public abstract java.lang.Object deleteReminders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete from receivedRemindersTable where reminderId = :deleteReminderId")
    public abstract java.lang.Object deleteReminder(int deleteReminderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Update receivedRemindersTable set isArchived = :archived where reminderId = :id")
    public abstract java.lang.Object reminderArchived(boolean archived, int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}