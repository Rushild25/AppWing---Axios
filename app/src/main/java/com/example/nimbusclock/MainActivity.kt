package com.example.nimbusclock

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btn=findViewById<MaterialButton>(R.id.btn_enter)

        btn.setOnClickListener{
            Toast.makeText(this, "You have entered into Nimbus Clock!", Toast.LENGTH_SHORT).show()
            var intent=Intent(this, MainScreen::class.java)
            startActivity(intent)
        }
    }
}