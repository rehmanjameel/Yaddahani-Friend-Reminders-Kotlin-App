package com.example.yaddahani.mainfragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.yaddahani.AppGlobals
import com.example.yaddahani.R
import com.example.yaddahani.RealPathUtils
import com.google.android.material.textfield.TextInputEditText
import de.hdodenhof.circleimageview.CircleImageView
import org.json.JSONObject
import pk.codebase.requests.FormData
import pk.codebase.requests.HttpRequest
import pk.codebase.requests.HttpResponse
import java.io.File
import java.util.*
import java.util.regex.Pattern


@RequiresApi(Build.VERSION_CODES.M)
class RegistrationFragment : Fragment() {

    private lateinit var loginText: TextView
    private lateinit var backArrowImageView: ImageView
    private lateinit var registrationButton: Button
    private lateinit var addUserImageView: CircleImageView

    private lateinit var registerUserName: TextInputEditText
    private lateinit var registerFirstName: TextInputEditText
    private lateinit var registerLastName: TextInputEditText
    private lateinit var registerEmail: TextInputEditText
    private lateinit var registerPassword: TextInputEditText
    private lateinit var userDateOfBirth: EditText
    private lateinit var userPhone: TextInputEditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtons: RadioButton

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    var imageUri: Uri? = null
    private lateinit var realPathUtil: RealPathUtils

    private var imageRealPath: String = ""
    private var radioButtonText = ""
    private val httpRequest = HttpRequest()

    companion object {
        val PERMISSION_CODE = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                fragmentManager.beginTransaction().replace(R.id.fragment, LoginFragment())
                    .addToBackStack(null).commit()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginText = view.findViewById(R.id.moveOnLoginPageId)

        //Initializing the all registrations fields
        backArrowImageView = view.findViewById(R.id.registrationBackArrowId)
        registrationButton = view.findViewById(R.id.registerUserButtonId)
        addUserImageView = view.findViewById(R.id.addUserImageView)

        registerUserName = view.findViewById(R.id.userNameETId)
        registerFirstName = view.findViewById(R.id.firstNameETId)
        registerLastName = view.findViewById(R.id.lastNameETId)
        registerEmail = view.findViewById(R.id.userEmailETId)
        userDateOfBirth = view.findViewById(R.id.dobETId)
        userPhone = view.findViewById(R.id.mobileNoETId)
        registerPassword = view.findViewById(R.id.userPasswordETId)
        radioGroup = view.findViewById(R.id.radioGroupId)

        sharedPreferences = this.requireActivity().getSharedPreferences("sharedPrefs", MODE_PRIVATE)        //Buttons clickListeners
        registrationButton.setOnClickListener {
            registerUser()
//            findNavController().navigate(R.id.action_registrationFragment_to_emailVerificationFragment)

        }

        loginText.setOnClickListener {
            val fragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().replace(R.id.fragment, LoginFragment())
                .addToBackStack(null).commit()
        }

        backArrowImageView.setOnClickListener {
            val fragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().replace(R.id.fragment, LoginFragment())
                .addToBackStack(null).commit()
        }

        userDateOfBirth.setOnClickListener {
            clickDatePicker()
        }

        addUserImageView.setOnClickListener {
            pickImage()
        }
    }
    private val requestPermissionLauncher = registerForActivityResult(
        RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your
            // app.
        } else {
            // Explain to the user that the feature is unavailable because the
            // features requires a permission that the user has denied. At the
            // same time, respect the user's decision. Don't link to system
            // settings in an effort to convince the user to change their
            // decision.
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
                        .into(addUserImageView)
                    imagePath()
                }
//                addUserImageView.setImageURI(imageUri)

//                showToast("Image Picked From Gallery")

                Log.e("Imageuri", imageUri.toString())
            }
