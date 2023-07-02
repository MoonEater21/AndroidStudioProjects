package com.example.gudangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gudangapp.R;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataAdapter dbcenter;
    Button btnSave;
    EditText txtKodeBarang, txtNamaBarang, txtJenisBarang, txtTanggalKirim, txtTanggalSampai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbcenter = new DataAdapter(this);
        txtKodeBarang = (EditText) findViewById(R.id.etKode);
        txtNamaBarang = (EditText) findViewById(R.id.etNama);
        txtJenisBarang = (EditText) findViewById(R.id.etJenisBarang);
        txtTanggalKirim = (EditText) findViewById(R.id.etTanggalKirim);
        txtTanggalSampai = (EditText) findViewById(R.id.etTanggalSampai);
        btnSave = (Button) findViewById(R.id.bSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("insert into gudang (no, kodebarang, namabarang, jenisbarang, tanggalkirim, tanggalsampai) values (NULL, '" +
                        txtKodeBarang.getText().toString() + "', '" +
                        txtNamaBarang.getText().toString() + "', '" +
                        txtJenisBarang.getText().toString() + "', '" +
                        txtTanggalKirim.getText().toString() + "', '" +
                        txtTanggalSampai.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                MainActivity.ma.refreshList();
                finish();
            }
        });
    }
}