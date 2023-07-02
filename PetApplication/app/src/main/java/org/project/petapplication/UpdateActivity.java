package org.project.petapplication;

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
    EditText txtKodeMember, txtNama, txtJenisKelamin, txtTanggalLahir, txtAlasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbcenter = new DataAdapter(this);
        txtKodeMember = (EditText) findViewById(R.id.etKode);
        txtNama = (EditText) findViewById(R.id.etNama);
        txtJenisKelamin = (EditText) findViewById(R.id.etJenisKelamin);
        txtTanggalLahir = (EditText) findViewById(R.id.etTanggalLahir);
        txtAlasan = (EditText) findViewById(R.id.etAlasan);
        btnUpdate = (Button) findViewById(R.id.bUpdate);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kucing WHERE nama ='"+
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            txtKodeMember.setText(cursor.getString(1).toString());
            txtNama.setText(cursor.getString(2).toString());
            txtJenisKelamin.setText(cursor.getString(3).toString());
            txtTanggalLahir.setText(cursor.getString(4).toString());
            txtAlasan.setText(cursor.getString(5).toString());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("update kucing set kode='" +
                        txtKodeMember.getText().toString() + "',  nama='" +
                        txtNama.getText().toString() + "', jeniskelamin='" +
                        txtJenisKelamin.getText().toString() + "', tanggallahir='" +
                        txtTanggalLahir.getText().toString() + "', alasan='" +
                        txtAlasan.getText().toString() + "' where nama='" +
                        getIntent().getStringExtra("nama") + "'");
                Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
                MainActivity.ma.refreshList();
                finish();
            }
        });
    }
}