package com.example.home_automation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // UI Components
    private lateinit var tvTemperature: TextView
    private lateinit var tvHumidity: TextView
    private lateinit var tvMotionStatus: TextView

    private lateinit var switchFan1: SwitchMaterial
    private lateinit var switchFan2: SwitchMaterial
    private lateinit var switchFan3: SwitchMaterial
    private lateinit var switchLight: SwitchMaterial

    private lateinit var btnAllOn: MaterialButton
    private lateinit var btnAllOff: MaterialButton

    // Sensor simulation
    private val handler = Handler(Looper.getMainLooper())
    private var sensorUpdateRunnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initializeViews()
        setupClickListeners()
        startSensorSimulation()
    }

    private fun initializeViews() {
        // Sensor displays
        tvTemperature = findViewById(R.id.tvTemperature)
        tvHumidity = findViewById(R.id.tvHumidity)
        tvMotionStatus = findViewById(R.id.tvMotionStatus)

        // Device controls
        switchFan1 = findViewById(R.id.switchFan1)
        switchFan2 = findViewById(R.id.switchFan2)
        switchFan3 = findViewById(R.id.switchFan3)
        switchLight = findViewById(R.id.switchLight)

        // Quick action buttons
        btnAllOn = findViewById(R.id.btnAllOn)
        btnAllOff = findViewById(R.id.btnAllOff)
    }

    private fun setupClickListeners() {
        // Fan 1 control
        switchFan1.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "ON" else "OFF"
            showToast("🌀 Living Room Fan turned $status")
            // Here you would typically send command to actual hardware
        }

        // Fan 2 control
        switchFan2.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "ON" else "OFF"
            showToast("🌀 Bedroom Fan turned $status")
            // Here you would typically send command to actual hardware
        }

        // Fan 3 control
        switchFan3.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "ON" else "OFF"
            showToast("🌀 Kitchen Fan turned $status")
            // Here you would typically send command to actual hardware
        }

        // Light control
        switchLight.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "ON" else "OFF"
            showToast("💡 Main Light turned $status")
            // Here you would typically send command to actual hardware
        }

        // All ON button
        btnAllOn.setOnClickListener {
            switchFan1.isChecked = true
            switchFan2.isChecked = true
            switchFan3.isChecked = true
            switchLight.isChecked = true
            showToast("✅ All devices turned ON")
        }

        // All OFF button
        btnAllOff.setOnClickListener {
            switchFan1.isChecked = false
            switchFan2.isChecked = false
            switchFan3.isChecked = false
            switchLight.isChecked = false
            showToast("❌ All devices turned OFF")
        }
    }

    private fun startSensorSimulation() {
        sensorUpdateRunnable = object : Runnable {
            override fun run() {
                updateSensorData()
                handler.postDelayed(this, 3000) // Update every 3 seconds
            }
        }
        handler.post(sensorUpdateRunnable!!)
    }

    private fun updateSensorData() {
        // Simulate temperature reading (18-35°C)
        val temperature = Random.nextInt(18, 36)
        tvTemperature.text = "${temperature}°C"

        // Simulate humidity reading (30-85%)
        val humidity = Random.nextInt(30, 86)
        tvHumidity.text = "${humidity}%"

        // Simulate motion detection with more realistic behavior
        val motionDetected = Random.nextBoolean()
        tvMotionStatus.text = if (motionDetected) "Detected" else "Clear"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up the handler
        sensorUpdateRunnable?.let { handler.removeCallbacks(it) }
    }
}