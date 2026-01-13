package com.example.profiler.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.profiler.R
import com.example.profiler.ui.profiles.ProfilesListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Wait 2 seconds, then go to Profiles List screen
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ProfilesListActivity::class.java))
            finish()
        }, 2000)
    }
}