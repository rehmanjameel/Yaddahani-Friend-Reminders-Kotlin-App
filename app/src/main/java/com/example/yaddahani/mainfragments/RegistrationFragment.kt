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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_registration.view.*
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
    private lateinit var registerUserName: TextInputLayout
    private lateinit var registerFirstName: TextInputLayout
    private lateinit var registerLastName: TextInputLayout
    private lateinit var registerEmail: TextInputLayout
    private lateinit var registerPassword: TextInputLayout
    private lateinit var userDateOfBirth: EditText
    private lateinit var userPhone: TextInputLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtons: RadioButton

    //    private lateinit var sharedPreferences: SharedPreferences
//    private lateinit var editor: SharedPreferences.Editor
    private lateinit var realPathUtil: RealPathUtils

    private var progressBar: ProgressBar? = null
    private val verifyAppGlobals = AppGlobals()
    private var imageRealPath: String = ""
    private var radioButtonText = ""
    private val httpRequest = HttpRequest()

    var imageUri: Uri? = null

    companion object {
        val PERMISSION_CODE = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.e("Screen", "time taking")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Screen1", "time taking")

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

        Log.e("Screen2", "time taking")
        loginText = view.findViewById(R.id.moveOnLoginPageId)

        progressBar = view.registerProgress_Bar

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

//        if (appGlobals.isLoggedInOrGetValueBoolean()) {
//            val fragmentManager = parentFragmentManager
//            fragmentManager.popBackStack()
//            fragmentManager.beginTransaction().replace(R.id.fragment, EmailVerificationFragment())
//                .addToBackStack(null).commit()
//        }
//        sharedPreferences = this.requireActivity().getSharedPreferences("sharedPrefs", MODE_PRIVATE)        //Buttons clickListeners
        registrationButton.setOnClickListener {
            registerUser()
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
//    private val requestPermissionLauncher = registerForActivityResult(
//        RequestPermission()) { isGranted: Boolean ->
//        if (isGranted) {
//            // Permission is granted. Continue the action or workflow in your
//            // app.
//        } else {
//            // Explain to the user that the feature is unavailable because the
//            // features requires a permission that the user has denied. At the
//            // same time, respect the user's decision. Don't link to system
//            // settings in an effort to convince the user to change their
//            // decision.
//        }
//    }

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

                Log.e("Imageuri", imageUri.toString())
            }
        })

    @SuppressLint("WrongConstant")
    private fun pickImage() {
        //Check Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Check permission is granted or not to pick the image from external storage
            if (checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
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
        val userName = registerUserName.editText?.text.toString()
        val firstName = registerFirstName.editText?.text.toString()
        val lastName = registerLastName.editText?.text.toString()
        val userEmail = registerEmail.editText?.text.toString()
        val userPassword = registerPassword.editText?.text.toString()
        val userPhoneNo = userPhone.editText?.text.toString()
        val userDoB = userDateOfBirth.text.toString()

        //Get image path
        imagePath()

        //Get Radio Button functionality
        getRadioButtonText()

        //
        if (userName.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && userEmail.isEmpty() && userPassword.isEmpty()
            && userDoB.isEmpty() && userPhoneNo.isEmpty()
        ) {
            registerUserName.error = "User name required"
            registerFirstName.error = "First name required"
            registerLastName.error = "Last name required"
            registerEmail.error = "Email required"
            registerPassword.error = "Password required"
            userDateOfBirth.error = "DoB required"
            userPhone.error = "Phone no. required"
        } else if (userName.isEmpty()) {
            registerUserName.error = "User name required"
        } else if (!isValidUserName(userName)) {
            registerUserName.error =
                "min 4 characters 1 digit a-zA-Z any alphabet and no white spaces"
        } else if (firstName.isEmpty()) {
            registerFirstName.error = "First name required"
        } else if (!isValidFirstLastName(firstName)) {
            registerFirstName.error = "min 4 characters a-zA-Z0-9 any alphabet and digits"
        } else if (!isValidFirstLastName(lastName)) {
            registerLastName.error = "min 4 characters a-zA-Z0-9 any alphabet and digits"
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
            registerEmail.error = "Invalid email. hint:abc12@gmail.com"
        } else if (!isValidPasswordFormat(userPassword)) {
            registerPassword.error =
                "min 6 characters long 1 digit a-zA-Z any alphabet and no white spaces"
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
        val phoneValidation =
            ("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}\$|^\\d{11}\$|^\\d{4}-\\d{7}\$")
        return Pattern.compile(phoneValidation).matcher(phone).matches()
    }

    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
//                "(?=.*[a-z])" +         //at least 1 lower case letter
//                "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 6 characters
                    "$"
        )
        return passwordREGEX.matcher(password).matches()
    }

    fun isValidUserName(userName: String): Boolean {
        val USER_NAME =
            Pattern.compile(
                "^" +
//                        "(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z0-9])" +      //any letter
                        //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 6 characters
                        "$"
            )
        return USER_NAME.matcher(userName).matches()
    }

    fun isValidFirstLastName(userName: String): Boolean {
        val USER_NAME =
            Pattern.compile(
                "^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z0-9])" +      //any letter
                        //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                    "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 6 characters
                        "$"
            )
        return USER_NAME.matcher(userName).matches()
    }

    // HttpRequest Function for Registration
    private fun httpPutFunction() {
        //Get image path
        realPathUtil = RealPathUtils()
        imageRealPath = realPathUtil.getRealPath(requireContext(), imageUri)

        //Get Radio Button functionality
        getRadioButtonText()
        Log.e("Radio Button text", radioButtonText)
        Log.e("Email", registerEmail.editText?.text.toString())

        httpRequest.setOnResponseListener { response ->
            Log.e("Registration Response", response.text)

            if (response.code == HttpResponse.HTTP_CREATED) {
                Log.e("Registration Response", "${response.code}")
//                progressBar!!.visibility = View.VISIBLE
//                progressBar!!.progress = 100
                verifyAppGlobals.saveString(
                    "RegisterEmail",
                    registerEmail.editText?.text.toString()
                )

                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack()
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment, EmailVerificationFragment()).commit()
                verifyAppGlobals.saveString(
                    "RegisterEmail1",
                    registerEmail.editText?.text.toString()
                )

                sendOTP()
//                appGlobals.saveLoginOrBoolean(true)
            } else if (response.code != HttpResponse.HTTP_CREATED) {
                progressBar!!.visibility = View.GONE

                val builder = MaterialAlertDialogBuilder(requireContext())
                builder.setPositiveButton("Ok") { _, _ ->
                    builder.create().dismiss()
                }
                builder.setTitle("Registration Error")
                builder.setMessage(response.text)
                builder.setCancelable(false)
                builder.create().show()
//                showToast(response.text)
            }
        }

        httpRequest.setOnErrorListener {
            progressBar!!.visibility = View.GONE
            Log.e("Response Error", it.reason)
            val builder = MaterialAlertDialogBuilder(requireContext())
            builder.setPositiveButton("Ok") { _, _ ->
                builder.create().dismiss()
            }
            builder.setTitle("Server Error")
            builder.setMessage(it.reason)
            builder.setCancelable(false)
            builder.create().show()
//            showToast(it.reason)
        }

        val formData = FormData()
        try {
            formData.put("username", registerUserName.editText?.text.toString().trim())
            formData.put("first_name", registerFirstName.editText?.text.toString().trim())
            formData.put("last_name", registerLastName.editText?.text.toString().trim())
            formData.put("email", registerEmail.editText?.text.toString().trim())
            formData.put("date_of_birth", userDateOfBirth.text.toString().trim())
            formData.put("password", registerPassword.editText?.text.toString().trim())
            formData.put("phone_number", userPhone.editText?.text.toString().trim())
            formData.put("gender", radioButtonText)
            if (imageUri != null) {
                formData.put("image", File(imageRealPath))
            }
        } catch (e: Exception) {
            Log.e("JSonException", "$e")
        }

//        editor = sharedPreferences.edit()
//        editor.putString("email", registerEmail.editText?.text.toString())
//        editor.apply()
        httpRequest.post(AppGlobals.REGISTER_API, formData)
    }

    private fun sendOTP() {
        val userEmail = verifyAppGlobals.getValueString("RegisterEmail")
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
        val myCalendar =
            Calendar.getInstance() //This calendar class allow us to create the calendar objects
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->    //This statement will be executed once the datePicker dialogue displayed
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDayOfMonth"
                userDateOfBirth.setText(selectedDate)
            }, year, month, day
        )
        myCalendar.add(Calendar.YEAR, -18)
        datePickerDialog.datePicker.maxDate = myCalendar.timeInMillis
        datePickerDialog.show()
    }

}