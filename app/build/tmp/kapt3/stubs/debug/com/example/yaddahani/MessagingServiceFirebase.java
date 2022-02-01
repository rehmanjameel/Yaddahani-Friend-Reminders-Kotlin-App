package com.example.yaddahani;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@android.annotation.SuppressLint(value = {"MissingFirebaseInstanceTokenRefresh"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0003J\b\u0010\u0013\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/yaddahani/MessagingServiceFirebase;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "friendListFragment", "Lcom/example/yaddahani/friendsmodule/FriendListFragment;", "friendReminderFragment", "Lcom/example/yaddahani/friendsmodule/FriendReminderFragment;", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "sendNotification", "messageTitle", "messageBody", "updateFCMToken", "app_debug"})
public final class MessagingServiceFirebase extends com.google.firebase.messaging.FirebaseMessagingService {
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    private final com.example.yaddahani.friendsmodule.FriendListFragment friendListFragment = null;
    private final com.example.yaddahani.friendsmodule.FriendReminderFragment friendReminderFragment = null;
    
    public MessagingServiceFirebase() {
        super();
    }
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    private final void updateFCMToken() {
    }
    
    @android.annotation.SuppressLint(value = {"UnspecifiedImmutableFlag"})
    private final void sendNotification(java.lang.String messageTitle, java.lang.String messageBody) {
    }
}