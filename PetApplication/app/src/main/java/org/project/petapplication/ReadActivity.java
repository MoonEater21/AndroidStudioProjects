package org.project.petapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReadActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataAdapter dbcenter;
    Button btnClose;
    EditText txtKodeMember, txtNama, txtJenisKelamin, txtTanggalLahir, txtAlasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        dbcenter = new DataAdapter(this);
        txtKodeMember = (EditText) findViewById(R.id.etKode);
        txtNama = (EditText) findViewById(R.id.etNama);
        txtJenisKelamin = (EditText) findViewById(R.id.etJenisKelamin);
        txtTanggalLahir = (EditText) findViewById(R.id.etTanggalLahir);
        txtAlasan = (EditText) findViewById(R.id.etAlasan);
        btnClose = (Button) findViewById(R.id.bClose);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("select * from kucing where nama ='"+
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
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}