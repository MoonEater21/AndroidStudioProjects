package com.example.gudangapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    String[] regist;
    ListView ListView01;
    protected Cursor cursor;
    DataAdapter dbcenter;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreate = (Button) findViewById(R.id.bCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, CreateActivity.class);
                startActivity(i);
            }
        });
        ma = this;
        dbcenter = new DataAdapter(this);
        refreshList();
    }

    public void refreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("select * from gudang", null);
        regist = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            regist[cc] = cursor.getString(2).toString();
        }

        ListView01 = (ListView) findViewById(R.id.listCat);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, regist));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = regist[arg2];
                final CharSequence[] dialogitem = {"Read Data", "Update Data", "Delete Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Option");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch (item) {
                            case 0 :
                                Intent a = new Intent(getApplicationContext(), ReadActivity.class);
                                a.putExtra("nama",selection);
                                startActivity(a);
                                break;
                            case 1 :
                                Intent b = new Intent(getApplicationContext(), UpdateActivity.class);
                                b.putExtra("nama",selection);
                                startActivity(b);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from gudang where namabarang = '" + selection + "'");
                                refreshList();
                                break;
                        }
                }
            });
                builder.create().show();
        }});
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}