//            else {
//                showToast("Cancelled")
//            }
        })

    @SuppressLint("WrongConstant")
    private fun pickImage() {
        //Check Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Check permission is granted or not to pick the image from external storage
            if (checkSelfPermission(requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(requireActivity(), permission, PERMISSION_CODE)

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

    private fun getRadioButtonText() {
        //Getting radio button text on the base of radio button id
        val radioButtonId: Int = radioGroup.checkedRadioButtonId
        if (radioButtonId != -1) {
            radioButtons = requireView().findViewById(radioButtonId)
        }
        radioButtonText = radioButtons.text.toString()
    }

    //Toast Function
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun registerUser() {
        val userName = registerUserName.text.toString()
        val firstName = registerFirstName.text.toString()
        val lastName = registerLastName.text.toString()
        val userEmail = registerEmail.text.toString()
        val userPassword = registerPassword.text.toString()
        val userPhoneNo = userPhone.text.toString()
        val userDoB = userDateOfBirth.text.toString()

        //Get image path
        imagePath()

        //Get Radio Button functionality
        getRadioButtonText()

        //
        if (userName.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && userEmail.isEmpty() && userPassword.isEmpty()
            && userDoB.isEmpty() && userPhoneNo.isEmpty()) {
            registerUserName.error = "User name required"
            registerFirstName.error = "First name required"
            registerLastName.error = "Last name required"
            registerEmail.error = "Email required"
            registerPassword.error = "Password required"
            userDateOfBirth.error = "DoB required"
            userPhone.error = "Phone no. required"
        } else if (userName.isEmpty()) {
            registerUserName.error = "User name required"
        } else if (firstName.isEmpty()) {
            registerFirstName.error = "First name required"
        } else if (lastName.isEmpty()) {
            registerLastName.error = "Last name required"
        } else if (userEmail.isEmpty()) {
            registerEmail.error = "Empty field"
        } else if (userPassword.isEmpty()) {
            registerPassword.error = "Password required"
        } else if (userDoB.isEmpty()) {
            userDateOfBirth.error = "DoB required"
        } else if (userPhoneNo.isEmpty()) {
            userPhone.error = "Phone no. required only digits required"
        } else if (!isValidMobile(userPhoneNo)) {
            userPhone.error = "Invalid Number"
        } else if (!isValidMail(userEmail)) {
            registerEmail.error = "Invalid email eg. abc12@gmail.com"
        }
//        else if (imageRealPath == "null") {
//            Toast.makeText(requireContext(), "Image not selected", Toast.LENGTH_SHORT).show()
//        }
        else {
            httpPutFunction()
        }
    }

    private fun isValidMail(email: String): Boolean {
        val EMAIL_STRING = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        return Pattern.compile(EMAIL_STRING).matcher(email).matches()
    }

    private fun isValidMobile(phone: String): Boolean {
        val phoneValidation = ("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}\$|^\\d{11}\$|^\\d{4}-\\d{7}\$")
        return Pattern.compile(phoneValidation).matcher(phone).matches()
    }
    // HttpRequest Function
    private fun httpPutFunction() {
        //Get image path
        realPathUtil = RealPathUtils()
        imageRealPath = realPathUtil.getRealPath(requireContext(), imageUri)

        //Get Radio Button functionality
        getRadioButtonText()
        Log.e("Radio Button text", radioButtonText)
        Log.e("Email",registerEmail.text.toString())

        httpRequest.setOnResponseListener { response ->
            Log.e("Registration Response", response.text)

            if (response.code == HttpResponse.HTTP_CREATED) {
                Log.e("Registration Response", "${response.code}")

//                findNavController().navigate(R.id.action_registrationFragment_to_emailVerificationFragment)
                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                fragmentManager.beginTransaction().replace(R.id.fragment, EmailVerificationFragment())
                    .addToBackStack(null).commit()

                Toast.makeText(requireContext(), "Data sent", Toast.LENGTH_SHORT).show()
                sendOTP()
            }
        }

        httpRequest.setOnErrorListener {
//            Log.e("Registration Error", response.reason)
            Log.e("Response Error", it.reason)
        }

        val formData = FormData()
        try {
            formData.put("username", registerUserName.text.toString())
            formData.put("first_name", registerFirstName.text.toString())
            formData.put("last_name", registerLastName.text.toString())
            formData.put("email", registerEmail.text.toString())
            formData.put("date_of_birth", userDateOfBirth.text.toString())
            formData.put("password", registerPassword.text.toString())
            formData.put("phone_number", userPhone.text.toString())
            formData.put("gender", radioButtonText)
            formData.put("image", File(imageRealPath))
        } catch (e: Exception) {
            Log.e("JSonException", "$e")
        }

        editor = sharedPreferences.edit()
        editor.putString("email", registerEmail.text.toString())
        editor.apply()
        httpRequest.post(AppGlobals.REGISTER_API, formData)
    }

    private fun sendOTP() {
        val userEmail = sharedPreferences.getString("email", "")
        httpRequest.setOnResponseListener { otpResponse ->
            Log.e("Otp Code", otpResponse.code.toString())
            Log.e("Otp Text", otpResponse.text.toString())
            if (otpResponse.code == HttpResponse.HTTP_OK) {
                Log.e("OTP Response", "${otpResponse.code}")
            }
        }
        httpRequest.setOnErrorListener {
            Log.e("Response Error", "$it")
        }

        val jsonObject = JSONObject()
        try {
            jsonObject.put("email", userEmail)
        } catch (e: java.lang.Exception) {
            Log.e("JSonException", "$e")
        }
        httpRequest.post(AppGlobals.REQUEST_OTP_API, jsonObject)
    }

    //Date Picker
    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance() //This calendar class allow us to create the calendar objects
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(),
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->    //This statement will be executed once the datePicker dialogue displayed
//                Toast.makeText(
//                    requireContext(),
//                    "The Chosen year is $year, the month is $month, and the day is $selectedDayOfMonth",
//                    Toast.LENGTH_LONG
//                ).show()
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDayOfMonth"
                userDateOfBirth.setText(selectedDate)
            }, year, month, day
        )
        datePickerDialog.datePicker.maxDate = myCalendar.timeInMillis
        datePickerDialog.show()
    }

}