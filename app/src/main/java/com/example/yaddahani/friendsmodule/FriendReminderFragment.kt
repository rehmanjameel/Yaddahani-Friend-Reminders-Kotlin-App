package com.example.yaddahani.friendsmodule

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.*
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.core.view.size
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import com.example.yaddahani.*
import com.example.yaddahani.adapters.FriendsRemindersListAdapter
import com.example.yaddahani.models.FriendsRemindersListModel
import com.example.yaddahani.roomDB.RemindersViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_friend_reminder.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONArray
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("NotifyDataSetChanged", "StaticFieldLeak")

class FriendReminderFragment : Fragment() {

    companion object{
        var onForeGround : Boolean = false
        var friendReminderId = ""
        var friendReminderFromName = ""
        var friendReminderToName = ""
        var friendReminderText = ""
        var friendReminderDate = ""
        var friendReminderStatus = ""
        lateinit var recyclerView: RecyclerView
        private lateinit var remindersViewModel: RemindersViewModel
        private lateinit var getReminderListAdapter: FriendsRemindersListAdapter
        private var getRemindersDBList = ArrayList<FriendsRemindersListModel>()

        private lateinit var reminder : FriendsRemindersListModel
        private var remindersListModel = ArrayList<FriendsRemindersListModel>()

        fun onExpand(position: Int) {
            recyclerView.smoothScrollToPosition(position)
        }
    }

    private lateinit var bottomNavigationView: SmoothBottomBar
    private var progressBar: ProgressBar? = null
    private var i = 0
    private lateinit var actionMoreButton: ImageView

    private val getReminderListModel = ArrayList<FriendsRemindersListModel>()
    private val appGlobals = AppGlobals()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_friend_reminder, container, false)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!appGlobals.isLoggedInOrGetValueBoolean()) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(0, 0)
            this.requireActivity().finish()
        }
        recyclerView = view.friendListReminderRecyclerView
        getReminderListAdapter = FriendsRemindersListAdapter(requireActivity())

        recyclerView.adapter = getReminderListAdapter
        getReminderListAdapter.notifyDataSetChanged()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        remindersViewModel = ViewModelProvider(this)[RemindersViewModel::class.java]
        //ViewModelProvider
        remindersViewModel.reminderUnArchived.observe(viewLifecycleOwner, Observer { reminder ->
            getRemindersDBList = reminder as ArrayList<FriendsRemindersListModel>
            Log.e("Start", getRemindersDBList.size.toString())
            getReminderListAdapter.setReminderData(getRemindersDBList)
            Log.e("Sere", getRemindersDBList.toString())

        })

        //
        remindersViewModel.readAllReminders.observe(viewLifecycleOwner, Observer { allReminders ->
            remindersListModel = allReminders as ArrayList<FriendsRemindersListModel>
        })
//        Log.e("Sere", getRemindersDBList.toString())
        //
        progressBar = view.progress_Bar
        progressBar!!.visibility = View.VISIBLE
        i = progressBar!!.progress

//        val loadingDialog = LoadingDialog(requireActivity())
//
//        loadingDialog.startDialog()
//        Handler(Looper.getMainLooper()).postDelayed(
//            {
//                loadingDialog.dismissDialog()
//            }, 1000)

        actionMoreButton = view.moreMenuOptionId
        actionMoreButton.setOnClickListener {
            showPopup()
        }

