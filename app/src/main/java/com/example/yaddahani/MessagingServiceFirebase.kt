package com.example.yaddahani

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.yaddahani.friendsmodule.FriendListFragment
import com.example.yaddahani.friendsmodule.FriendReminderFragment
import com.example.yaddahani.models.FriendsRemindersListModel
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.StringBuilder

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
@RequiresApi(Build.VERSION_CODES.O)

class MessagingServiceFirebase : FirebaseMessagingService() {
    private val appGlobals = AppGlobals()
    private val friendListFragment = FriendListFragment()
    private val friendReminderFragment = FriendReminderFragment()

    companion object {
        var title : String = ""
        var body : String = ""
        private lateinit var intent: Intent
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.data.isNotEmpty().let {
            Log.d("Check Message", remoteMessage.data.toString())
            if (remoteMessage.data.isNotEmpty()) {
                title= remoteMessage.data["title"].toString()
                body= remoteMessage.data["body"].toString()

                Log.e("foregroundnotify", FriendListFragment.isForeGround.toString())

                if (title == "New Friend Request" && FriendListFragment.isForeGround) {
                    Log.e("Check recycler", FriendListFragment.recyclerPendingRequest.toString())
                    friendListFragment.getFriendRequest(applicationContext)
                } else if (title == "Friend Request Accepted" && FriendListFragment.isForeGround) {
                    friendListFragment.addedFriendsList(applicationContext)
                } else if (title == "New Reminder") {
                    friendReminderFragment.getAllFriendsReminders(applicationContext)
                }
                Log.d("Notification msg", title)
                Log.d("Notification msg", body)
                appGlobals.saveString("NotificationTitle", title)
                appGlobals.saveString("NotificationBody", body)
                sendNotification(title, body)
            }
        }
    }


    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification(messageTitle: String, messageBody: String) {

        intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        //Building FirebasePush notification
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.circle_notifications_24)
            .setContentTitle(messageTitle)
            .setContentText(messageBody)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Channel human readable title", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

}