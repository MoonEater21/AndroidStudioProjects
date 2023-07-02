package org.project.petapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataAdapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kucing.db";
    private static final int DATABASE_VERSION = 1;
    public DataAdapter(Context context){
        super (context,DATABASE_NAME,null,DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE kucing(no integer PRIMARY KEY autoincrement," + " kode text NULL, nama text NULL, jeniskelamin text NULL," + " tanggallahir text NULL,alasan text NULL);";
        Log.d("Data", "onCreate:" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kucing (no, kode, nama, jeniskelamin, tanggallahir, alasan)" +
                "values ('1', 'ar', 'rajafar', 'pria', '21 juni','sangat tertarik');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