//        getAllFriendsReminders(requireContext())
        Log.e("Start", "2ndCall")

        //
        onForeGround = true
    }

    override fun onResume() {
        super.onResume()
        getAllFriendsReminders(requireContext())
    }
    //
    private fun showPopup() {
        val popup = PopupMenu(activity, actionMoreButton)

        popup.menuInflater.inflate(R.menu.action_bar_menu, popup.menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logoutMenuId -> {
                    progressBar!!.visibility = View.VISIBLE
                    appGlobals.logoutOrClearSharedPreference()
                    appGlobals.saveLoginOrBoolean(false)
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    requireActivity().overridePendingTransition(0, 0)
                    this.requireActivity().finish()
                }
                R.id.archivedRemindersMenu -> {
                    popup.dismiss()
                    progressBar?.visibility = View.VISIBLE
                    findNavController().navigate(R.id.action_friendReminderFragmentId_to_showReceivedRemindersFragment)
                }
            }
            true
        })
        popup.show()
    }

    fun getAllFriendsReminders(context: Context) {
        val getReminderHttpRequest = HttpRequest()
//        val myList = ArrayList<FriendsRemindersListModel>()
        getReminderHttpRequest.setOnResponseListener { getReminderListResponse ->

            Log.e("getReminders List", getReminderListResponse.code.toString())
            Log.e("getReminders List", getReminderListResponse.text)
            if (getReminderListResponse.code == HttpResponse.HTTP_OK) {
                Log.e("getReminders List", getReminderListResponse.code.toString())
                val jsonArray = getReminderListResponse.toJSONArray()

                getReminderListModel.clear()
                Log.e("list", jsonArray.length().toString())
                Log.e("list", jsonArray.toString())

                val loggedInUser = appGlobals.getValueString("loginUsername")

                for (i in 0 until jsonArray!!.length()) {

                    if (!onForeGround) {
                        progressBar!!.progress = i
                    }
                    Log.e("listi", i.toString())

                    val jsonObject = jsonArray.getJSONObject(i)

                    friendReminderText = jsonObject.getString("reminder")
                    friendReminderFromName = jsonObject.getString("reminder_from")
                    friendReminderToName = jsonObject.getString("reminder_to")
                    friendReminderDate = jsonObject.getString("date")
                    friendReminderStatus = jsonObject.getString("status")
                    friendReminderId = jsonObject.getString("id")

                    if (friendReminderFromName != loggedInUser) {
                        getReminderListModel.add(FriendsRemindersListModel(0, friendReminderId.toInt(),friendReminderText,
                            friendReminderDate, friendReminderFromName, friendReminderToName, friendReminderStatus))

                        //Received date time from server
                        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")
//                        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//                        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a")

                        val instant = Instant.ofEpochMilli(friendReminderDate.toLong())
                        val instant1 = Instant.ofEpochMilli(friendReminderDate.toLong() - (120 * 60 * 1000))
                        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                        val date1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault())
//                        val exactDate = dateFormatter.format(date)
//                        val exactTime = timeFormatter.format(date)
                        val exactDateTime = dateTimeFormatter.format(date)

                        val alarmDate = Date(friendReminderDate.toLong())

                        //Current date time
                        val dates = Date()
                        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
                        val dateTimeTo = stringFormat.format(dates.time)

                        //Set Alarm

                        if (alarmDate.after(dates)) {
                            Log.d("D", dates.toString())
                            Log.d("AlarmDate", alarmDate.toString())
                            Log.e("2 hour ago", dateTimeFormatter.format(date1))
                            println(friendReminderDate.toLong() - (120 * 60 * 1000))
                            Log.e("Set", exactDateTime)

                            val alarmManager: AlarmManager = context.getSystemService(
                                AppCompatActivity.ALARM_SERVICE) as AlarmManager
                            val alarmIntent = Intent(requireContext(), AlarmReceiver::class.java)
                            val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0)

                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                Log.e("Alarm", "Alarm")
                                alarmManager.setAlarmClock(AlarmManager.AlarmClockInfo(friendReminderDate.toLong() - 120*60*1000,
                                    pendingIntent), pendingIntent)
                            } else {
                                Log.e("Alarm1", "${friendReminderDate.toLong() - (120 * 60 * 1000)}")
                                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                                    (friendReminderDate.toLong()) - 120 * 60 * 1000,
                                    pendingIntent)
                                Log.e("Alarm2", "Alarm")
                            }
                        }
//                        if (exactDateTime > dateTimeTo) {
//
//                        }
                    }
                }

                if (friendReminderFromName != loggedInUser) {

                    if (friendReminderId != "") {
                        reminder = FriendsRemindersListModel(0, friendReminderId.toInt(), friendReminderText, friendReminderDate,
                            friendReminderFromName, friendReminderToName, friendReminderStatus)
                    }
                }

                if (getReminderListModel.size.toString() > remindersListModel.size.toString()) {
                    Log.e("serverListSize", getReminderListModel.size.toString())
                    Log.e("dbListSize", remindersListModel.size.toString())
                    Log.e("JsonListSize", jsonArray.length().toString())

//                    for (i in 0 until getReminderListModel.size - 1) {
                        Log.e("present", getReminderListModel[i].reminderId.toString())
                        var isPresent = false
                        for (j in 0 until getReminderListModel.size - 1) {
                            Log.e("present", remindersListModel.toString())

                            if (remindersListModel.isNotEmpty()) {
                                if (getReminderListModel[j].reminderId == remindersListModel[j].reminderId) {
                                    isPresent = true
                                }
                            }
                        }
                        Log.e("presenting", "${!isPresent}")

                        if (isPresent) {
                            remindersViewModel.addingReminder(reminder)

                        }
//                    }
                }
                else if (getReminderListModel.size.toString() < remindersListModel.size.toString()) {
                    for (i in 0 until remindersListModel.size - 1) {
                        for (j in 0 until getReminderListModel.size - 1) {
//                        var isRemoved = false
//                        Log.e("i's", i.toString())
                            Log.e("i's", getReminderListModel.size.toString())
                            Log.e("i'ss", remindersListModel.size.toString())

                            if (remindersListModel.isNotEmpty()) {
                                Log.e("delete3", remindersListModel[i].reminderId.toString())
                                Log.e("delete3", remindersListModel[i].reminderText)
                                Log.e("delete4", getReminderListModel[j].reminderId.toString())
                                Log.e("delete4", getReminderListModel[j].reminderText)
                                if (remindersListModel[i].reminderId != getReminderListModel[i].reminderId ) {
                                    Log.e("delete2", remindersListModel[i].reminderId.toString())
                                    remindersViewModel.deleteReminder(remindersListModel[i].reminderId)
//                                    getReminderListAdapter.notifyItemRemoved(i)
                                }
                            }
                        }
                    }
                }

//                if (getReminderListModel.size.toString() != getRemindersDBList.size.toString()) {
//                    remindersViewModel.deleteReceivedReminders()
//                    remindersViewModel.addReminder(getReminderListModel)
//                }

                if (progressBar!= null) {
                    progressBar!!.visibility = View.GONE
                }
            }
        }

        getReminderHttpRequest.setOnErrorListener {
            if (progressBar != null) {
                progressBar!!.visibility = View.GONE
            }
            Log.e("getReminders error", "$it")
            Log.e("Alarm1", "${friendReminderDate.toLong() - (120 * 60 * 1000)}")

        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")
        getReminderHttpRequest.get(AppGlobals.GET_REMINDERS_LIST_API, headers)
    }
}