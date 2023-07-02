package com.example.gudangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btnMember, btnHelp, btnOrganisasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnMember = (Button) findViewById(R.id.bMember);
        btnHelp = (Button) findViewById(R.id.bHelp);
        btnOrganisasi = (Button) findViewById(R.id.bOrganisasi);

        btnMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeActivity.this, HelpActivity.class);
                startActivity(i);
            }
        });


        btnOrganisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( HomeActivity.this, OrganisasiActivity.class);
                startActivity(i);
            }
        });
    }
}