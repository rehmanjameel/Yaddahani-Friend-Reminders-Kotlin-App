package com.example.yaddahani;

import java.lang.System;

@android.annotation.SuppressLint(value = {"CommitPrefEdits", "StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/example/yaddahani/AppGlobals;", "Landroid/app/Application;", "()V", "getValueInt", "", "KEY_NAME", "", "getValueString", "isLoggedInOrGetValueBoolean", "", "logoutOrClearSharedPreference", "", "onCreate", "removeValue", "saveInt", "value", "saveLoginOrBoolean", "status", "saveString", "text", "Companion", "app_debug"})
public final class AppGlobals extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.yaddahani.AppGlobals.Companion Companion = null;
    private static android.content.Context context;
    private static android.content.SharedPreferences sharedPref;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "sharedPrefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LOGGED_IN = "login_key";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVER = "http://192.168.100.197:8000";
    private static final java.lang.String API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REGISTER_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REQUEST_OTP_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACTIVATE_ACCOUNT_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOGIN_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SEARCH_USER_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SEND_FRIEND_REQUEST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String GET_FRIEND_REQUEST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DELETE_FRIEND_REQUEST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACCEPT_FRIEND_REQUEST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FRIENDS_LIST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DELETE_FRIEND_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PROFILE_GET_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String UPDATE_PROFILE_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DELETE_PROFILE_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FCM_TOKEN_UPDATE_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CREATE_REMINDER_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String GET_REMINDERS_LIST_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String UPDATE_REMINDERS_API = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DELETE_REMINDERS_API = null;
    
    public AppGlobals() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public final void saveString(@org.jetbrains.annotations.NotNull()
    java.lang.String KEY_NAME, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void saveInt(@org.jetbrains.annotations.NotNull()
    java.lang.String KEY_NAME, int value) {
    }
    
    public final void saveLoginOrBoolean(boolean status) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValueString(@org.jetbrains.annotations.NotNull()
    java.lang.String KEY_NAME) {
        return null;
    }
    
    public final int getValueInt(@org.jetbrains.annotations.NotNull()
    java.lang.String KEY_NAME) {
        return 0;
    }
    
    public final boolean isLoggedInOrGetValueBoolean() {
        return false;
    }
    
    public final void logoutOrClearSharedPreference() {
    }
    
    public final void removeValue(@org.jetbrains.annotations.NotNull()
    java.lang.String KEY_NAME) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u00105\u001a\u000202R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0011\u0010$\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0011\u0010&\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0006R\u0011\u0010(\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/example/yaddahani/AppGlobals$Companion;", "", "()V", "ACCEPT_FRIEND_REQUEST_API", "", "getACCEPT_FRIEND_REQUEST_API", "()Ljava/lang/String;", "ACTIVATE_ACCOUNT_API", "getACTIVATE_ACCOUNT_API", "API", "CREATE_REMINDER_API", "getCREATE_REMINDER_API", "DELETE_FRIEND_API", "getDELETE_FRIEND_API", "DELETE_FRIEND_REQUEST_API", "getDELETE_FRIEND_REQUEST_API", "DELETE_PROFILE_API", "getDELETE_PROFILE_API", "DELETE_REMINDERS_API", "getDELETE_REMINDERS_API", "FCM_TOKEN_UPDATE_API", "getFCM_TOKEN_UPDATE_API", "FRIENDS_LIST_API", "getFRIENDS_LIST_API", "GET_FRIEND_REQUEST_API", "getGET_FRIEND_REQUEST_API", "GET_REMINDERS_LIST_API", "getGET_REMINDERS_LIST_API", "KEY_LOGGED_IN", "getKEY_LOGGED_IN", "LOGIN_API", "getLOGIN_API", "PREFS_NAME", "getPREFS_NAME", "PROFILE_GET_API", "getPROFILE_GET_API", "REGISTER_API", "getREGISTER_API", "REQUEST_OTP_API", "getREQUEST_OTP_API", "SEARCH_USER_API", "getSEARCH_USER_API", "SEND_FRIEND_REQUEST_API", "getSEND_FRIEND_REQUEST_API", "SERVER", "UPDATE_PROFILE_API", "getUPDATE_PROFILE_API", "UPDATE_REMINDERS_API", "getUPDATE_REMINDERS_API", "context", "Landroid/content/Context;", "sharedPref", "Landroid/content/SharedPreferences;", "applicationContext", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context applicationContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPREFS_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_LOGGED_IN() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getREGISTER_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getREQUEST_OTP_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACTIVATE_ACCOUNT_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLOGIN_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSEARCH_USER_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSEND_FRIEND_REQUEST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getGET_FRIEND_REQUEST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDELETE_FRIEND_REQUEST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getACCEPT_FRIEND_REQUEST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFRIENDS_LIST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDELETE_FRIEND_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPROFILE_GET_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUPDATE_PROFILE_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDELETE_PROFILE_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFCM_TOKEN_UPDATE_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCREATE_REMINDER_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getGET_REMINDERS_LIST_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUPDATE_REMINDERS_API() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDELETE_REMINDERS_API() {
            return null;
        }
    }
}