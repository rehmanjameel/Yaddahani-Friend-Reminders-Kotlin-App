package com.codebase.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.codebase.yaddahani.AppGlobals
import com.codebase.yaddahani.R
import com.codebase.yaddahani.models.FriendsRemindersListModel
import com.codebase.yaddahani.reminders.ShowReceivedRemindersFragment
import com.codebase.yaddahani.roomDB.RemindersViewModel
import kotlinx.android.synthetic.main.archived_reminders_layout.view.*
import kotlinx.android.synthetic.main.friends_reminders_layout.view.*
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

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SimpleDateFormat", "NotifyDataSetChanged", "SetTextI18n")

class ArchivedRemindersAdapter(context: Context): RecyclerView.Adapter<ArchivedRemindersAdapter.ArchivedRemindersViewHolder>() {

    private var archivedRemindersArrayList = ArrayList<FriendsRemindersListModel>()
    private val appGlobals = AppGlobals()
    private lateinit var friendViewModel: RemindersViewModel
    private val application = Application()

    class ArchivedRemindersViewHolder(archivedView: View): RecyclerView.ViewHolder(archivedView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchivedRemindersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.archived_reminders_layout, parent, false)
        return ArchivedRemindersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArchivedRemindersViewHolder, position: Int) {
        val archivedModel = archivedRemindersArrayList[position]
        friendViewModel = RemindersViewModel(application)

        holder.itemView.archivedReminderNameId.text = archivedModel.reminderFrom
        holder.itemView.archivedReminderTextId.text = archivedModel.reminderText
        holder.itemView.archivedDetailTextId.text = archivedModel.reminderText
        holder.itemView.archivedReminderStatusId.text = archivedModel.reminderStatus
        val milliSec = archivedModel.reminderDate

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

        holder.itemView.archivedReminderDateId.text = exactDate
        holder.itemView.archivedReminderTimeId.text = exactTime

        val dates = Date()
        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
        val dateTimeTo = stringFormat.format(dates.time)
        Log.d("D", dateTimeTo.toString())

        when {
            exactDateTime > dateTimeTo -> {
                println("$exactDateTime is greater")
            }
            exactDateTime < dateTimeTo -> {
                println("$exactDateTime is less")
                val updateStatusHttpRequest = HttpRequest()
                val jsonObject = JSONObject()
//        val savedMillis = appGlobals.getValueString("saveReceivedMillis")

                updateStatusHttpRequest.setOnResponseListener { statusResponse ->

                    if (statusResponse.code == HttpResponse.HTTP_OK) {
                        println("$ Ok Response")
                        holder.itemView.archivedReminderStatusId.text = "Reminded"

                    }
                }

                updateStatusHttpRequest.setOnErrorListener {
                    Log.e("Status error", "$it")
                }

                val status = "2"
                try {
                    jsonObject.put("reminder_id", archivedModel.reminderId)
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

        val isExpandable : Boolean = archivedRemindersArrayList[position].isExpand
        holder.itemView.archivedReminderDetailListId.visibility = if (isExpandable) View.VISIBLE else View.GONE

        Log.e("Check detail", archivedModel.isExpand.toString())
        Log.e("Check not ", "${!archivedModel.isExpand}")

        holder.itemView.archivedExpandBottomArrowId.setOnClickListener {
            val remindersList = archivedRemindersArrayList[position]
            remindersList.isExpand = !remindersList.isExpand
            ShowReceivedRemindersFragment.onExpand(position)
            notifyItemChanged(position)
        }

        if (isExpandable) {
            holder.itemView.archivedExpandBottomArrowId.setImageResource(R.drawable.arrow_up_24)
            holder.itemView.archivedReminderTextId.visibility = View.GONE
        } else {
            holder.itemView.archivedExpandBottomArrowId.setImageResource(R.drawable.arrow_down_24)
            holder.itemView.archivedReminderTextId.visibility = View.VISIBLE
        }

        holder.itemView.unArchiveReminderId.setOnClickListener {
            friendViewModel.updateReminderArchived(false, archivedModel.reminderId)
            Log.e("Archived", archivedModel.isArchived.toString())
        }
    }

    override fun getItemCount(): Int {
        return archivedRemindersArrayList.size
    }

    fun setReminderData(reminders: ArrayList<FriendsRemindersListModel>) {
        this.archivedRemindersArrayList = reminders
        notifyDataSetChanged()
    }
}