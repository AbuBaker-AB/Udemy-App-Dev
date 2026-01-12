package com.example.profiler.ui.details

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profiler.R
import com.example.profiler.data.db.DatabaseProvider
import com.example.profiler.ui.details.adapter.CustomFieldsAdapter
import com.example.profiler.ui.editprofile.EditProfileActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfileDetailsActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvDob: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddress: TextView

    private lateinit var rvCustomFields: RecyclerView
    private lateinit var customAdapter: CustomFieldsAdapter


    private var profileId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        tvName = findViewById(R.id.tvName)
        tvDob = findViewById(R.id.tvDob)
        tvPhone = findViewById(R.id.tvPhone)
        tvEmail = findViewById(R.id.tvEmail)
        tvAddress = findViewById(R.id.tvAddress)

        rvCustomFields = findViewById(R.id.rvCustomFields)

        customAdapter = CustomFieldsAdapter(emptyList())
        rvCustomFields.layoutManager = LinearLayoutManager(this)
        rvCustomFields.adapter = customAdapter

        profileId = intent.getIntExtra("profile_id", -1)

        if (profileId == -1) {
            finish()
            return
        }

        // Load Profile Data
        loadProfile()

        // Edit Button
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("profile_id", profileId)
            startActivity(intent)
        }

        // Delete Button
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        btnDelete.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Delete Profile")
                .setMessage("Are you sure you want to delete this profile?")
                .setPositiveButton("Yes") { _, _ ->

                    val dao = DatabaseProvider.getDatabase(this).profileDao()

                    lifecycleScope.launch {
                        withContext(Dispatchers.IO) {
                            dao.deleteById(profileId)
                        }
                        Toast.makeText(
                            this@ProfileDetailsActivity,
                            "Profile Deleted",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }

                }
                .setNegativeButton("No", null)
                .show()
        }
    }

    // ✅ This must be OUTSIDE onCreate
    override fun onResume() {
        super.onResume()
        loadProfile()
    }

    // ✅ This must be OUTSIDE onCreate
    private fun loadProfile() {
        val dao = DatabaseProvider.getDatabase(this).profileDao()
        val fieldDao = DatabaseProvider.getDatabase(this).profileFieldDao()

        lifecycleScope.launch {

            // 1) Load main profile
            val profile = withContext(Dispatchers.IO) {
                dao.getProfileById(profileId)
            }

            profile?.let {
                tvName.text = it.fullName
                tvDob.text = it.dob
                tvPhone.text = it.phone
                tvEmail.text = if (it.email.isEmpty()) "N/A" else it.email
                tvAddress.text = if (it.address.isEmpty()) "N/A" else it.address
            }

            // 2) Load custom fields
            val fields = withContext(Dispatchers.IO) {
                fieldDao.getFieldsForProfile(profileId)
            }

            customAdapter.updateList(fields)
        }
    }
}


/*
✅ Why this works?
    Because:
    ✅ withContext(Dispatchers.IO) must be called inside:

    kotlin code:
    [
        lifecycleScope.launch { ... }
    ]
That’s how coroutine context works.

✅ Mentor Tip (Very important)
    Rule:
    If you see:

    kotlin code:
    [
        withContext(...)
    ]
Then it must be inside:

    kotlin code:
    [
        launch { ... }
     ]
 */