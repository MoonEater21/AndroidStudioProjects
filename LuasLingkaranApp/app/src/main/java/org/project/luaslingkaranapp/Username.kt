package org.project.luaslingkaranapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Username : AppCompatActivity() {
    lateinit var btNext : Button
    lateinit var viewusername : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usernamelayout)

        btNext = findViewById(R.id.btnNext)
        viewusername = findViewById(R.id.vwHasil)

        btNext.setOnClickListener {
            startActivity(Intent(this, Lingkaran::class.java))
        }

        val username = intent.getStringExtra("username")

        viewusername.text = "Hello! " +username
    }
}