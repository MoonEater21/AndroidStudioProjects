package org.project.luaslingkaranapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Lingkaran : AppCompatActivity() {
    lateinit var btHitung : Button
    lateinit var etJari2 : EditText
    lateinit var vwHasilLingkaran : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lingkaran)

        btHitung = findViewById(R.id.btnHitung)
        etJari2 = findViewById(R.id.etJari2)
        vwHasilLingkaran = findViewById(R.id.vwHasilLuas)

        btHitung.setOnClickListener {
            var jari2 : Int = Integer.parseInt(etJari2.text.toString())
            var luas : Double = 3.14 * jari2 * jari2

        vwHasilLingkaran.text = luas.toString()
        }

    }
}