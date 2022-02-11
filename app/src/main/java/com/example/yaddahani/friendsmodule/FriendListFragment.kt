package com.example.yaddahani.friendsmodule

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yaddahani.*
import com.example.yaddahani.adapters.FriendListAdapter
import com.example.yaddahani.adapters.FriendsPendingRequestAdapter
import com.example.yaddahani.adapters.FriendsRemindersListAdapter
import com.example.yaddahani.adapters.SentRemindersAdapter
import com.example.yaddahani.models.FriendModel
import com.example.yaddahani.models.SearchUserModel
import com.example.yaddahani.models.SentRemindersListModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.fragment_friend_list.*
import kotlinx.android.synthetic.main.fragment_friend_list.view.*
import kotlinx.android.synthetic.main.fragment_send_reminder_friend.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONException
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse

@SuppressLint("NotifyDataSetChanged", "StaticFieldLeak")

class FriendListFragment : Fragment() {

    companion object {
        var isForeGround: Boolean = false
        lateinit var recyclerPendingRequest: RecyclerView
        lateinit var recyclerViewFriendList: RecyclerView
        lateinit var noFriendListText : TextView
        lateinit var noPendingReuestText : TextView
    }

    private lateinit var floatingActionButton: FloatingActionButton
    lateinit var adapterPendingRequest: FriendsPendingRequestAdapter
    lateinit var adapterFriendList: FriendListAdapter
    private val modelPendingRequest = ArrayList<SearchUserModel>()
    private val modelFriendList = ArrayList<FriendModel>()
    private val appGlobals = AppGlobals()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this
        val view = inflater.inflate(R.layout.fragment_friend_list, container, false)

        val loadingDialog = LoadingDialog(requireActivity())

