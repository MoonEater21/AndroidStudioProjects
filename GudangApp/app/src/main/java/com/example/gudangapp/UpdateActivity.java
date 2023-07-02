package com.example.gudangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataAdapter dbcenter;
    Button btnUpdate;
    EditText txtKodeBarang, txtNamaBarang, txtJenisBarang, txtTanggalKirim, txtTanggalSampai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbcenter = new DataAdapter(this);
        txtKodeBarang = (EditText) findViewById(R.id.etKode);
        txtNamaBarang = (EditText) findViewById(R.id.etNama);
        txtJenisBarang = (EditText) findViewById(R.id.etJenisBarang);
        txtTanggalKirim = (EditText) findViewById(R.id.etTanggalKirim);
        txtTanggalSampai = (EditText) findViewById(R.id.etTanggalSampai);
        btnUpdate = (Button) findViewById(R.id.bUpdate);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM gudang WHERE namabarang ='"+
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            txtKodeBarang.setText(cursor.getString(1).toString());
            txtNamaBarang.setText(cursor.getString(2).toString());
            txtJenisBarang.setText(cursor.getString(3).toString());
            txtTanggalKirim.setText(cursor.getString(4).toString());
            txtTanggalSampai.setText(cursor.getString(5).toString());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("update gudang set kodebarang='" +
                        txtKodeBarang.getText().toString() + "',  namabarang='" +
                        txtNamaBarang.getText().toString() + "', jenisbarang='" +
                        txtJenisBarang.getText().toString() + "', tanggalkirim='" +
                        txtTanggalKirim.getText().toString() + "', tanggalsampai='" +
                        txtTanggalSampai.getText().toString() + "' where namabarang='" +
                        getIntent().getStringExtra("nama") + "'");
                Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
                MainActivity.ma.refreshList();
                finish();
            }
        });
    }
}