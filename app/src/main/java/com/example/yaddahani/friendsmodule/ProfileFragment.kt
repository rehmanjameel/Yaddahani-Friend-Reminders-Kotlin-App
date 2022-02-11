package com.example.yaddahani.friendsmodule

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.LoadingDialog
import com.example.yaddahani.MainActivity
import com.example.yaddahani.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_send_reminder_friend.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse

@SuppressLint("SetTextI18n")

class ProfileFragment : Fragment() {

    private lateinit var bottomNavigationView: SmoothBottomBar

    private lateinit var updateIconImage: ImageView
    lateinit var personUserName: TextView
    lateinit var firstLastName: TextView
//    lateinit var dateOfBirth: TextView
    lateinit var phoneNo: TextView
//    lateinit var email: TextView
//    lateinit var gender: TextView
    lateinit var personImage: CircleImageView
    lateinit var popUpMenuIcon: ImageView

    private val appGlobals = AppGlobals()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE

        val loadingDialog = LoadingDialog(requireActivity())

        loadingDialog.startDialog()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                loadingDialog.dismissDialog()
            }, 500)

        updateIconImage = view.findViewById(R.id.updateUserIconId)
        popUpMenuIcon = view.deleteProfileIconId

        personUserName = view.profileUserNameId
        firstLastName = view.profileNameId
//        dateOfBirth = view.profileDoBId
        phoneNo = view.profilePhoneId
//        email = view.profileEmailId
//        gender = view.profileGenderId
        personImage = view.profileImageId

        updateIconImage.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragmentId_to_updateUserFragment)
        }

        //Get profile Function
        getProfile()

        popUpMenuIcon.setOnClickListener {
            showPopup()
        }
    }

    //
    private fun showPopup() {
        val popup = PopupMenu(activity, popUpMenuIcon)

        popup.menuInflater.inflate(R.menu.delete_account_menu, popup.menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.deleteAccountMenuId -> {
                    deleteAccount()
                }
            }
            true
        })
        popup.show()
    }

    private fun getProfile() {
        val profileHttpRequest = HttpRequest()

        profileHttpRequest.setOnResponseListener { profileResponse ->
            Log.e("Profile Text", profileResponse.text)
            Log.e("Profile Code", profileResponse.code.toString())

            if (profileResponse.code == HttpResponse.HTTP_OK) {

                Log.e("Profile Code", profileResponse.code.toString())
                val jsonResponse = profileResponse.toJSONObject()
                val profileUserName = jsonResponse.getString("username")
                val profileFirstName = jsonResponse.getString("first_name")
                val profileLastName = jsonResponse.getString("last_name")
//                val profileDoB = jsonResponse.getString("date_of_birth")
                val profilePhone = jsonResponse.getString("phone_number")
//                val profileEmail = jsonResponse.getString("email")
                val profileGender = jsonResponse.getString("gender")
                val profileImage = jsonResponse.getString("image")

                personUserName.text = "User Name: $profileUserName"
                firstLastName.text = "Name:$profileFirstName $profileLastName"
//                dateOfBirth.text = "Date of Birth: $profileDoB"
                phoneNo.text = "Phone No: $profilePhone"
//                email.text = "Email: $profileEmail"
//                gender.text = "Gender: $profileGender"
                Glide.with(requireContext())
                    .load("${AppGlobals.SERVER}${profileImage}")
                    .placeholder(R.drawable.profile)
                    .error(R.drawable.broken_image_24)
                    .into(personImage)

                //
                appGlobals.saveString("profileImage", profileImage)
                appGlobals.saveString("profileFirstName", profileFirstName)
                appGlobals.saveString("profileLastName", profileLastName)
                appGlobals.saveString("profileContact", profilePhone)
                appGlobals.saveString("profileGender", profileGender)

//                progressBar!!.visibility = View.GONE
            }
        }

        profileHttpRequest.setOnErrorListener {
            Log.e("Profile Error", it.toString())
        }

        val token = appGlobals.getValueString("userToken")
        Log.e("Token in profile", token.toString())
        val headers = HttpHeaders("Authorization", "Token $token")
        profileHttpRequest.get(AppGlobals.PROFILE_GET_API, headers)
    }

    private fun deleteAccount() {
        val httpRequest = HttpRequest()

        httpRequest.setOnResponseListener { deleteAccountResponse ->

            if (deleteAccountResponse.code == HttpResponse.HTTP_OK) {
                appGlobals.logoutOrClearSharedPreference()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                requireActivity().overridePendingTransition(0, 1)
                this.requireActivity().finish()
                Log.e("Delete Account Response", deleteAccountResponse.code.toString())
            }
        }

        httpRequest.setOnErrorListener {
            Log.e("Delete Account Response", "$it")
        }

        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")
        httpRequest.delete(AppGlobals.DELETE_PROFILE_API, headers)

    }
}