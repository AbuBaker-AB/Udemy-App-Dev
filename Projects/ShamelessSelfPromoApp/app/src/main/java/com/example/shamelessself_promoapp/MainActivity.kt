package com.example.shamelessself_promoapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.example.shamelessself_promoapp.R

class MainActivity : AppCompatActivity() {

    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var displayNameEditText: TextInputEditText? = null
    private var messageEditText: TextInputEditText? = null
    private var juniorCheckBox: CheckBox? = null
    private var immediateCheckBox: CheckBox? = null
    private var groupSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        contactNameEditText = findViewById(R.id.contactNameEt)
//        contactNumberEditText = findViewById(R.id.contactNumber)
        displayNameEditText = findViewById(R.id.myDisplayName)
        messageEditText = findViewById(R.id.messageEt)
        juniorCheckBox = findViewById(R.id.juniorCheckBox)
        immediateCheckBox = findViewById(R.id.immediateStartCheckBox)
        groupSpinner = findViewById(R.id.groupSpinner)

        val previewButton: Button = findViewById(R.id.previewButton)
        previewButton.setOnClickListener {
            // Handle preview button click
            onPreviewClicked()

        }

    }

    private fun onPreviewClicked() {
        val testString = contactNameEditText?.text.toString() + ", " + contactNumberEditText?.text.toString()
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}