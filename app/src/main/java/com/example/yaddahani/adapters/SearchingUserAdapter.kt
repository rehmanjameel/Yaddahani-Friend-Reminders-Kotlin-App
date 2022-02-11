package com.example.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.friendsmodule.SearchFriendFragment
import com.example.yaddahani.friendsmodule.SearchFriendFragmentDirections
import com.example.yaddahani.models.SearchUserModel
import kotlinx.android.synthetic.main.searching_users.view.*

@SuppressLint("NotifyDataSetChanged")

class SearchingUserAdapter(activity: Activity, private var searchingUserModel : List<SearchUserModel>)
    :RecyclerView.Adapter<SearchingUserAdapter.ViewHolder>(){

    private var searchActivity = activity
    private val searchFriendFragment = SearchFriendFragment()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.searching_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelData = searchingUserModel[position]
        holder.itemView.searchingUserNameId.text = modelData.userName
        Log.e("AdapterUser", modelData.userName)

        Glide.with(searchActivity)
            .load("${AppGlobals.SERVER}${modelData.image}")
            .placeholder(R.drawable.profile)
            .error(R.drawable.broken_image_24)
            .into(holder.itemView.searchingUserImageId)
        Log.e("AdapterImage", modelData.image)

        holder.itemView.searchingUserLayoutId.setOnClickListener {
            val action = SearchFriendFragmentDirections.actionSearchFriendFragmentToSendFriendRequestFragment(modelData)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return searchingUserModel.size
    }

    class ViewHolder(userView: View): RecyclerView.ViewHolder(userView) {

    }

    fun filterList(filter: ArrayList<SearchUserModel>) {
        this.searchingUserModel = filter
        notifyDataSetChanged()
    }
}