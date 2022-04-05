package com.example.m1andm2_diksha

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import de.hdodenhof.circleimageview.CircleImageView
import java.util.regex.Pattern


class SignUp : AppCompatActivity() {
    lateinit var fullNameEditText:EditText
    lateinit var fullNameErrorEditText:TextView
    lateinit var userNameEditText:EditText
    lateinit var userNameErrorTextView:TextView
    lateinit var emailEditText:EditText
    lateinit var emailErrorTextView: TextView
    lateinit var mobileNumberEditText:EditText
    lateinit var mobileNumberErrorEditText:TextView
    lateinit var passwordEditText: TextInputEditText
    lateinit var passwordErrorTextView: TextInputLayout
    lateinit var cPasswordEditText: TextInputEditText
    lateinit var cPasswordErrorTextView: TextInputLayout
    lateinit var bioEditText: TextInputEditText
    lateinit var bioError:TextInputLayout
    lateinit var checkbox: CheckBox
    lateinit var CheckboxError: TextView
    lateinit var signUpBtn: Button
    lateinit var loginEt:TextView
    lateinit var cameraImg:ImageView
     lateinit var profileImg:CircleImageView
     var SELECT_CODE=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var backButton=findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        fullNameEditText=findViewById(R.id.fullNameEditText)
        fullNameErrorEditText=findViewById(R.id.fullNameErrorTextView)
        userNameEditText=findViewById(R.id.userNameEditText)
        userNameErrorTextView=findViewById(R.id.userNameErrorTextView)
        emailEditText=findViewById(R.id.emailEditText)
        emailErrorTextView=findViewById(R.id.emailErrorTextView)
        mobileNumberEditText=findViewById(R.id.mobileNumberEditText)
        mobileNumberErrorEditText=findViewById(R.id.mobileNumberErrorTextView)
        passwordEditText=findViewById(R.id.passwordEditText)
        passwordErrorTextView=findViewById(R.id.passwordErrorTextView)
        cPasswordErrorTextView=findViewById(R.id.cPasswordErrorTextView)
        cPasswordEditText=findViewById(R.id.cPasswordEditText)
        bioEditText=findViewById(R.id.bioEditText)
        bioError=findViewById(R.id.bioErrorTextView)
        checkbox=findViewById(R.id.checkbox)
        CheckboxError=findViewById(R.id.checkbox_error)
        signUpBtn=findViewById(R.id.signUpBtn)
        loginEt=findViewById(R.id.loginEt)
        cameraImg=findViewById(R.id.camera_img)
        profileImg=findViewById(R.id.profile_img)



        cameraImg.setOnClickListener {
            val intent=Intent()
            intent.type="image/*"
            intent.action=Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"title"),SELECT_CODE)
        }

        loginEt.setOnClickListener {
            val intent1 = Intent(this, Login::class.java)
            startActivity(intent1)
            finish()
        }



        bioEditText.setOnTouchListener { v, event ->
            if (v.id === R.id.bioEditText) {
                v.parent.requestDisallowInterceptTouchEvent(true)
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_UP -> v.parent.requestDisallowInterceptTouchEvent(false)
                }
            }
            false
        }

        signUpBtn.setOnClickListener {

            var fullName=fullNameEditText.text.toString()
            var userName=userNameEditText.text.toString()
            var email = emailEditText.text.toString()
            var mobile=mobileNumberEditText.text.toString()
            var password = passwordEditText.text.toString()
            var cpassword = cPasswordEditText.text.toString()
            var bio = bioEditText.text.toString()
            fullNameErrorEditText.text=""
            emailErrorTextView.text = ""
            mobileNumberErrorEditText.text=""
            passwordErrorTextView.helperText = ""
            cPasswordErrorTextView.helperText=""
            CheckboxError.text = ""

            if(fullName.isEmpty()){
                fullNameErrorEditText.text="*Please enter your full name"
                fullNameEditText.requestFocus()
            }else if(fullName.length<2){
                fullNameErrorEditText.text="*Please enter valid name(must be atleast 2 characters)"
                fullNameEditText.requestFocus()
            }else if(!isNameValidFormate(fullName)){
                fullNameErrorEditText.text="*Please enter valid name"
                fullNameEditText.requestFocus()
            }else if(userName.isEmpty()){
                userNameErrorTextView.text="*Please enter your user name"
                userNameEditText.requestFocus()
            }else if(userName.length<2) {
                fullNameErrorEditText.text =
                    "*Please enter valid user name(must be atleast 2 characters)"
                fullNameEditText.requestFocus()
            }else if(!isUserNameValidFormate(userName)){
                userNameErrorTextView.text="*Please enter valid user name"
                userNameEditText.requestFocus()
            } else if (email.isEmpty()) {
                emailErrorTextView.text = " *Please enter your email address"
                emailEditText.requestFocus()

            } else if (!checkEmail(email)) {
                emailErrorTextView.text = "*Please enter valid email address"
                emailEditText.requestFocus()
            }else if(mobile.isEmpty()){
                mobileNumberErrorEditText.text="*Please enter your mobile number"
                mobileNumberEditText.requestFocus()
            }else if(!isMobileValidFormate(mobile) ){
                mobileNumberErrorEditText.text="*Please enter valid mobile number"
                mobileNumberEditText.requestFocus()
            } else if (password.isEmpty()) {
                passwordErrorTextView.helperText = "*Please enter your password"
                passwordEditText.requestFocus()

            }else if(password.length<6){
                passwordErrorTextView.helperText = "*Please enter password more than 6 digits"
                passwordEditText.requestFocus()
            } else if (!isValidPasswordFormat(password)) {
                passwordErrorTextView.helperText = "*Please enter valid password"
                passwordEditText.requestFocus()
            }else if(cpassword.isEmpty()){
                cPasswordErrorTextView.helperText = "*Please enter confirm password"
                cPasswordEditText.requestFocus()
            }
            else if(!cpassword.equals(password)){
                cPasswordErrorTextView.helperText = "*Both password should match"
                cPasswordEditText.requestFocus()

            }else if(checkbox.isChecked==false) {
                CheckboxError.text="*Accepting checkbox is neccessary"
            }else{
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()

            }


        }
    }
    fun isUserNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+\$");
        return nameREGEX.matcher(name).matches()
    }


    fun isNameValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("^[A-Za-z]+$");
        return nameREGEX.matcher(name).matches()
    }

    fun isMobileValidFormate(name: String): Boolean {
        val nameREGEX = Pattern.compile("[0-9]{10}");
        return nameREGEX.matcher(name).matches()
    }

    private fun checkEmail(email: String): Boolean {

        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            val uri=data?.data
            profileImg.setImageURI(uri)
        }
    }

    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 8 characters
                    "$"
        );
        return passwordREGEX.matcher(password).matches()

    }

}

