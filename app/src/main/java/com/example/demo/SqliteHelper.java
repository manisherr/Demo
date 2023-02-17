package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.net.CacheRequest;

public class SqliteHelper extends SQLiteOpenHelper {
    public static final String dbname="my.db";
    public static final int dbvirsion=1;
    public static final String ID="_id";
    public static final String Name="name";
    public static final String Mobile = "mobile";
    public static final String EMail = "email";
    public static final String Password="password";
    public static final String tbl_user="tbl_user";
    public static final String create_tbl_user="CREATE TABLE "+tbl_user+"("+ID+ " INTEGER Primary key AUTOINCREMENT,"+
            Name+" TEXT,"
            +Mobile+" TEXT," +
            EMail+" TEXT,"+
            Password+" TEXT"+")";
    SqliteHelper(Context context){
        super(context,dbname,null,dbvirsion);
    }
    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_tbl_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
