package com.example.yaddahani.friendsmodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.adapters.SearchingUserAdapter
import kotlinx.android.synthetic.main.fragment_search_friend.view.*
import org.json.JSONObject
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.lang.Exception

import android.widget.Toast
import com.example.yaddahani.models.SearchUserModel
import me.ibrahimsn.lib.SmoothBottomBar
import org.json.JSONException
import kotlin.collections.ArrayList

@SuppressLint("NotifyDataSetChanged")

class SearchFriendFragment : Fragment() {
    private lateinit var bottomNavigationView: SmoothBottomBar

    private lateinit var backArrow: ImageView
    private lateinit var searchFriendET: EditText
    private lateinit var searchingUserAdapter: SearchingUserAdapter
    lateinit var recyclerView: RecyclerView
    private val searchingModel = ArrayList<SearchUserModel>()
    private val appGlobals = AppGlobals()
    private val friendSearchRequest = HttpRequest()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_friend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        backArrow = view.findViewById(R.id.searchBackArrowId)
        searchFriendET = view.searchFriendEditTextId

        recyclerView = view.friendListRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(requireContext())


//        Log.e("searching", "${appGlobals.getValueString("searchedUser")}")
//        Log.e("searching", "${appGlobals.getValueString("image")}")
//        Log.e("searching", "${appGlobals.getValueString("firstName")}")
//        Log.e("searching", "${appGlobals.getValueString("lastName")}")


        backArrow.setOnClickListener {
            findNavController().popBackStack(R.id.action_searchFriendFragment_to_friendListFragmentId, false)
            findNavController().popBackStack()
        }

        searchFriendET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    if (s.toString() == "") {
                        searchingModel.clear()
                        recyclerView.adapter?.notifyDataSetChanged()
                    } else {
                        searchFriend()
                    }
                } catch (e: JSONException) {
                    Toast.makeText(requireContext(), e.toString(), Toast.LENGTH_SHORT).show()
                }

            }

        })
    }

    private fun searchFriend() {
        var jsonObject = JSONObject()

        friendSearchRequest.setOnResponseListener { friendSearchResponse ->

            Log.e("Search ResponseText", friendSearchResponse.text)
            Log.e("Search ResponseCode", friendSearchResponse.code.toString())

            if (friendSearchResponse.code == HttpResponse.HTTP_OK) {
                Log.e("Search ResponseCode", friendSearchResponse.code.toString())
                //Create JSONArray object to get the all searched users
                val jsonArray = friendSearchResponse.toJSONArray()
                //Clear the array list for filtering the data
                searchingModel.clear()

                for (i in 0 until jsonArray!!.length()) {
                    jsonObject = jsonArray.getJSONObject(i)
                    val searchedUserName = jsonObject.getString("username")
                    val searchedImage = jsonObject.getString("image")
                    val searchedFirstName = jsonObject.getString("first_name")
                    val searchedLastName = jsonObject.getString("last_name")

                    searchingModel.add(SearchUserModel(searchedUserName.toString(), searchedImage, searchedFirstName, searchedLastName))
                    searchingUserAdapter = SearchingUserAdapter(activity!!, searchingModel)
                    recyclerView.adapter = searchingUserAdapter
                    recyclerView.adapter!!.notifyDataSetChanged()

                    appGlobals.saveString("searchedUser", searchedUserName)
//                    appGlobals.saveString("image", searchedImage)
//                    appGlobals.saveString("firstName", searchedFirstName)
//                    appGlobals.saveString("lastName", searchedLastName)
                }
            } else if (friendSearchResponse.code != HttpResponse.HTTP_OK) {
                Toast.makeText(requireContext(), friendSearchResponse.text, Toast.LENGTH_SHORT).show()
            }


        }
        friendSearchRequest.setOnErrorListener {
            Log.e("Search Error", "$it")
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }

        val token = appGlobals.getValueString("userToken")

        try {
            jsonObject.put("name", searchFriendET.text.toString())
        } catch (e: Exception) {
        }
        val headers = HttpHeaders("Authorization", "Token $token")
        //Post the search request
        friendSearchRequest.post(AppGlobals.SEARCH_USER_API, jsonObject, headers)
    }

//    private fun filter(text: String) {
//        val filteredUsers = ArrayList<SearchUserModel>()
//        searchingUserAdapter = SearchingUserAdapter(activity!!, searchingModel)
//        searchingModel.filterTo(filteredUsers) {
//            val userName = appGlobals.getValueString("searchedUser")
//            Log.e("searching", "${appGlobals.getValueString("searchedUser")}")
//            userName!!.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))
//        }
//        searchingUserAdapter.filterList(filteredUsers)
//    }

    override fun onDetach() {
        super.onDetach()

        bottomNavigationView = activity!!.findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.VISIBLE
    }
}