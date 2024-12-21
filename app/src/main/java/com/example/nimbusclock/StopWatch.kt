package com.example.nimbusclock

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView

class StopWatch : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var startButton: MaterialButton
    private lateinit var stopButton: MaterialButton
    private lateinit var resetButton: MaterialButton

    private var handler = Handler()
    private var startTime = 0L
    private var timeInMilliseconds = 0L
    private var timeSwapBuff = 0L
    private var updateTime = 0L
    private var isRunning = false

    private val updateTimerThread = object : Runnable {
        override fun run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime
            updateTime = timeSwapBuff + timeInMilliseconds
            val secs = (updateTime / 1000).toInt()
            val mins = secs / 60
            val milliseconds = (updateTime % 1000).toInt()
            textView.text = String.format("%02d:%02d:%02d", mins, secs % 60, milliseconds)
            handler.postDelayed(this, 0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        textView = findViewById(R.id.textview)
        startButton = findViewById(R.id.start)
        stopButton = findViewById(R.id.stop)
        resetButton = findViewById(R.id.reset)

        startButton.setOnClickListener {
            if (!isRunning) {
                startTime = SystemClock.uptimeMillis()
                handler.postDelayed(updateTimerThread, 0)
                isRunning = true
                stopButton.isEnabled = true
            }
        }

        stopButton.setOnClickListener {
            if (isRunning) {
                timeSwapBuff += timeInMilliseconds
                handler.removeCallbacks(updateTimerThread)
                isRunning = false
                stopButton.isEnabled = false
            }
        }

        resetButton.setOnClickListener {
            startTime = 0L
            timeInMilliseconds = 0L
            timeSwapBuff = 0L
            updateTime = 0L
            textView.text = "00:00:000"
            handler.removeCallbacks(updateTimerThread)
            isRunning = false
            stopButton.isEnabled = false
        }
    }
}
