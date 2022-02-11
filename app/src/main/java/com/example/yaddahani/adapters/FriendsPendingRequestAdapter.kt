package com.example.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.friendsmodule.FriendListFragment
import com.example.yaddahani.models.SearchUserModel
import kotlinx.android.synthetic.main.friend_pending_request_list.*
import kotlinx.android.synthetic.main.friend_pending_request_list.view.*

@SuppressLint("SetTextI18n", "NotifyDataSetChanged")

class FriendsPendingRequestAdapter(context: Context)
    : RecyclerView.Adapter<FriendsPendingRequestAdapter.RequestViewHolder>() {

    private var data = ArrayList<SearchUserModel>()
    private val requestActivity = context
    private val friendListFragment = FriendListFragment()
    var removedPosition : Int ? = null

    class RequestViewHolder(requestView: View): RecyclerView.ViewHolder(requestView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_pending_request_list, parent, false)
        return RequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        val pendingRequest = data[position]

        holder.itemView.friendRequestNameId.text = "${pendingRequest.firstName} ${pendingRequest.lastName}"
        Log.e("Request Name", pendingRequest.firstName)

        Glide.with(requestActivity)
            .load("${AppGlobals.SERVER}${pendingRequest.image}")
            .placeholder(R.drawable.profile)
            .error(R.drawable.broken_image_24)
            .into(holder.itemView.friendRequestImageId)

        holder.itemView.confirmRequestButtonId.setOnClickListener {
            requestActivity.let { friendListFragment.acceptRequest(position, data, this, requestActivity) }
        }

        holder.itemView.cancelRequestButtonId.setOnClickListener {
            requestActivity.let {friendListFragment.declineRequest(position, data, this) }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(tasks: ArrayList<SearchUserModel>) {
        this.data = tasks
        notifyDataSetChanged()
    }

//    fun removePosition(position: Int): Int? {
//        data.removeAt(position)
//        notifyDataSetChanged()
//        return removedPosition
//    }
}