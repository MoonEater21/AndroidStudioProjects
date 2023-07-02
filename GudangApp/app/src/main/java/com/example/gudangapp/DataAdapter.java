package com.example.gudangapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataAdapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gudang.db";
    private static final int DATABASE_VERSION = 1;
    public DataAdapter(Context context){
        super (context,DATABASE_NAME,null,DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE gudang(no integer PRIMARY KEY autoincrement," + " kodebarang text NULL, namabarang text NULL, jenisbarang text NULL," + " tanggalkirim text NULL,tanggalsampai text NULL);";
        Log.d("Data", "onCreate:" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO gudang (no, kodebarang, namabarang, jenisbarang, tanggalkirim, tanggalsampai)" +
                "values ('1', 'minyak', 'andi', 'minyak', '1 juni','1 juni');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