        loadingDialog.startDialog()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                loadingDialog.dismissDialog()
            }, 1000)

        return view
    }

    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isForeGround = true

        floatingActionButton = view.findViewById(R.id.addFriendFloatingButton)

        noPendingReuestText = view.noPendingRequestTextId
        noFriendListText = view.noFriendsTextId
        //
        recyclerPendingRequest = view.pendingRequestsRecyclerId
        recyclerPendingRequest.layoutManager = LinearLayoutManager(context)

        if (recyclerPendingRequest.isEmpty()) {
            noPendingReuestText.visibility = View.VISIBLE
        } else {
            noPendingReuestText.visibility = View.GONE
        }

        //
        recyclerViewFriendList = view.friendListRecyclerView
        recyclerViewFriendList.layoutManager = LinearLayoutManager(context)

        if (recyclerViewFriendList.isEmpty()) {
            noFriendListText.visibility = View.VISIBLE
        } else {
            noFriendListText.visibility = View.GONE
        }

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_friendListFragmentId_to_searchFriendFragment)
        }

        //Get FriendRequest Function
        getFriendRequest(requireContext())

        //FriendList
        addedFriendsList(requireContext())

        Log.e("size", modelPendingRequest.size.toString())

    }


    //
    fun addedFriendsList(context: Context) {
        val addHttpRequest = HttpRequest()
        addHttpRequest.setOnResponseListener { addFriendsResponse ->
            Log.e("get ResponseText", addFriendsResponse.text)
            Log.e("get ResponseCode", addFriendsResponse.code.toString())

            if (addFriendsResponse.code == HttpResponse.HTTP_OK) {
                val jsonArray = addFriendsResponse.toJSONArray()
                Log.e("here", jsonArray.length().toString())
                modelFriendList.clear()
                for (i in 0 until jsonArray!!.length()) {
                    Log.e("heretthere", "called")

                    val jsonObject = jsonArray.getJSONObject(i)
                    val friendUserName = jsonObject.getString("username")
                    val friendImage = jsonObject.getString("image")
                    val friendFirstName = jsonObject.getString("first_name")
                    val friendLastName = jsonObject.getString("last_name")

                    modelFriendList.add(FriendModel(friendUserName, friendImage, friendFirstName, friendLastName))
                    adapterFriendList = FriendListAdapter(context, modelFriendList)
                    recyclerViewFriendList.adapter = adapterFriendList
                    recyclerViewFriendList.scrollToPosition(adapterFriendList.itemCount - 1)
                    modelFriendList.reverse()
                    adapterFriendList.notifyDataSetChanged()

                    noFriendListText.visibility = View.GONE
                }

            } else if (addFriendsResponse.code != HttpResponse.HTTP_OK) {
                Log.e("get ResponseText", addFriendsResponse.text)
            }

        }

        addHttpRequest.setOnErrorListener {
            noFriendsTextId.visibility = View.VISIBLE
            noFriendsTextId.text = "Connection Problem"
            Log.e("get ResponseText", it.reason)
        }

        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")

        addHttpRequest.get(AppGlobals.FRIENDS_LIST_API, headers)
    }

    //
    fun getFriendRequest(context: Context) {
        val getHttpRequest = HttpRequest()

        Log.e("ResponseText","Inside fun")

        getHttpRequest.setOnResponseListener { getRequestResponse ->
            Log.e("ResponseText", getRequestResponse.text)
            Log.e("get ResponseCode", getRequestResponse.code.toString())

            if (getRequestResponse.code == HttpResponse.HTTP_OK) {
                Log.e("get in ResponseCode", getRequestResponse.code.toString())

                val jsonArray = getRequestResponse.toJSONArray()
                modelPendingRequest.clear()
                for (i in 0 until jsonArray!!.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val getRequestUserName = jsonObject.getString("username")
                    val getRequestImage = jsonObject.getString("image")
                    val getRequestFirstName = jsonObject.getString("first_name")
                    val getRequestLastName = jsonObject.getString("last_name")

                    modelPendingRequest.add(SearchUserModel(getRequestUserName,getRequestImage,getRequestFirstName,getRequestLastName))
                    //adapter to set all data in recyclerview
                    adapterPendingRequest = FriendsPendingRequestAdapter(context)

                    adapterPendingRequest.setData(modelPendingRequest)
                    recyclerPendingRequest.adapter = adapterPendingRequest
                    Log.e("adapter", adapterPendingRequest.toString())
                    adapterPendingRequest.notifyDataSetChanged()

                    noPendingReuestText.visibility = View.GONE

                    appGlobals.saveString("requestUser", getRequestUserName)
//                    appGlobals.saveString("requestFName", getRequestFirstName)
//                    appGlobals.saveString("requestLName", getRequestLastName)
//                    appGlobals.saveString("requestImage", getRequestImage)

                }

            } else if (getRequestResponse.code != HttpResponse.HTTP_OK) {
                Toast.makeText(requireContext(), getRequestResponse.text, Toast.LENGTH_SHORT).show()
            }
        }

        getHttpRequest.setOnErrorListener {
            noPendingRequestTextId.visibility = View.VISIBLE
            noPendingRequestTextId.text = "Connection Problem"
            Log.e("Get Request Error", it.toString())
        }

        val token = appGlobals.getValueString("userToken")
        Log.e("requestToken", token.toString())
        val headers = HttpHeaders("Authorization", "Token $token")
        getHttpRequest.get(AppGlobals.GET_FRIEND_REQUEST_API, headers)
        Log.e("ResponseText","end of fun")

    }

    //
    fun acceptRequest(position: Int,
                      friendsModelArray: ArrayList<SearchUserModel>, adapter: FriendsPendingRequestAdapter, context: Context) {

        val acceptHttRequest = HttpRequest()
        val jsonObject = JSONObject()
        acceptHttRequest.setOnResponseListener { acceptResponse ->

            Log.e("accept ResponseText", acceptResponse.text)
            Log.e("accept ResponseCode", acceptResponse.code.toString())

            if (acceptResponse.code == HttpResponse.HTTP_OK) {
                Log.e("accept ResponseCode", acceptResponse.code.toString())

                Log.e("sizes", modelPendingRequest.size.toString())

                friendsModelArray.removeAt(position)
                addedFriendsList(context)
                adapter.notifyDataSetChanged()
            }
        }

        acceptHttRequest.setOnErrorListener {
            Log.e("Accept Request Error", it.toString())
        }

        val userName = appGlobals.getValueString("requestUser")
        Log.e("Accept Request", "$userName")

        try {
            jsonObject.put("username", userName)
        } catch (e: JSONException) {
            Log.e("Accept Request Error", "Error here")
        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")

        acceptHttRequest.post(AppGlobals.ACCEPT_FRIEND_REQUEST_API, jsonObject, headers)
    }

    //
    fun declineRequest(position: Int,
                       friendsModelArray: ArrayList<SearchUserModel>, adapter: FriendsPendingRequestAdapter) {
        val declineHttpRequest = HttpRequest()
        val jsonObject = JSONObject()
        declineHttpRequest.setOnResponseListener { declineResponse ->

            Log.e("get ResponseText", declineResponse.text)
            Log.e("get ResponseCode", declineResponse.code.toString())

            if (declineResponse.code == HttpResponse.HTTP_OK) {
                Log.e("sizes1", modelPendingRequest.size.toString())
                friendsModelArray.removeAt(position)

                adapter.notifyDataSetChanged()

                Log.e("get ResponseCode", declineResponse.code.toString())
            }
        }

        declineHttpRequest.setOnErrorListener {
            val builder = MaterialAlertDialogBuilder(requireContext())
            builder.setPositiveButton("Ok") {_, _, ->
                builder.create().dismiss()
            }
            builder.setTitle("Connection Problem")
            builder.setMessage(it.reason)
            builder.setCancelable(false)
            builder.create().show()
//            Log.e("Delete Request Error", activity.toString())
        }

        val userName = appGlobals.getValueString("requestUser")
        Log.e("Decline Request", "$userName")

        try {
            jsonObject.put("username", userName)
        } catch (e: JSONException) {
            Log.e("Delete Request Error", "Error here")
        }
        val token = appGlobals.getValueString("userToken")
        val headers = HttpHeaders("Authorization", "Token $token")

        declineHttpRequest.delete(AppGlobals.DELETE_FRIEND_REQUEST_API, jsonObject, headers)
    }

    override fun onResume() {
        super.onResume()
        pendingRequestsRecyclerId.layoutManager = LinearLayoutManager(context)
        isForeGround = true
    }

    override fun onStop() {
        super.onStop()
        isForeGround = false
    }
    override fun onPause() {
        super.onPause()
        isForeGround = false
    }
}