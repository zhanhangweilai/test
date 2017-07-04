package com.example.lh.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lihang on 17-6-29.
 */

class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String database_name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,database_name, factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS person (_id INTEGER PRIMARY KEY AUTOINCREMENT name VARCHAR(20) age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("ALTER TABLE person ADD COLUME sex VARCHAR(10)");
    }
}
