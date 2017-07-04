package com.example.lh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by lihang on 17-6-30.
 */

public class DBHelper {
    private ArrayList<Person> arrayList;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    public DBHelper(Context context, String db_name) {
        databaseHelper = new DatabaseHelper(context, db_name, null, 1);
        db = databaseHelper.getReadableDatabase();
    }

    public void query (String name) {
        db.query("person", new String[] { "_id", "name", "age" },"name = ?",new String[] {name}, null, null, null);
    }

    public void insert(ArrayList<Person> arrayList) {
        db.beginTransaction();
        try {
            for(Person person: arrayList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name",person.getName());
                contentValues.put("age",person.getAge());
                contentValues.put();
                db.insert()
            }
        }catch ()
    }

}
