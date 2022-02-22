package com.oluwasegun.loggingactivitylifecycle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception


val ACTIVITY_TAG = "MainActivity: "
class MainActivity : AppCompatActivity() {
    private lateinit var editTextTo: EditText
    private lateinit var editTextSubject: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var btnSend: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTo = findViewById(R.id.edit_email_recipient)
        editTextSubject = findViewById(R.id.edit_email_subject)
        editTextMessage = findViewById(R.id.edit_email_message)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener { sendMail() }

        Log.i(ACTIVITY_TAG, "onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ACTIVITY_TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ACTIVITY_TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ACTIVITY_TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ACTIVITY_TAG, "onStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ACTIVITY_TAG, "onRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ACTIVITY_TAG, "onDestroy called")
    }

    private fun sendMail(){
//        var recipientList = editTextTo.text.toString()
//        var recipients = arrayListOf<String>()
//        recipients = recipientList.split(",") as ArrayList<String>
//
//        var subject = editTextSubject.text.toString()
//        var message = editTextMessage.text.toString()

        var recipients = editTextTo.text.toString().trim()
        var subject = editTextSubject.text.toString().trim()
        var message = editTextMessage.text.toString().trim()

        var intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, recipients)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)


        try {

            startActivity(Intent.createChooser(intent,"Use this app always"))

        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }




    }
}