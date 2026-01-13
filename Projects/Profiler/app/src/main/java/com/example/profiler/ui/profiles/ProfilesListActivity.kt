package com.example.profiler.ui.profiles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profiler.R
import com.example.profiler.data.db.DatabaseProvider
import com.example.profiler.ui.addprofile.AddProfileActivity
import com.example.profiler.ui.profiles.adapter.ProfileAdapter
import com.example.profiler.ui.details.ProfileDetailsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfilesListActivity : AppCompatActivity() {

    private lateinit var rvProfiles: RecyclerView
    private lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles_list)

        rvProfiles = findViewById(R.id.rvProfiles)

        adapter = ProfileAdapter(emptyList()) { profile ->
            val intent = Intent(this, ProfileDetailsActivity::class.java)
            intent.putExtra("profile_id", profile.id)
            startActivity(intent)
        }

        rvProfiles.layoutManager = LinearLayoutManager(this)
        rvProfiles.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fabAddProfile).setOnClickListener {
            startActivity(Intent(this, AddProfileActivity::class.java))
        }

        loadProfilesFromDb()
    }

    override fun onResume() {
        super.onResume()
        loadProfilesFromDb()
    }

    private fun loadProfilesFromDb() {
        val dao = DatabaseProvider.getDatabase(this).profileDao()

        lifecycleScope.launch {
            val profiles = withContext(Dispatchers.IO) {
                dao.getAllProfiles()
            }
            adapter.updateList(profiles)
        }
    }
}



/*
✅ What you learned in this step
✅ 1) lifecycleScope.launch
    • Runs coroutine safely inside Activity lifecycle.

✅ 2) Dispatchers.IO
    • Database operations should run in background thread.

✅ 3) Insert only if empty
    • This prevents sample profiles from duplicating every time you open app.
 */