package com.example.profiler.ui.editprofile

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.profiler.R
import com.example.profiler.data.db.DatabaseProvider
import com.example.profiler.data.entity.ProfileEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etDob: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnUpdate: Button

    private var profileId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etFullName = findViewById(R.id.etFullName)
        etDob = findViewById(R.id.etDob)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        etAddress = findViewById(R.id.etAddress)
        btnUpdate = findViewById(R.id.btnSave)

        profileId = intent.getIntExtra("profile_id", -1)

        if (profileId == -1) {
            finish()
            return
        }

        etDob.setOnClickListener { showDatePicker() }

        loadProfileData()

        btnUpdate.text = "Update Profile"
        btnUpdate.setOnClickListener { updateProfile() }
    }

    private fun loadProfileData() {
        val dao = DatabaseProvider.getDatabase(this).profileDao()

        lifecycleScope.launch {
            val profile = withContext(Dispatchers.IO) {
                dao.getProfileById(profileId)
            }

            profile?.let {
                etFullName.setText(it.fullName)
                etDob.setText(it.dob)
                etPhone.setText(it.phone)
                etEmail.setText(it.email)
                etAddress.setText(it.address)
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            etDob.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day)

        dialog.datePicker.maxDate = System.currentTimeMillis()
        dialog.show()
    }

    private fun updateProfile() {
        val name = etFullName.text.toString().trim()
        val dob = etDob.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val address = etAddress.text.toString().trim()

        if (name.isEmpty()) {
            etFullName.error = "Required"
            return
        }
        if (dob.isEmpty()) {
            etDob.error = "Required"
            return
        }
        if (phone.isEmpty()) {
            etPhone.error = "Required"
            return
        }

        val updatedProfile = ProfileEntity(
            id = profileId,
            fullName = name,
            dob = dob,
            phone = phone,
            email = email,
            address = address
        )

        val dao = DatabaseProvider.getDatabase(this).profileDao()

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                dao.updateProfile(updatedProfile)
            }

            Toast.makeText(this@EditProfileActivity, "Profile Updated", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
