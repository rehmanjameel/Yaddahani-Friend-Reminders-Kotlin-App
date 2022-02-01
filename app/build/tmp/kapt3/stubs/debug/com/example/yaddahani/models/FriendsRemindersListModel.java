package com.example.yaddahani.models;

import java.lang.System;

@androidx.room.Entity(tableName = "receivedRemindersTable")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\r\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000f\"\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/example/yaddahani/models/FriendsRemindersListModel;", "Ljava/io/Serializable;", "reminderTableId", "", "reminderId", "reminderText", "", "reminderDate", "reminderFrom", "reminderTo", "reminderStatus", "isExpand", "", "isArchived", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "()Z", "setArchived", "(Z)V", "setExpand", "getReminderDate", "()Ljava/lang/String;", "getReminderFrom", "getReminderId", "()I", "getReminderStatus", "getReminderTableId", "getReminderText", "getReminderTo", "app_debug"})
public final class FriendsRemindersListModel implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int reminderTableId = 0;
    private final int reminderId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reminderText = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reminderDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reminderFrom = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reminderTo = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reminderStatus = null;
    private boolean isExpand;
    private boolean isArchived;
    
    public FriendsRemindersListModel(int reminderTableId, int reminderId, @org.jetbrains.annotations.NotNull()
    java.lang.String reminderText, @org.jetbrains.annotations.NotNull()
    java.lang.String reminderDate, @org.jetbrains.annotations.NotNull()
    java.lang.String reminderFrom, @org.jetbrains.annotations.NotNull()
    java.lang.String reminderTo, @org.jetbrains.annotations.NotNull()
    java.lang.String reminderStatus, boolean isExpand, boolean isArchived) {
        super();
    }
    
    public final int getReminderTableId() {
        return 0;
    }
    
    public final int getReminderId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReminderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReminderDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReminderFrom() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReminderTo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReminderStatus() {
        return null;
    }
    
    public final boolean isExpand() {
        return false;
    }
    
    public final void setExpand(boolean p0) {
    }
    
    public final boolean isArchived() {
        return false;
    }
    
    public final void setArchived(boolean p0) {
    }
}