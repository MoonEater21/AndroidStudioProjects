package org.project.luaslingkaranapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity()  {
    lateinit var btSubmit : Button
    lateinit var etuserName : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSubmit = findViewById(R.id.btnSubmit)
        etuserName = findViewById(R.id.etUserName)

        btSubmit.setOnClickListener {
            startActivity(Intent(this, Username::class.java)
                .putExtra("username", etuserName.text.toString()))
        }
    }
}