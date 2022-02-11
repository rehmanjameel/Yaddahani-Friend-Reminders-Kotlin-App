package com.codebase.yaddahani

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.codebase.yaddahani.friendsmodule.HomeActivity
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnsafeProtectedBroadcastReceiver")
class AlarmReceiver: BroadcastReceiver() {

    private val appGlobals = com.codebase.yaddahani.AppGlobals()
    private val messagingClientService = com.codebase.yaddahani.MessagingServiceFirebase()

    override fun onReceive(context: Context, intent: Intent?) {
        Log.e("Checking notify", "Notification")

        val title = appGlobals.getValueString("NotificationTitle")
        val body = appGlobals.getValueString("NotificationBody")
        Log.e("Checking ", title.toString())

//        messagingClientService.sendNotification(title.toString(), body.toString())
        showNotification(context, title.toString(), body.toString())
//        showNotification(context, "New Notification", "Notification")

        Log.e("Checking ", "Notification")

//        ringTone(context)
    }

//    private fun ringTone(context: Context) {
//        val alert: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
//        val ringtone: Ringtone = RingtoneManager.getRingtone(context, alert)
//
//        ringtone.play()
//        Toast.makeText(context, "Alarm Called", Toast.LENGTH_SHORT).show()
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun showNotification(ctx: Context, title: String, message: String) {
        val notificationManager =
            ctx.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "channel"
            val name: CharSequence = "channel"
            val description = "The channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(channelId, name, importance)
            mChannel.description = description
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mChannel.setShowBadge(false)
            notificationManager.createNotificationChannel(mChannel)
        }
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(ctx, "channel")
            .setSmallIcon(com.codebase.yaddahani.R.drawable.ic_baseline_access_alarm_24)
            .setContentTitle(title)
            .setContentText(message)
        val resultIntent = Intent(ctx, HomeActivity::class.java)
        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(ctx)
        stackBuilder.addParentStack(HomeActivity::class.java)
        resultIntent.putExtra("NotifyTitle", title)
        resultIntent.putExtra("NotifyMessage", message)
        stackBuilder.addNextIntent(resultIntent)
        val resultPendingIntent: PendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        builder.setContentIntent(resultPendingIntent)
        builder.setAutoCancel(true)
        notificationManager.notify(12, builder.build())
    }

}