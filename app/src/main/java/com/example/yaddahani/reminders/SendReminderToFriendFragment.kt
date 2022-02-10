package com.example.yaddahani.reminders

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isEmpty
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.adapters.SentRemindersAdapter
import com.example.yaddahani.friendsmodule.FriendListFragment
import com.example.yaddahani.friendsmodule.FriendReminderFragment
import com.example.yaddahani.models.SentRemindersListModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_send_reminder.*
import kotlinx.android.synthetic.main.fragment_send_reminder_friend.*
import kotlinx.android.synthetic.main.fragment_send_reminder_friend.view.*
import kotlinx.android.synthetic.main.update_reminder.*
import kotlinx.android.synthetic.main.update_reminder.view.*
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

@SuppressLint("SetTextI18n", "SimpleDateFormat", "NotifyDataSetChanged", "StaticFieldLeak")
@RequiresApi(Build.VERSION_CODES.O)

class SendReminderToFriendFragment : Fragment() {

    companion object {
        val isForeGround : Boolean = false
        private lateinit var recyclerView: RecyclerView
        lateinit var sentReminderAdapter : SentRemindersAdapter

        fun onExpand(position: Int) {
            recyclerView.smoothScrollToPosition(position)
        }

    }
    private var progressBar : ProgressBar? = null
    private val friendListFragment = FriendListFragment()
    private var i = 0
    lateinit var moreActionButton: ImageView
    private lateinit var bottomNavigationView: SmoothBottomBar
    private val sentReminderModelArray = ArrayList<SentRemindersListModel>()
    val appGlobals = AppGlobals()
    private val reminderArgs by navArgs<SendReminderToFriendFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_reminder_friend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        progressBar = view.sentReminderProgress_Bar
        progressBar!!.visibility = View.VISIBLE
        i = progressBar!!.progress

        moreActionButton = view.toSendFriendReminderMoreVertIt

        moreActionButton.setOnClickListener {
            showPopup(requireContext())
        }

        //RecyclerView
        recyclerView = view.toFriendListReminderRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        if (recyclerView.isEmpty()) {
            view.emptyFriendReminderTextId.visibility = View.VISIBLE
        } else {
            view.emptyFriendReminderTextId.visibility = View.GONE
        }
        view.toSendFriendReminderNameId.text = "${reminderArgs.friendsList.friendFirstName} ${reminderArgs.friendsList.friendLastName}"
        Glide.with(requireContext())
            .load("${AppGlobals.SERVER}${reminderArgs.friendsList.images}")
            .into(view.toSendFriendReminderImageId)

