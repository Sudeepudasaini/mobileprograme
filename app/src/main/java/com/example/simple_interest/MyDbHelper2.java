package com.example.simple_interest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class MyDbHelper2 extends SQLiteOpenHelper {
    public MyDbHelper2(Context context) {
        super(context, "MyDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mytable (id INTEGER PRIMARY KEY, name TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        onCreate(db);
    }

    public void insertData(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("address", address);
        db.insert("mytable", null, values);
    }

    public Cursor selectData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM mytable", null);
    }

    public void updateData(String id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        db.update("mytable", values, "id=?", new String[]{id});
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("mytable", "id=?", new String[]{id});
    }
}
