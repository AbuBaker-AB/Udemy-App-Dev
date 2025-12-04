package com.example.shamelessself_promoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val previewButton: Button = findViewById(R.id.previewButton)
        previewButton.setOnClickListener {
            // Handle preview button click
            onPreviewClicked()

        }

    }

    private fun onPreviewClicked() {
        val contactNameEditText: TextInputEditText = findViewById(R.id.contactNameEt)
        val contactNumberEditText: TextInputEditText = findViewById(R.id.contactNumber)
        val displayNameEditText: TextInputEditText = findViewById(R.id.myDisplayName)
        val messageEditText: TextInputEditText = findViewById(R.id.messageEt)

        val testString =contactNameEditText.text.toString() + ", " + contactNumberEditText.text.toString()
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}