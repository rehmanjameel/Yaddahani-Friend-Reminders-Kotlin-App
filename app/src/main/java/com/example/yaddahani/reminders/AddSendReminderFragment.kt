package com.example.yaddahani.reminders

import android.app.AlarmManager
import android.app.DatePickerDialog
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
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.yaddahani.AlarmReceiver
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import kotlinx.android.synthetic.main.fragment_add_send_reminder.*
import kotlinx.android.synthetic.main.fragment_add_send_reminder.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class AddSendReminderFragment : Fragment() {

    lateinit var timeView: TextView
    lateinit var timePicker: TimePicker
//    lateinit var moreActionButton: ImageView
    private lateinit var bottomNavigationView: SmoothBottomBar
    val appGlobals = AppGlobals()
    private val remindersArgs by navArgs<SendReminderToFriendFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_send_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        timeView = view.timeTextView
        timePicker = view.sendReminderTimePickerId
//        moreActionButton = view.sendFriendReminderMoreVertIt

        val sharedValue = appGlobals.getValueString("selectedFriendName")
        Log.e("Value", sharedValue.toString())
//        val getValue = arguments!!.getString("selectedFriend")

//        Log.e("Value", getValue.toString())

        view.sendReminderButtonId.setOnClickListener {
            sendReminder()
        }

        view.sendReminderDatePickerETId.setOnClickListener {
            clickDatePicker()
        }

        view.sendFriendReminderBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_addSendReminderFragment_to_reminderFriendFragment, false)
            findNavController().popBackStack()
        }
    }

    private fun sendReminder() {

        if (sendReminderTextETId.text.toString().isEmpty() && sendReminderDatePickerETId.text.toString().isEmpty()) {
            sendReminderTextETId.error = "Reminder text required"
            Toast.makeText(requireContext(), "Select Date", Toast.LENGTH_SHORT).show()
        } else if (sendReminderTextETId.text.toString().isEmpty()) {
            sendReminderTextETId.error = "Reminder text required"
        } else if (sendReminderDatePickerETId.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "Select Date", Toast.LENGTH_SHORT).show()
        } else {
            sendReminderApi()
        }
    }

    private fun sendReminderApi() {
        val sendReminderHttpRequest = HttpRequest()
        val jsonObject = JSONObject()

        val reminderDate = sendReminderDatePickerETId.text.toString()

        //Time picker
        sendReminderTimePickerId.is24HourView
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
        timeView.text = "Selected Date: $time"

        //Combine Dat time to convert it in time in millis
        val combineDateTime = "$reminderDate $time"
        Log.e("Combine", combineDateTime)

        var dates = Date()

        Log.e("Dates", dates.toString())

        val stringFormat = SimpleDateFormat("dd-MM-yyyy hh:mm aa")

        dates = stringFormat.parse(combineDateTime)!!
        val dateTimeTo = stringFormat.format(dates.time)
        val timeInMillis: Long = dates.time
        Log.e("Timer", time)
        Log.d("D", dateTimeTo.toString())
        Log.d("D", timeInMillis.toString())

        sendReminderHttpRequest.setOnResponseListener { reminderSendResponse ->

            Log.e("Reminder", reminderSendResponse.text)
            Log.e("Reminder", reminderSendResponse.code.toString())

            if (reminderSendResponse.code == HttpResponse.HTTP_CREATED) {

                findNavController().popBackStack(R.id.action_addSendReminderFragment_to_reminderFriendFragment, false)
                findNavController().popBackStack()
                Log.e("Reminder", reminderSendResponse.code.toString())
            }
        }

        sendReminderHttpRequest.setOnErrorListener {
            Log.e("Reminder", "$it")
        }

        val userName = appGlobals.getValueString("selectedFriendName")
        Log.e("Value", userName.toString())
        val status = "1"

        try {
            jsonObject.put("reminder_to", userName)
            jsonObject.put("reminder", sendReminderTextETId.text.toString())
            jsonObject.put("date", timeInMillis)
            jsonObject.put("status", status)
        } catch (e: Exception) {
            Log.e("ReminderEx", e.toString())
        }

        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")
        sendReminderHttpRequest.post(AppGlobals.CREATE_REMINDER_API, jsonObject, headers)

    }

    //Date Picker
    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance() //This calendar class allow us to create the calendar objects
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(),
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->    //This statement will be executed once the datePicker dialogue displayed
//                Toast.makeText(
//                    requireContext(),
//                    "The Chosen year is $year, the month is $month, and the day is $selectedDayOfMonth",
//                    Toast.LENGTH_LONG
//                ).show()
                val selectedDate = "$selectedDayOfMonth-${selectedMonth + 1}-$selectedYear"
                sendReminderDatePickerETId.setText(selectedDate)
            }, year, month, day
        )
        datePickerDialog.datePicker.minDate = myCalendar.timeInMillis
        datePickerDialog.show()
    }

//    override fun onDetach() {
//        super.onDetach()
//
//        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
//        bottomNavigationView.visibility = View.VISIBLE
//    }

}