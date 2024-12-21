package com.example.nimbusclock

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        var btn=findViewById<MaterialButton>(R.id.stopwatch)
        var btn1=findViewById<MaterialButton>(R.id.timer)
        var btn2=findViewById<MaterialButton>(R.id.pomodorotimer)

        btn.setOnClickListener{
            var intent=Intent(this, StopWatch::class.java)
            startActivity(intent)
        }
        btn1.setOnClickListener{
            var intent=Intent(this, Timer::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            var intent=Intent(this, PomodoroTimer::class.java)
            startActivity(intent)
        }
    }
}