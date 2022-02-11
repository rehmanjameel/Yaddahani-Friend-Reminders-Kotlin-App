package com.example.yaddahani.friendsmodule

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.RealPathUtils
import com.example.yaddahani.mainfragments.RegistrationFragment
import kotlinx.android.synthetic.main.fragment_update_user.*
import kotlinx.android.synthetic.main.fragment_update_user.view.*
import me.ibrahimsn.lib.SmoothBottomBar
import pk.codebase.requests.FormData
import pk.codebase.requests.HttpHeaders
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.io.File
import java.lang.Appendable
import java.lang.Exception

class UpdateUserFragment : Fragment() {

    private lateinit var bottomNavigationView: SmoothBottomBar

    private lateinit var updateBackArrowImageView: ImageView
    private val appGlobals = AppGlobals()
//    private var radioButtonText = ""
//    private lateinit var radioGroup: RadioGroup
    var imageUri: Uri? = null
//    private lateinit var radioButtons: RadioButton
    private lateinit var realPathUtil: RealPathUtils
    private var imageRealPath: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = requireActivity().findViewById(R.id.smoothBottomId)
        bottomNavigationView.visibility = View.GONE

        val firstName = appGlobals.getValueString("profileFirstName")
        val image = appGlobals.getValueString("profileImage")
        val lastName = appGlobals.getValueString("profileLastName")
        val phone = appGlobals.getValueString("profileContact")
//        val gender = appGlobals.getValueString("profileGender")
        //Set the data
        view.updateFirstNameETId.setText(firstName)
        view.updateLastNameETId.setText(lastName)
        view.updateContactETId.setText(phone)

        Glide.with(requireContext())
            .load("${AppGlobals.SERVER}${image}")
            .error(R.drawable.broken_image_24)
            .placeholder(R.drawable.profile)
            .into(view.updateProfileImageView)

//        radioGroup = view.updateRadioGroupId
        updateBackArrowImageView = view.findViewById(R.id.updateBackArrowId)

        updateBackArrowImageView.setOnClickListener {
            findNavController().popBackStack(R.id.action_updateUserFragment_to_profileFragmentId, false)
            findNavController().popBackStack()
        }

        view.updateProfileImageView.setOnClickListener {
            pickImage()
        }

        view.updateProfileButtonId.setOnClickListener {
            updateProfile()
        }
    }

    //private function to check the image is selected or not
    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                //image picked
                //get image uri
                val intent = result.data
                if (intent != null) {
                    imageUri = intent.data!!

                    Glide.with(requireContext())
                        .load(imageUri)
                        .into(updateProfileImageView)
                    imagePath()
                }
//                addUserImageView.setImageURI(imageUri)

                showToast("Image Picked From Gallery")

                Log.e("Imageuri", imageUri.toString())
            } else {
                showToast("Cancelled")
            }
        }
    )


    //Toast Function
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("WrongConstant")
    private fun pickImage() {
        //Check Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Check permission is granted or not to pick the image from external storage
            if (PermissionChecker.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permission, RegistrationFragment.PERMISSION_CODE)
            } else {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                galleryActivityResultLauncher.launch(intent)
            }
        } else {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            galleryActivityResultLauncher.launch(intent)
        }
    }

    //Only for checking the path of image
    private fun imagePath() {
        realPathUtil = RealPathUtils()
        imageRealPath = realPathUtil.getRealPath(requireContext(), imageUri)
    }

//    private fun getRadioButtonText() {
        //Getting radio button text on the base of radio button id
//        val radioButtonId: Int = radioGroup.checkedRadioButtonId
//        if (radioButtonId != -1) {
//            radioButtons = requireView().findViewById(radioButtonId)
//        }
//        radioButtonText = radioButtons.text.toString()
//    }

    private fun updateProfile() {
        //Get image path
        realPathUtil = RealPathUtils()
        imageRealPath = realPathUtil.getRealPath(requireContext(), imageUri)

        //
//        getRadioButtonText()

        //
        val httpRequest = HttpRequest()
        httpRequest.setOnResponseListener { profileUpdateResponse ->

            Log.e("Profile Updated", profileUpdateResponse.text)

            if (profileUpdateResponse.code == HttpResponse.HTTP_OK) {
                findNavController().popBackStack(R.id.action_updateUserFragment_to_profileFragmentId, false)
                findNavController().popBackStack()
                Log.e("Profile Updated", profileUpdateResponse.code.toString())
            }
        }
        httpRequest.setOnErrorListener {
            Log.e("Error in update", "$it")
        }

        val formData = FormData()
        try {
            formData.put("first_name", updateFirstNameETId.text.toString())
            formData.put("last_name", updateLastNameETId.text.toString())
//            formData.put("gender", radioButtonText)
            formData.put("phone_number", updateContactETId.text.toString())
            if (imageUri != null) {
                formData.put("image", File(imageRealPath))
            }
        } catch (e: Exception) {

        }
        val tokenHeader = appGlobals.getValueString("userToken")
        val header = HttpHeaders("Authorization", "Token $tokenHeader")
        httpRequest.put(AppGlobals.UPDATE_PROFILE_API, formData, header)
    }
}