        view.toFriendReminderBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_reminderFriendFragment_to_friendListFragmentId, false)
            findNavController().popBackStack()
        }

        view.toFendReminderFloatingButtonId.setOnClickListener {
            findNavController().navigate(R.id.action_reminderFriendFragment_to_addSendReminderFragment)
            appGlobals.saveString("selectedFriendName", reminderArgs.friendsList.userName)
        }

        //
        getAllSentFriendsReminders()
    }

    //
    private fun showPopup(context: Context) {
        val popup = PopupMenu(activity, moreActionButton)
        val httpRequest = HttpRequest()
        val jsonObject = JSONObject()
        popup.menuInflater.inflate(R.menu.unfriend_menu, popup.menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.unFriendMenuId -> {
                    val builder = AlertDialog.Builder(requireContext())
                    builder.setPositiveButton("Yes") {_, _ ->
                        httpRequest.setOnResponseListener { unFriendResponse ->
                            if (unFriendResponse.code == HttpResponse.HTTP_OK) {
                                friendListFragment.addedFriendsList(context)
                                findNavController().popBackStack(R.id.action_reminderFriendFragment_to_friendListFragmentId, false)
                                findNavController().popBackStack()
                                Log.e("Response Unfriend", unFriendResponse.code.toString())
                            }
                        }
                        httpRequest.setOnErrorListener {
                            Log.e("UnfriendError", "$it")
                        }

                        try {
                            jsonObject.put("username", reminderArgs.friendsList.userName)
                        } catch (e: Exception) {

                        }
                        val token = appGlobals.getValueString("userToken")
                        val headers = HttpHeaders("Authorization", "Token $token")
                        httpRequest.delete(AppGlobals.DELETE_FRIEND_API, jsonObject, headers)
                    }
                    builder.setNegativeButton("No") {_, _ ->
                        builder.create().dismiss()
                    }
                    builder.setCancelable(true)
                    builder.setTitle("Unfriend person")
                    builder.setMessage("Are you sure? Do you want to remove the ${reminderArgs.friendsList.userName}?")
                    builder.create().show()
                }
            }
            true
        })
        popup.show()
    }

    //
    private fun getAllSentFriendsReminders() {
        val getReminderHttpRequest = HttpRequest()

        getReminderHttpRequest.setOnResponseListener { getReminderListResponse ->

            Log.e("Reminders List", getReminderListResponse.code.toString())
            Log.e("Reminders List", getReminderListResponse.text)
            if (getReminderListResponse.code == HttpResponse.HTTP_OK) {
                Log.e("Reminders List", getReminderListResponse.code.toString())
                val jsonArray = getReminderListResponse.toJSONArray()
                sentReminderModelArray.clear()
                for (i in 0 until jsonArray!!.length()) {
                    if (!isForeGround) {
                        progressBar!!.progress = i
                    }
                    val jsonObject = jsonArray.getJSONObject(i)

                    val sentFriendReminderText = jsonObject.getString("reminder")
                    val sentFriendReminderFromName = jsonObject.getString("reminder_from")
                    val sentFriendReminderToName = jsonObject.getString("reminder_to")
                    val sentFriendReminderDate = jsonObject.getString("date")
                    val sentFriendReminderStatus = jsonObject.getString("status")
                    val sentFriendReminderId = jsonObject.getString("id")

//                    val loggedUser = appGlobals.getValueString("loginUsername")
                    if (sentFriendReminderToName == reminderArgs.friendsList.userName) {
                        sentReminderModelArray.add(SentRemindersListModel(sentFriendReminderId.toInt(), sentFriendReminderText,
                            sentFriendReminderDate, sentFriendReminderFromName, sentFriendReminderToName, sentFriendReminderStatus))

                        sentReminderModelArray.reverse()
                        sentReminderAdapter = SentRemindersAdapter(requireActivity(), sentReminderModelArray)
                        recyclerView.adapter = sentReminderAdapter
                        emptyFriendReminderTextId.visibility = View.GONE
                    }
                }
                if (progressBar != null) {
                    progressBar!!.visibility = View.GONE
                }
            }
        }

        getReminderHttpRequest.setOnErrorListener {
            progressBar!!.visibility = View.GONE

            emptyFriendReminderTextId.visibility = View.VISIBLE
            emptyFriendReminderTextId.text = "Connection Problem"

            Log.e("Reminders List", "$it")
        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")
        getReminderHttpRequest.get(AppGlobals.GET_REMINDERS_LIST_API, headers)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteUserDialog(reminder: SentRemindersListModel, activity: Activity, position: Int,
                         sentReminderArray: ArrayList<SentRemindersListModel>, adapter: SentRemindersAdapter) {
        println("Name: ${reminder.sentReminderFrom}")
        val builder = AlertDialog.Builder(activity)
        builder.setPositiveButton("Yes") { _, _ ->
            deleteReminderAPI(reminder)
//            sentReminderProgress_Bar.visibility = View.VISIBLE
            Log.e("TAG", " tesst "+ adapter.itemCount)

            sentReminderArray.removeAt(position)
            adapter.notifyDataSetChanged()
//            Toast.makeText(
//                activity,
//                "${reminder.sentReminderFrom} ${reminder.sentReminderText} Successfully deleted",
//                Toast.LENGTH_SHORT
//            ).show()
        }
        builder.setNegativeButton("No") { _, _ ->
        }
        builder.setIcon(R.drawable.warning_amber_24)
        builder.setTitle("Delete Reminder")
        builder.setMessage("Are you sure? Do you want to delete reminder ${reminder.sentReminderText}?")
        builder.create().show()
    }

    private fun deleteReminderAPI(reminder: SentRemindersListModel) {
        val httpRequest = HttpRequest()

        httpRequest.setOnResponseListener { deleteReminderResponse ->
            Log.e("Deleted", deleteReminderResponse.text)
            if (deleteReminderResponse.code == HttpResponse.HTTP_OK) {
                Log.e("Deleted", deleteReminderResponse.code.toString())
            }
        }

        httpRequest.setOnErrorListener {
            Log.e("Deleted", "$it")
        }

        val reminderId = reminder.sentReminderId
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

    fun updateReminderDialog(sentRemindersListModel: SentRemindersListModel, activity: Activity) {
        val builder = AlertDialog.Builder(activity)
//        val inflater = this.layoutInflater
//        val dialogView = layoutInflater.inflate(R.layout.update_reminder, fragment, false)
        val dialogView = LayoutInflater.from(activity).inflate(R.layout.update_reminder, fragment, false)
        builder.setView(dialogView)
        dialogView.updateReminderTextETId.setText(sentRemindersListModel.sentReminderText)

        val millis = sentRemindersListModel.sentReminderDate
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val instant = Instant.ofEpochMilli(millis.toLong())
        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val exactDate = dateFormatter.format(date)
        val exactDateTime = dateTimeFormatter.format(date)
        Log.e("exact", exactDateTime)

        dialogView.updateReminderDatePickerETId.setText(exactDate)

        //Date picker dialog click listener
        dialogView.updateReminderDatePickerETId.setOnClickListener {
//            clickDatePicker(activity)
            val myCalendar = Calendar.getInstance() //This calendar class allow us to create the calendar objects
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(activity,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->    //This statement will be executed once the datePicker dialogue displayed
                    val selectedDate = "$selectedDayOfMonth-${selectedMonth + 1}-$selectedYear"
                    dialogView.updateReminderDatePickerETId.setText(selectedDate)
                }, year, month, day
            )
            datePickerDialog.datePicker.minDate = myCalendar.timeInMillis
            datePickerDialog.show()
        }

        val timePicker = dialogView.updateReminderTimePickerId
        //Time picker
        dialogView.updateReminderTimePickerId.is24HourView
        var hour: Int
        val minute: Int
        val am_pm: String
        if (Build.VERSION.SDK_INT >= 23) {
            hour = timePicker.hour
            minute = timePicker.minute
        } else {
            hour = timePicker.currentHour
            minute = timePicker.currentMinute
        }
        if (hour > 12) {
            am_pm = "PM"
            hour -= 12
        } else {
            am_pm = "AM"
        }
        val time = "$hour:$minute $am_pm"
        dialogView.updateTimeTextView.text = "Selected Date: $time"

        //Combine Dat time to convert it in time in millis
        Log.e("checkDate", dialogView.updateReminderDatePickerETId.text.toString())

        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm aa")

        builder.setPositiveButton("Update") { _, _ ->
            //            Log.e("Dates", dates.toString())
            val combineDateTime = "${dialogView.updateReminderDatePickerETId.text} $time"
            Log.e("Combine", combineDateTime)
            val dates: Date = stringFormat.parse(combineDateTime)!!
            val dateTimeTo = stringFormat.format(dates.time)
            val timeInMillis: Long = dates.time
            Log.e("Combine", dateTimeTo)
            Log.e("Combine", timeInMillis.toString())

            val httpRequest = HttpRequest()
            httpRequest.setOnResponseListener { reminderUpdateResponse ->
                if (reminderUpdateResponse.code == HttpResponse.HTTP_OK) {
                    Log.e("Update", reminderUpdateResponse.text)
                    val objects = reminderUpdateResponse.toJSONObject()
                    val text = objects.getString("reminder")
                    val rDate = objects.getString("date")
                    sentReminderModelArray.add(sentRemindersListModel)
                    sentReminderAdapter.notifyDataSetChanged()
                }
            }

            httpRequest.setOnErrorListener {
                Log.e("Update", "$it")
            }

            val jsonObject = JSONObject()
            try {
                jsonObject.put("reminder_id", sentRemindersListModel.sentReminderId)
                jsonObject.put("reminder", dialogView.updateReminderTextETId.text.toString())
                jsonObject.put("date", timeInMillis)
                if (timeInMillis > System.currentTimeMillis()) {
                    jsonObject.put("status", "1")
                } else if (timeInMillis < System.currentTimeMillis()) {
                    jsonObject.put("status", "2")
                }
            } catch (e: Exception) {
                Log.e("update Reminder error", e.toString())
            }
            val token = appGlobals.getValueString("userToken")
            val headers = HttpHeaders("Authorization", "Token $token")
            httpRequest.put(AppGlobals.UPDATE_REMINDERS_API, jsonObject, headers)
        }

        builder.setNegativeButton("Cancel") {_, _ ->
            builder.create().dismiss()
        }

        builder.setTitle("Update Reminder")
        builder.create().show()
    }

    override fun onDetach() {
        super.onDetach()
        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE
    }

}