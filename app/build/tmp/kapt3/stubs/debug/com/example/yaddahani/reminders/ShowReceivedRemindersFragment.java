package com.example.yaddahani.reminders;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
@android.annotation.SuppressLint(value = {"SetTextI18n", "SimpleDateFormat", "NotifyDataSetChanged"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/yaddahani/reminders/ShowReceivedRemindersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "appGlobals", "Lcom/example/yaddahani/AppGlobals;", "bottomNavigationView", "Lme/ibrahimsn/lib/SmoothBottomBar;", "popUpMenuIcon", "Landroid/widget/ImageView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "", "onViewCreated", "view", "showPopup", "Companion", "app_debug"})
public final class ShowReceivedRemindersFragment extends androidx.fragment.app.Fragment {
    private me.ibrahimsn.lib.SmoothBottomBar bottomNavigationView;
    private android.widget.ImageView popUpMenuIcon;
    private final com.example.yaddahani.AppGlobals appGlobals = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.yaddahani.reminders.ShowReceivedRemindersFragment.Companion Companion = null;
    private static androidx.recyclerview.widget.RecyclerView recyclerView;
    private static com.example.yaddahani.roomDB.RemindersViewModel archivedRemindersViewModel;
    private static com.example.yaddahani.adapters.ArchivedRemindersAdapter archivedRemindersAdapter;
    private static final java.util.ArrayList<com.example.yaddahani.models.FriendsRemindersListModel> archivedRemindersArrayList = null;
    private java.util.HashMap _$_findViewCache;
    
    public ShowReceivedRemindersFragment() {
        super();
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
    
    private final void showPopup() {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/yaddahani/reminders/ShowReceivedRemindersFragment$Companion;", "", "()V", "archivedRemindersAdapter", "Lcom/example/yaddahani/adapters/ArchivedRemindersAdapter;", "archivedRemindersArrayList", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/FriendsRemindersListModel;", "archivedRemindersViewModel", "Lcom/example/yaddahani/roomDB/RemindersViewModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onExpand", "", "position", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void onExpand(int position) {
        }
    }
}