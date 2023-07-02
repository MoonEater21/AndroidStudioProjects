package org.project.petapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataAdapter dbcenter;
    Button btnSave;
    EditText txtKodeMember, txtNama, txtJenisKelamin, txtTanggalLahir, txtAlasan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbcenter = new DataAdapter(this);
        txtKodeMember = (EditText) findViewById(R.id.etKode);
        txtNama = (EditText) findViewById(R.id.etNama);
        txtJenisKelamin = (EditText) findViewById(R.id.etJenisKelamin);
        txtTanggalLahir = (EditText) findViewById(R.id.etTanggalLahir);
        txtAlasan = (EditText) findViewById(R.id.etAlasan);
        btnSave = (Button) findViewById(R.id.bSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("insert into kucing (no, kode, nama, jeniskelamin, tanggallahir, alasan) values (NULL, '" +
                        txtKodeMember.getText().toString() + "', '" +
                        txtNama.getText().toString() + "', '" +
                        txtJenisKelamin.getText().toString() + "', '" +
                        txtTanggalLahir.getText().toString() + "', '" +
                        txtAlasan.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                MainActivity.ma.refreshList();
                finish();
            }
        });
    }
}