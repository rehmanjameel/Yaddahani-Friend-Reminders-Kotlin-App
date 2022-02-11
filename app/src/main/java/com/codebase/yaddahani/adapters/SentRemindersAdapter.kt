package com.codebase.yaddahani.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.codebase.yaddahani.AppGlobals
import com.codebase.yaddahani.R
import com.codebase.yaddahani.models.SentRemindersListModel
import com.codebase.yaddahani.reminders.SendReminderToFriendFragment
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
@RequiresApi(Build.VERSION_CODES.O)

class SentRemindersAdapter(activity: Activity, private val sentReminderModel : ArrayList<SentRemindersListModel>)
    : RecyclerView.Adapter<SentRemindersAdapter.SentViewHolder>() {

    private val appGlobals = AppGlobals()
    private val sentReminderActivity = activity
    private val sendReminderToFriendFragment = SendReminderToFriendFragment()

    class SentViewHolder(sentView: View): RecyclerView.ViewHolder(sentView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sent_reminders_layout, parent, false)
        return SentViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SentViewHolder, position: Int) {
        val sentModelData = sentReminderModel[position]

        holder.itemView.sentListFriendReminderNameId.text = sentModelData.sentReminderTo
        holder.itemView.sentListFriendReminderTextId.text = sentModelData.sentReminderText
        holder.itemView.sentReminderTextId.text = sentModelData.sentReminderText
        holder.itemView.sentReminderStatusId.text = sentModelData.sentReminderStatus

        val milliSec = sentModelData.sentReminderDate

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

        holder.itemView.sentReminderDateId.text = exactDate
        holder.itemView.sentReminderTimeId.text = exactTime

        val alarmedDate = Date(milliSec.toLong())
        val dates = Date()

        when {
            alarmedDate.after(dates) -> {
                println("$exactDateTime is greater")
                holder.itemView.sentReminderStatusId.text = "Pending"
            }
            alarmedDate.before(dates) -> {
                println("$exactDateTime is less")
                val updateStatusHttpRequest = HttpRequest()
                val jsonObject = JSONObject()

                updateStatusHttpRequest.setOnResponseListener { statusResponse ->

                    if (statusResponse.code == HttpResponse.HTTP_OK) {
                        println("$ Ok Response")
                        holder.itemView.sentReminderStatusId.text = "Reminded"
                        holder.itemView.updateSentReminderIcon.isClickable = false
                        holder.itemView.updateSentReminderIcon.backgroundTintList = sentReminderActivity.getColorStateList(R.color.offWhite1)

                    }
                }

                updateStatusHttpRequest.setOnErrorListener {
                    Log.e("Status error", "$it")
                }

                val status = "2"
                try {
                    jsonObject.put("reminder_id", sentModelData.sentReminderId)
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
                holder.itemView.sentReminderStatusId.text = "Reminded"
            }
        }

        val isExpandable : Boolean = sentReminderModel[position].isExpand
        holder.itemView.sentReminderListId.visibility = if (isExpandable) View.VISIBLE else View.GONE

        Log.e("Check detail", sentModelData.isExpand.toString())
        Log.e("Check not ", "${!sentModelData.isExpand}")

        holder.itemView.expandCollapseArrowId.setOnClickListener {
            val remindersList = sentReminderModel[position]
            remindersList.isExpand = !remindersList.isExpand
            SendReminderToFriendFragment.onExpand(position)
            notifyItemChanged(position)
        }

        if (isExpandable) {
            holder.itemView.expandCollapseArrowId.setImageResource(R.drawable.arrow_up_24)
            holder.itemView.sentListFriendReminderTextId.visibility = View.GONE
        } else {
            holder.itemView.expandCollapseArrowId.setImageResource(R.drawable.arrow_down_24)
            holder.itemView.sentListFriendReminderTextId.visibility = View.VISIBLE
        }

        //
        holder.itemView.deleteSentReminderIcon.setOnClickListener {
            sentReminderActivity.let { it1 -> sendReminderToFriendFragment.deleteUserDialog(sentModelData, it1, position, sentReminderModel, this) }
        }

        //
        holder.itemView.updateSentReminderIcon.setOnClickListener {
            sentReminderActivity.let { it1 -> sendReminderToFriendFragment.updateReminderDialog(sentModelData, it1) }
        }
    }

    override fun getItemCount(): Int {
        return sentReminderModel.size
    }
}