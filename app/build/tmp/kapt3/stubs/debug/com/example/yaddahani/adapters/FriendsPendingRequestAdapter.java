package com.example.yaddahani.adapters;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SetTextI18n", "NotifyDataSetChanged"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u001e\u0010\u001c\u001a\u00020\u00152\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\u001eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter$RequestViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "data", "Ljava/util/ArrayList;", "Lcom/example/yaddahani/models/SearchUserModel;", "friendListFragment", "Lcom/example/yaddahani/friendsmodule/FriendListFragment;", "removedPosition", "", "getRemovedPosition", "()Ljava/lang/Integer;", "setRemovedPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "requestActivity", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "tasks", "Lkotlin/collections/ArrayList;", "RequestViewHolder", "app_debug"})
public final class FriendsPendingRequestAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.yaddahani.adapters.FriendsPendingRequestAdapter.RequestViewHolder> {
    private java.util.ArrayList<com.example.yaddahani.models.SearchUserModel> data;
    private final android.content.Context requestActivity = null;
    private final com.example.yaddahani.friendsmodule.FriendListFragment friendListFragment = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer removedPosition;
    
    public FriendsPendingRequestAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRemovedPosition() {
        return null;
    }
    
    public final void setRemovedPosition(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.yaddahani.adapters.FriendsPendingRequestAdapter.RequestViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.yaddahani.adapters.FriendsPendingRequestAdapter.RequestViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.yaddahani.models.SearchUserModel> tasks) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/yaddahani/adapters/FriendsPendingRequestAdapter$RequestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "requestView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class RequestViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public RequestViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View requestView) {
            super(null);
        }
    }
}