package com.example.m1andm2_diksha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class Login : AppCompatActivity() {
    lateinit var EmailErrorTextView: TextView
    lateinit var PasswordTextView: TextInputLayout
    lateinit var EmailEditText: EditText
    lateinit var PasswordEditText: TextInputEditText
    lateinit var checkbox:CheckBox
   // lateinit var CheckboxError:TextView
    lateinit var LoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_login)
     /*  var login = findViewById<TextView>(R.id.login)
       login.setOnClickListener {
           val intent1 = Intent(this, home_recycler::class.java)
           startActivity(intent1)

       }*/
       var signUp = findViewById<TextView>(R.id.sign_up)
       signUp.setOnClickListener {
           val intent1 = Intent(this, SignUp::class.java)
           startActivity(intent1)
       }


           EmailErrorTextView = findViewById(R.id.email_error_textView)
           PasswordTextView = findViewById(R.id.password_error_textView)
           EmailEditText = findViewById(R.id.email_edittext)
          PasswordEditText = findViewById(R.id.password_edittext)
       checkbox=findViewById(R.id.checkbox)

           LoginButton = findViewById(R.id.login)


           LoginButton.setOnClickListener {
               var email = EmailEditText.text.toString()
               var password = PasswordEditText.text.toString()
               EmailErrorTextView.text = ""
               PasswordTextView.helperText = ""


               if (email.isEmpty()) {
                   EmailErrorTextView.text = " *Please enter your email address"

               } else if (!checkEmail(email)) {
                   EmailErrorTextView.text = "*Please enter your valid email address"

               } else if (password.isEmpty()) {
                   PasswordTextView.helperText = "*Please enter your password"


               } else if (password.length < 6) {
                   PasswordTextView.helperText = "*Please enter atleast 6 characters"

               }else {

                   val intent1 = Intent(this, HomeRecycler::class.java)
                   startActivity(intent1)
                   finish()
               }


       }
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
            }

