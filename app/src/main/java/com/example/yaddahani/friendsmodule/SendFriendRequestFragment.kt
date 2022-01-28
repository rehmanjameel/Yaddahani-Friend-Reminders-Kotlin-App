package com.example.yaddahani.friendsmodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import kotlinx.android.synthetic.main.fragment_send_friend_request.view.*
import kotlinx.android.synthetic.main.fragment_update_user.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Exception

@SuppressLint("SetTextI18n")
class SendFriendRequestFragment : Fragment() {

    private lateinit var bottomNavigationView: SmoothBottomBar

    private val args by navArgs<SendFriendRequestFragmentArgs>()
    private val sendFriendHttpRequest = HttpRequest()
    private val appGlobals = AppGlobals()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_friend_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE

        view.sendRequestUserNameId.text = "User Name: ${args.searchUsers.userName}"
        view.sendRequestFirstNameId.text = "First Name: ${args.searchUsers.firstName}"
        view.sendRequestLastNameId.text = "Last Name: ${args.searchUsers.lastName}"

        Glide.with(requireActivity())
            .load("${AppGlobals.SERVER}${args.searchUsers.image}")
            .into(view.sendRequestUserImageId)

        view.sendRequestBackArrowId.setOnClickListener {
            findNavController().popBackStack(R.id.action_sendFriendRequestFragment_to_searchFriendFragment, false)
            findNavController().popBackStack()
        }

        view.sendRequestButtonId.setOnClickListener {
            sendFriendRequest()
        }
    }

    private fun sendFriendRequest() {
        val jsonObject = JSONObject()
        sendFriendHttpRequest.setOnResponseListener { friendRequestResponse ->

            Log.e("Search ResponseText", friendRequestResponse.text)
            Log.e("Search ResponseCode", friendRequestResponse.code.toString())
            if (friendRequestResponse.code == HttpResponse.HTTP_OK) {
                Toast.makeText(requireContext(), "Request Sent", Toast.LENGTH_SHORT).show()
            } else if (friendRequestResponse.code in 400 .. 499) {
                Toast.makeText(requireContext(), "Request already Sent", Toast.LENGTH_SHORT).show()
            }
        }
        sendFriendHttpRequest.setOnErrorListener {
            Log.e("Send Request Error", "Request not sent")
        }

        try {
            jsonObject.put("username", args.searchUsers.userName)
        } catch (e: Exception) {

        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")
        sendFriendHttpRequest.post(AppGlobals.SEND_FRIEND_REQUEST_API, jsonObject, headers)

    }

}