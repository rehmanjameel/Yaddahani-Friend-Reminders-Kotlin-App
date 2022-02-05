package com.example.yaddahani

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.example.yaddahani.friendsmodule.HomeActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private val appGlobals = AppGlobals()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slider)
        SplashScreenImage.startAnimation(slideAnimation)
        splashTextView.startAnimation(slideAnimation)

        Handler(Looper.getMainLooper()).postDelayed(
            {
            if (appGlobals.isLoggedInOrGetValueBoolean()) {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            }, 2000
        )
    }
}