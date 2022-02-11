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
import androidx.core.view.isEmpty
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

    private lateinit var bottomNavigationView: SmoothBottomBar

    companion object {
        private lateinit var recyclerView: RecyclerView
        private lateinit var archivedRemindersViewModel: RemindersViewModel
        private lateinit var archivedRemindersAdapter: ArchivedRemindersAdapter

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
        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        recyclerView = view.archivedReminderRecyclerViewId

        archivedRemindersAdapter = ArchivedRemindersAdapter(requireContext())

        recyclerView.adapter = archivedRemindersAdapter
        archivedRemindersAdapter.notifyDataSetChanged()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        if (recyclerView.isEmpty()) {
            emptyArchivedReminderTextId.visibility = View.VISIBLE
        } else {
            emptyArchivedReminderTextId.visibility = View.GONE
            archivedRemindersViewModel = ViewModelProvider(this)[RemindersViewModel::class.java]
            archivedRemindersViewModel.reminderArchived.observe(viewLifecycleOwner, androidx.lifecycle.Observer { archivedReminders ->
                archivedRemindersAdapter.setReminderData(archivedReminders as ArrayList<FriendsRemindersListModel>)
            })
        }

        view.receivedReminderBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_showReceivedRemindersFragment_to_friendReminderFragmentId, false)
            findNavController().popBackStack()
        }
    }

    override fun onDetach() {
        super.onDetach()
        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE
    }

}