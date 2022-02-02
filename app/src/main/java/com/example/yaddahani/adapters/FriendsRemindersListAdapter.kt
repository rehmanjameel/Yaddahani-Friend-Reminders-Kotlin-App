package com.example.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.friendsmodule.FriendReminderFragment
import com.example.yaddahani.friendsmodule.FriendReminderFragmentDirections
import com.example.yaddahani.models.FriendsRemindersListModel
import com.example.yaddahani.reminders.SendReminderToFriendFragment
import com.example.yaddahani.roomDB.RemindersViewModel
import kotlinx.android.synthetic.main.fragment_show_received_reminders.*
import kotlinx.android.synthetic.main.fragment_show_received_reminders.view.*
import kotlinx.android.synthetic.main.friends_reminders_layout.view.*
import kotlinx.android.synthetic.main.friends_reminders_layout.view.receivedReminderStatusId
import kotlinx.android.synthetic.main.friends_reminders_layout.view.receivedReminderTextId
import kotlinx.android.synthetic.main.sent_reminders_layout.view.*
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import android.os.Bundle
import androidx.fragment.app.Fragment


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat", "SetTextI18n")

class FriendsRemindersListAdapter(context: Context)
    : RecyclerView.Adapter<FriendsRemindersListAdapter.RemindersViewHolder>() {

    private var friendsReminderModel = ArrayList<FriendsRemindersListModel>()
    private val appGlobals = AppGlobals()
    private val reminderContext = context
    val application = Application()

    private lateinit var friendViewModel: RemindersViewModel

    class RemindersViewHolder(remindersView: View): RecyclerView.ViewHolder(remindersView) {
        val statusText: TextView = remindersView.receivedReminderStatusId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemindersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friends_reminders_layout, parent, false)
        return RemindersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemindersViewHolder, position: Int) {
        val reminderListModelData = friendsReminderModel[position]
        friendViewModel = RemindersViewModel(application)

        holder.itemView.getListFriendReminderNameId.text = reminderListModelData.reminderFrom
        holder.itemView.getListFriendReminderTextId.text = reminderListModelData.reminderText
        holder.itemView.receivedReminderTextId.text = reminderListModelData.reminderText
        holder.itemView.receivedReminderStatusId.text = reminderListModelData.reminderStatus
        val milliSec = reminderListModelData.reminderDate

        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a")

        val instant = Instant.ofEpochMilli(milliSec.toLong())
        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        println(dateFormatter.format(date))
        println(timeFormatter.format(date))
        val exactDate = dateFormatter.format(date)
        val exactTime = timeFormatter.format(date)
        val exactDateTime = dateTimeFormatter.format(date)

        holder.itemView.receivedReminderDateId.text = exactDate
        holder.itemView.receivedReminderTimeId.text = exactTime

        val dates = Date()
        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
        val dateTimeTo = stringFormat.format(dates.time)
        Log.d("D", dateTimeTo.toString())

        when {
            exactDateTime > dateTimeTo -> {
                println("$exactDateTime is greater")
                if (reminderListModelData.reminderStatus == "1") {
                    holder.itemView.receivedReminderStatusId.text = "Pending"
                } else {
                    holder.itemView.receivedReminderStatusId.text = "Reminded"
                }
            }
            exactDateTime < dateTimeTo -> {
                println("$exactDateTime is less")
                val updateStatusHttpRequest = HttpRequest()
                val jsonObject = JSONObject()
//        val savedMillis = appGlobals.getValueString("saveReceivedMillis")

                updateStatusHttpRequest.setOnResponseListener { statusResponse ->

                    if (statusResponse.code == HttpResponse.HTTP_OK) {
                        println("$ Ok Response")
                        holder.itemView.receivedReminderStatusId.text = "Reminded"

                    }
                }

                updateStatusHttpRequest.setOnErrorListener {
                    Log.e("Status error", "$it")
                }

                val status = "2"
                try {
                    jsonObject.put("reminder_id", reminderListModelData.reminderId)
                    jsonObject.put("status", status)
                } catch (e: Exception) {

                }
                val token = appGlobals.getValueString("userToken")
                val headers = HttpHeaders("Authorization", "Token $token")

                updateStatusHttpRequest.put(AppGlobals.UPDATE_REMINDERS_API, jsonObject, headers)
//                upDateReminderStatus()
            }
            else -> {
                println("$exactDateTime is Equal")
            }
        }

//        holder.itemView.receivedFriendsRemindersLisId.setOnClickListener {
//            val action = FriendReminderFragmentDirections.actionFriendReminderFragmentIdToShowReceivedRemindersFragment(reminderListModelData)
//            holder.itemView.findNavController().navigate(action)
//        }

        val isExpandable : Boolean = friendsReminderModel[position].isExpand
        holder.itemView.reminderDetailListId.visibility = if (isExpandable) View.VISIBLE else View.GONE

        Log.e("Check detail", reminderListModelData.isExpand.toString())
        Log.e("Check not ", "${!reminderListModelData.isExpand}")

        holder.itemView.expandBottomArrowId.setOnClickListener {
            val remindersList = friendsReminderModel[position]
            remindersList.isExpand = !remindersList.isExpand
            FriendReminderFragment.onExpand(position)
            notifyItemChanged(position)
        }

        if (isExpandable) {
            holder.itemView.expandBottomArrowId.setImageResource(R.drawable.arrow_up_24)
            holder.itemView.getListFriendReminderTextId.visibility = View.GONE
        } else {
            holder.itemView.expandBottomArrowId.setImageResource(R.drawable.arrow_down_24)
            holder.itemView.getListFriendReminderTextId.visibility = View.VISIBLE
        }

        holder.itemView.archiveReminderId.setOnClickListener {
            friendViewModel.updateReminderArchived(true, reminderListModelData.reminderId)
            Log.e("Archived", reminderListModelData.isArchived.toString())
        }

    }

    override fun getItemCount(): Int {
        return friendsReminderModel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setReminderData(reminders: ArrayList<FriendsRemindersListModel>) {
        this.friendsReminderModel = reminders
        notifyDataSetChanged()
    }
}