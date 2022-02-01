package com.example.yaddahani.mainfragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.friendsmodule.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.json.JSONObject
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Exception

@RequiresApi(Build.VERSION_CODES.M)
class LoginFragment : Fragment() {

    private lateinit var registerText: TextView
    private var progressBar: ProgressBar? = null
    private lateinit var userNameEditText: TextInputEditText
    private lateinit var userPasswordEditText: TextInputEditText
    private lateinit var loginButton: Button
    private val httpLoginRequest = HttpRequest()
    private val appGlobals = AppGlobals()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity!!.finish()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerText = view.findViewById(R.id.moveOnRegisterPageId)
        userNameEditText = view.findViewById(R.id.userNameLoginETId)
        userPasswordEditText  = view.findViewById(R.id.passwordLoginETId)
        loginButton = view.findViewById(R.id.userLoginButton)

        progressBar = view.loginProgress_Bar

        //getting the value of token to save it on first login and
        //after opening the app second time go to home screen directly if user not logged out
        val getToken = appGlobals.getValueString("userToken")
        Log.e("Checking", getToken.toString())

        if (appGlobals.isLoggedInOrGetValueBoolean()) {
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(0,0)
            this.activity?.finish()
        }
//        if (getToken != "") {
//            val intent = Intent(activity, HomeActivity::class.java)
//            startActivity(intent)
//            requireActivity().overridePendingTransition(0,0)
//            this.activity?.finish()
//        }

        //
        loginButton.setOnClickListener {

            loginUser()
        }

        registerText.setOnClickListener {
            progressBar!!.visibility = View.VISIBLE
            val fragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().replace(R.id.fragment, RegistrationFragment())
                .addToBackStack("First").commit()
        }

    }

    private fun loginUser() {
        val userName = userNameEditText.text.toString().trim()
        val userPassword = userPasswordEditText.text.toString().trim()
        if (userName.isEmpty() && userPassword.isEmpty()) {
            userNameEditText.error = "User Name required"
            userPasswordEditText.error = "User password required"
        } else if (userName.isEmpty()) {
            userNameEditText.error = "User Name required"
        } else if (userPassword.isEmpty()) {
            userPasswordEditText.error = "User password required"
        } else {
            loginRequest()
            progressBar!!.visibility = View.VISIBLE
            progressBar!!.progress = 100
        }
    }

    private fun loginRequest(){
        var jsonObject = JSONObject()
//        appGlobals = AppGlobals(requireContext())

        httpLoginRequest.setOnResponseListener { loginResponse ->
            Log.e("Login Response", loginResponse.code.toString())
            Log.e("Login Text", loginResponse.text.toString())

            if (loginResponse.code in 400 .. 499){
                Toast.makeText(requireContext(), loginResponse.text, Toast.LENGTH_SHORT).show()
            }

            if (loginResponse.code == HttpResponse.HTTP_OK) {
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                requireActivity().overridePendingTransition(0,0)
                this.activity?.finish()
                appGlobals.saveLoginOrBoolean(true)
                progressBar!!.visibility = View.GONE
                Log.e("Login Response", loginResponse.code.toString())

                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()

                jsonObject = loginResponse.toJSONObject()
                val token = jsonObject.getString("token")
                val userName = jsonObject.getString("username")
//                val name = jsonObject.getString("")
                Log.e("Token", token)
                Log.e("User Name", userName)
                val check = appGlobals.saveString("userToken", token)
                appGlobals.saveString("loginUsername", userName)
                Log.e("Checking", check.toString())

            } else if (loginResponse.code != HttpResponse.HTTP_OK) {
                progressBar!!.visibility = View.GONE
                Toast.makeText(requireContext(), loginResponse.reason, Toast.LENGTH_SHORT).show()
            }
        }

        httpLoginRequest.setOnErrorListener {
            progressBar!!.visibility = View.GONE
            Toast.makeText(requireContext(), it.reason, Toast.LENGTH_SHORT).show()
            Log.e("Login Response", it.reason)
        }

        try {
            jsonObject.put("username", userNameEditText.text.toString().trim())
            jsonObject.put("password", userPasswordEditText.text.toString().trim())
        } catch (e: Exception) {
            Log.e("Login Response", e.toString())
        }

        httpLoginRequest.post(AppGlobals.LOGIN_API, jsonObject)
    }
}