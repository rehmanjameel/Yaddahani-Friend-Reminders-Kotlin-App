package com.codebase.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codebase.yaddahani.AppGlobals
import com.codebase.yaddahani.R
import com.codebase.yaddahani.friendsmodule.FriendListFragmentDirections
import com.codebase.yaddahani.models.FriendModel
import kotlinx.android.synthetic.main.friends_list.view.*

@SuppressLint("SetTextI18n")

class FriendListAdapter(context: Context, private val friendModel: ArrayList<FriendModel>)
    :RecyclerView.Adapter<FriendListAdapter.FriendViewHolder>(){

    private val friendContext = context
    class FriendViewHolder(friendView: View): RecyclerView.ViewHolder(friendView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friends_list, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friendList = friendModel[position]

        holder.itemView.friendListNameId.text = "${friendList.friendFirstName} ${friendList.friendLastName}"
        Glide.with(friendContext)
            .load("${AppGlobals.SERVER}${friendList.images}")
            .placeholder(R.drawable.profile)
            .error(R.drawable.broken_image_24)
            .into(holder.itemView.friendListImageId)

        holder.itemView.friendListCardId.setOnClickListener {
            val action = FriendListFragmentDirections.actionFriendListFragmentIdToReminderFriendFragment(friendList)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return friendModel.size
    }
}