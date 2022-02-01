package com.example.yaddahani.roomDB;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0017j\b\u0012\u0004\u0012\u00020\n`\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/example/yaddahani/roomDB/ReminderRepository;", "", "friendReminderDao", "Lcom/example/yaddahani/roomDB/ReminderDao;", "(Lcom/example/yaddahani/roomDB/ReminderDao;)V", "archive", "", "archivedReminders", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "getArchivedReminders", "()Landroidx/lifecycle/LiveData;", "gettingAllReminders", "getGettingAllReminders", "unArchive", "unArchivedReminder", "getUnArchivedReminder", "adReminder", "", "remindersListModel", "(Lcom/example/yaddahani/models/FriendsRemindersListModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addReminders", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllReminders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReminder", "reminderId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reminderIsArchived", "archived", "id", "(ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ReminderRepository {
    private final com.example.yaddahani.roomDB.ReminderDao friendReminderDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> gettingAllReminders = null;
    private final boolean unArchive = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> unArchivedReminder = null;
    private final boolean archive = true;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> archivedReminders = null;
    
    public ReminderRepository(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.roomDB.ReminderDao friendReminderDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getGettingAllReminders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getUnArchivedReminder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.yaddahani.models.FriendsRemindersListModel>> getArchivedReminders() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addReminders(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> remindersListModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object adReminder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.models.FriendsRemindersListModel remindersListModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllReminders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteReminder(int reminderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object reminderIsArchived(boolean archived, int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}