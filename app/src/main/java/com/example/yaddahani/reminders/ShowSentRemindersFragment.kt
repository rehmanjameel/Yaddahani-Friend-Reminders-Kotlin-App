package com.example.yaddahani.reminders

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import kotlinx.android.synthetic.main.fragment_show_received_reminders.*
import kotlinx.android.synthetic.main.fragment_show_sent_reminders.*
import kotlinx.android.synthetic.main.fragment_show_sent_reminders.view.*
import me.ibrahimsn.lib.SmoothBottomBar
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

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SetTextI18n", "SimpleDateFormat")

class ShowSentRemindersFragment : Fragment() {

    private val sentArgs by navArgs<ShowSentRemindersFragmentArgs>()
    private lateinit var bottomNavigationView: SmoothBottomBar
    private val appGlobals = AppGlobals()
    private lateinit var popUpMenuIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_sent_reminders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set visibility of bottom bar
        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        popUpMenuIcon = view.sentMoreActionMenuId

        view.sentReminderToNameId.text = sentArgs.sentReminders.sentReminderTo
//        view.sentReminderTextId.text = sentArgs.sentReminders.sentReminderText

        val milliSec = sentArgs.sentReminders.sentReminderDate

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

//        view.sentReminderDateId.text = exactDate
//        view.sentReminderTimeId.text = exactTime

        if (sentArgs.sentReminders.sentReminderStatus == "1") {
//            view.sentReminderStatusId.text = "Pending"
        } else if (sentArgs.sentReminders.sentReminderStatus == "2") {
//            view.sentReminderStatusId.text = "Reminded"
        }

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
                upDateReminderStatus()
            }
            else -> {
                println("$exactDateTime is Equal")
            }
        }

        view.sentReminderBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_showSentRemindersFragment_to_reminderFriendFragment, false)
            findNavController().popBackStack()
        }

        popUpMenuIcon.setOnClickListener {
            showPopup()
        }
    }

    private fun upDateReminderStatus() {
        val updateStatusHttpRequest = HttpRequest()
        val jsonObject = JSONObject()

        updateStatusHttpRequest.setOnResponseListener { statusResponse ->

            if (statusResponse.code == HttpResponse.HTTP_OK) {
                println("$ Ok Response")
//                sentReminderStatusId.text = "Reminded"
            }
        }

        updateStatusHttpRequest.setOnErrorListener {
            Log.e("Status error", "$it")
        }

        val status = "2"
        try {
            jsonObject.put("reminder_id", sentArgs.sentReminders.sentReminderId)
            jsonObject.put("status", status)
        } catch (e: Exception) {

        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")

        updateStatusHttpRequest.put(AppGlobals.UPDATE_REMINDERS_API, jsonObject, headers)

    }

    private fun deleteReminder() {
        val httpRequest = HttpRequest()

        httpRequest.setOnResponseListener { deleteReminderResponse ->
            Log.e("Deleted", deleteReminderResponse.text)
            if (deleteReminderResponse.code == HttpResponse.HTTP_OK) {
                Log.e("Deleted", deleteReminderResponse.code.toString())
                findNavController().popBackStack(R.id.action_showReceivedRemindersFragment_to_friendReminderFragmentId, false)
                findNavController().popBackStack()
            }
        }

        httpRequest.setOnErrorListener {
            Log.e("Deleted", "$it")
        }

        val reminderId = sentArgs.sentReminders.sentReminderId
        val jsonObject = JSONObject()
        try {
            jsonObject.put("reminder_id", reminderId)
        } catch (e: Exception) {
            Log.e("Delete error", e.toString())
        }
        Log.e("Id", reminderId.toString())

        val loginToken = appGlobals.getValueString("userToken")
        Log.e("Id", loginToken.toString())

        val header = HttpHeaders("Authorization", "Token $loginToken")

        httpRequest.delete(AppGlobals.DELETE_REMINDERS_API, jsonObject, header)
    }

    //
    private fun showPopup() {
        val popup = PopupMenu(activity, popUpMenuIcon)

        popup.menuInflater.inflate(R.menu.delete_reminder_menu, popup.menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.deleteReminderMenuId -> {
                    deleteReminder()
                }
            }
            true
        })
        popup.show()
    }

}