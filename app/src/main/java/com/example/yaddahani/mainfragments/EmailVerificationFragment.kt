package com.example.yaddahani.mainfragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_email_verification.view.*
import org.json.JSONObject
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Appendable
import java.lang.Exception

@SuppressLint("ResourceAsColor", "UseCompatLoadingForColorStateLists", "SetTextI18n")
@RequiresApi(Build.VERSION_CODES.M)

class EmailVerificationFragment : Fragment() {

    private lateinit var countTime: TextView
    private lateinit var resendButton: Button
    private lateinit var emailVerificationButton: Button
    private lateinit var userVerificationEmail: TextView
    private lateinit var verificationBackArrow: ImageView
    private lateinit var otpVerifyEditText: TextInputEditText
    private lateinit var countDownTimer : CountDownTimer

    private var email = ""
    lateinit var sharedPreferences: SharedPreferences
    private val httpRequest = HttpRequest()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email_verification, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                fragmentManager.beginTransaction().replace(R.id.fragment, RegistrationFragment())
                    .addToBackStack(null).commit()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countTime = view.countDownTimerId
        resendButton = view.resendOTPButtonId
        emailVerificationButton = view.emailVerificationButtonId
        userVerificationEmail = view.verificationEmailId
        otpVerifyEditText = view.otpVerifyETId
        verificationBackArrow = view.verifyEmailBackArrowId

        sharedPreferences = this.activity!!.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        email = sharedPreferences.getString("email", "").toString()
        userVerificationEmail.text = email

        startCountDownTimer()

        emailVerificationButton.setOnClickListener {
            verifyEmail()
        }

        resendButton.setOnClickListener {
            reSendOTP()
        }

        verificationBackArrow.setOnClickListener {
            val fragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().replace(R.id.fragment, RegistrationFragment())
                .addToBackStack(null).commit()
//            findNavController().popBackStack(R.id.action_emailVerificationFragment_to_registrationFragment, true)
//            findNavController().popBackStack()
        }

    }


    //CountDown Timer
    private fun startCountDownTimer() {
        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.text = "Resend in: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                resendButton.isClickable = true
                resendButton.backgroundTintList = activity?.getColorStateList(R.color.purple_500)
            }
        }.start()
    }

    //Verify Account
    private fun verifyEmail() {

        httpRequest.setOnResponseListener { otpVerifyResponse ->

            Log.e("verify Code", otpVerifyResponse.code.toString())
            Log.e("verify Text", otpVerifyResponse.text.toString())

            if (otpVerifyResponse.code == HttpResponse.HTTP_OK) {
                Toast.makeText(requireContext(), "Account Verified", Toast.LENGTH_SHORT).show()
                startCountDownTimer()
                countDownTimer.cancel()
                Log.e("timer", "$countDownTimer")

                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                fragmentManager.beginTransaction().replace(R.id.fragment, LoginFragment())
                    .addToBackStack(null).commit()
//                findNavController().popBackStack()
            }
        }
        httpRequest.setOnErrorListener {
            Log.e("Response Error", "$it")
        }

        val jsonObject = JSONObject()
        try {
            jsonObject.put("email", email)
            jsonObject.put("otp", otpVerifyEditText.text.toString())
        } catch (e: Exception) {
            Log.e("JSonException", "$e")
        }
        httpRequest.post(AppGlobals.ACTIVATE_ACCOUNT_API, jsonObject)
    }

    //Resend OTP function
    private fun reSendOTP() {
//        val userEmail = sharedPreferences.getString("email", "")
        httpRequest.setOnResponseListener { otpResponse ->
            Log.e("Otp Code", otpResponse.code.toString())
            Log.e("Otp Text", otpResponse.text.toString())
            if (otpResponse.code == HttpResponse.HTTP_OK) {
                Toast.makeText(requireContext(), "OTP Sent", Toast.LENGTH_SHORT).show()
                Log.e("OTP Response", "${otpResponse.code}")

                //Disable button again and restart the timer
                resendButton.isClickable = false
                resendButton.backgroundTintList = activity?.getColorStateList(R.color.offWhite)
                startCountDownTimer()

            }
        }
        httpRequest.setOnErrorListener {
            Log.e("Response Error", "$it")
        }

        val jsonObject = JSONObject()
        try {
            jsonObject.put("email", email)
        } catch (e: Exception) {
            Log.e("JSonException", "$e")
        }
        httpRequest.post(AppGlobals.REQUEST_OTP_API, jsonObject)
    }
}