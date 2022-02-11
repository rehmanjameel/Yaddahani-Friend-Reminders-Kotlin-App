package com.codebase.yaddahani.friendsmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.ViewAnimator
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.codebase.yaddahani.AppGlobals
import com.codebase.yaddahani.R
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: SmoothBottomBar
    private val appGlobals = AppGlobals()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.friends_menu)
        bottomNavigationView = findViewById(R.id.smoothBottomId)

        val navController = findNavController(R.id.homeFragment)

        val  menus = popupMenu.menu
        bottomNavigationView.setupWithNavController(menus, navController)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.friendReminderFragmentId, R.id.friendListFragmentId, R.id.profileFragmentId))
        setupActionBarWithNavController(navController, appBarConfiguration)

        FirebaseApp.initializeApp(applicationContext)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task : Task<String?> ->
            if (task.isSuccessful) {
                val token = task.result
                Log.e("FCM token", token.toString())
                appGlobals.saveString("saveFCMToken", "$token")
            }
        }

        //*****//
        updateFCMToken()
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
}