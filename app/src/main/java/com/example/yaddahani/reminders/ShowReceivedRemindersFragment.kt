package com.example.yaddahani.reminders

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
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
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yaddahani.AlarmReceiver
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.MainActivity
import com.example.yaddahani.R
import com.example.yaddahani.adapters.ArchivedRemindersAdapter
import com.example.yaddahani.friendsmodule.FriendReminderFragment
import com.example.yaddahani.friendsmodule.FriendReminderFragment.Companion.recyclerView
import com.example.yaddahani.models.FriendsRemindersListModel
import com.example.yaddahani.roomDB.RemindersViewModel
import kotlinx.android.synthetic.main.fragment_show_received_reminders.*
import kotlinx.android.synthetic.main.fragment_show_received_reminders.view.*
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
import kotlin.collections.ArrayList

@SuppressLint("SetTextI18n","SimpleDateFormat", "NotifyDataSetChanged")
@RequiresApi(Build.VERSION_CODES.O)

class ShowReceivedRemindersFragment : Fragment() {

//    private val receivedArgs by navArgs<ShowReceivedRemindersFragmentArgs>()
    private lateinit var bottomNavigationView: SmoothBottomBar
    private lateinit var popUpMenuIcon: ImageView
    private val appGlobals = AppGlobals()

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var archivedRemindersViewModel: RemindersViewModel
        private lateinit var archivedRemindersAdapter: ArchivedRemindersAdapter
        private val archivedRemindersArrayList = ArrayList<FriendsRemindersListModel>()

        fun onExpand(position: Int) {
            recyclerView.smoothScrollToPosition(position)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_received_reminders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set visibility of bottom bar
        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

//        popUpMenuIcon = view.receivedMoreActionMenuId

        recyclerView = view.archivedReminderRecyclerViewId

        archivedRemindersAdapter = ArchivedRemindersAdapter(requireContext())

        recyclerView.adapter = archivedRemindersAdapter
        archivedRemindersAdapter.notifyDataSetChanged()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        archivedRemindersViewModel = ViewModelProvider(this)[RemindersViewModel::class.java]
        archivedRemindersViewModel.reminderArchived.observe(viewLifecycleOwner, androidx.lifecycle.Observer { archivedReminders ->
            archivedRemindersAdapter.setReminderData(archivedReminders as ArrayList<FriendsRemindersListModel>)
        })
        //
//        val reminderId = receivedArgs.receivedReminders.reminderId
//        println(reminderId)
//
//        view.receivedReminderFromNameId.text = receivedArgs.receivedReminders.reminderFrom
////        view.receivedReminderTextId.text = receivedArgs.receivedReminders.reminderText
//        val milliSec = receivedArgs.receivedReminders.reminderDate
//        appGlobals.saveString("saveReceivedMillis", milliSec)
//
//        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")
//
//        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a")
//
//        val instant = Instant.ofEpochMilli(milliSec.toLong())
//        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
//        println(dateFormatter.format(date))
//        println(timeFormatter.format(date))
//        val exactDate = dateFormatter.format(date)
//        val exactTime = timeFormatter.format(date)
//        val exactDateTime = dateTimeFormatter.format(date)
//
////        view.receivedReminderDateId.text = exactDate
////        view.receivedReminderTimeId.text = exactTime
//
//        if (receivedArgs.receivedReminders.reminderStatus == "1") {
////            view.receivedReminderStatusId.text = "Pending"
//        } else if (receivedArgs.receivedReminders.reminderStatus == "2") {
////            view.receivedReminderStatusId.text = "Reminded"
//        }
//
//        val dates = Date()
//        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
//        val dateTimeTo = stringFormat.format(dates.time)
//        Log.d("D", dateTimeTo.toString())
//
//        when {
//            exactDateTime > dateTimeTo -> {
//                println("$exactDateTime is greater")
//            }
//            exactDateTime < dateTimeTo -> {
//                println("$exactDateTime is less")
//                upDateReminderStatus()
//            }
//            else -> {
//                println("$exactDateTime is Equal")
//            }
//        }

        view.receivedReminderBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_showReceivedRemindersFragment_to_friendReminderFragmentId, false)
            findNavController().popBackStack()
        }

//        popUpMenuIcon.setOnClickListener {
//            showPopup()
//        }
    }

//    private fun upDateReminderStatus() {
//        val updateStatusHttpRequest = HttpRequest()
//        val jsonObject = JSONObject()
//        val savedMillis = appGlobals.getValueString("saveReceivedMillis")
//
//        updateStatusHttpRequest.setOnResponseListener { statusResponse ->
//
//            if (statusResponse.code == HttpResponse.HTTP_OK) {
//                println("$ Ok Response")
////                receivedReminderStatusId.text = "Reminded"
//
//            }
//        }
//
//        updateStatusHttpRequest.setOnErrorListener {
//            Log.e("Status error", "$it")
//        }
//
//        val status = "2"
//        try {
//            jsonObject.put("reminder_id", receivedArgs.receivedReminders.reminderId)
//            jsonObject.put("status", status)
//        } catch (e: Exception) {
//
//        }
//        val token = appGlobals.getValueString("userToken")
//        val headers = HttpHeaders("Authorization", "Token $token")
//
//        updateStatusHttpRequest.put(AppGlobals.UPDATE_REMINDERS_API, jsonObject, headers)
//    }

//    private fun deleteReminder() {
//        val httpRequest = HttpRequest()
//
//        httpRequest.setOnResponseListener { deleteReminderResponse ->
//            Log.e("Deleted", deleteReminderResponse.text)
//            if (deleteReminderResponse.code == HttpResponse.HTTP_OK) {
//                Log.e("Deleted", deleteReminderResponse.code.toString())
//                findNavController().popBackStack(R.id.action_showReceivedRemindersFragment_to_friendReminderFragmentId, false)
//                findNavController().popBackStack()
//            }
//        }
//
//        httpRequest.setOnErrorListener {
//            Log.e("Deleted", "$it")
//        }
//
//        val reminderId = receivedArgs.receivedReminders.reminderId
//        val jsonObject = JSONObject()
//        try {
//            jsonObject.put("reminder_id", reminderId)
//        } catch (e: Exception) {
//            Log.e("Delete error", e.toString())
//        }
//        Log.e("Id", reminderId.toString())
//
//        val loginToken = appGlobals.getValueString("userToken")
//        Log.e("Id", loginToken.toString())
//
//        val header = HttpHeaders("Authorization", "Token $loginToken")
//
//        httpRequest.delete(AppGlobals.DELETE_REMINDERS_API, jsonObject, header)
//    }

    //
    private fun showPopup() {
        val popup = PopupMenu(activity, popUpMenuIcon)

        popup.menuInflater.inflate(R.menu.delete_reminder_menu, popup.menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.deleteReminderMenuId -> {
//                    deleteReminder()
                }
            }
            true
        })
        popup.show()
    }

    override fun onDetach() {
        super.onDetach()
        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE
    }

}