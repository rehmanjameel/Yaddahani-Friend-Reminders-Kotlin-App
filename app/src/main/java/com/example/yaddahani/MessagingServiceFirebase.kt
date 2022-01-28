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

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
@RequiresApi(Build.VERSION_CODES.O)

class MessagingServiceFirebase : FirebaseMessagingService() {
    private val appGlobals = AppGlobals()
    private val friendListFragment = FriendListFragment()
    private val friendReminderFragment = FriendReminderFragment()

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.data.isNotEmpty().let {
            Log.d("Check Message", remoteMessage.data.toString())
            if (remoteMessage.data.isNotEmpty()) {
                val msg: String = remoteMessage.data["title"].toString()
                val body: String = remoteMessage.data["body"].toString()

//                Log.e("listmf", getReminderListModel.size.toString())

                Log.e("foregroundnotify", FriendListFragment.isForeGround.toString())

                if (msg == "New Friend Request" && FriendListFragment.isForeGround) {
                    Log.e("Check recycler", FriendListFragment.recyclerPendingRequest.toString())
                    friendListFragment.getFriendRequest(applicationContext)
                } else if (msg == "Friend Request Accepted" && FriendListFragment.isForeGround) {
                    friendListFragment.addedFriendsList(applicationContext)
                } else if (msg == "New Reminder") {
                    friendReminderFragment.getAllFriendsReminders(applicationContext)
                }
                Log.d("Notification msg", msg)
                Log.d("Notification msg", body)
                sendNotification(msg, body)
            }
        }
//        sendNotification(remoteMessage.notification!!.title.toString() ,remoteMessage.notification!!.body.toString())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
//        updateFCMToken()
    }

    private fun updateFCMToken() {
        val httpRequest = HttpRequest()
        val jsonObject = JSONObject()

        httpRequest.setOnResponseListener { fcmTokenResponse ->
            Log.e("Tokens", fcmTokenResponse.code.toString())
            Log.e("Tokens", fcmTokenResponse.text)

            if (fcmTokenResponse.code == HttpResponse.HTTP_OK) {
                Log.e("Tokens", fcmTokenResponse.code.toString())
            }
        }
        httpRequest.setOnErrorListener {
            Log.e("Tokens", "$it")
        }

        val fcmToken = appGlobals.getValueString("saveFCMToken")
        val loginToken = appGlobals.getValueString("userToken")
        jsonObject.put("fcm_token", fcmToken)
        val header = HttpHeaders("Authorization", "Token $loginToken")

        httpRequest.put(AppGlobals.FCM_TOKEN_UPDATE_API, jsonObject, header)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun sendNotification(messageTitle: String, messageBody: String) {

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
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