package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{
    public static final String dbname="my.db";
    public static final int dbvirsion=1;



    MyDBHelper(Context context){
        super(context,dbname,null,dbvirsion);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql="CREATE TABLE STUDENT (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE INTEGER,EMAIL TEXT)";
        database.execSQL(sql);


    }
    public void insertData(String name,String mobile,String email,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("Mobile",mobile);
        values.put("Email",email);
        database.insert("STUDENT",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
