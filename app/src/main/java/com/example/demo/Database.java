package com.example.demo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database {
    SqliteHelper sqliteHelper;
    Context context;
    SQLiteDatabase sqLiteDatabase;

    public Database(Context context) {
        this.context = context;
        sqliteHelper = new SqliteHelper(context);
    }

    public void openDatabse() {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
    }

    public void closeDatabase() {
        sqliteHelper.close();
    }

    public long insert(Model model) {
        long result =0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqliteHelper.Name, model.getName());
        contentValues.put(SqliteHelper.Mobile, model.getMobile());
        contentValues.put(SqliteHelper.EMail, model.getEmail());
        contentValues.put(SqliteHelper.Password, model.getPassword());
        result=sqLiteDatabase.insert(SqliteHelper.tbl_user,null, contentValues);
        return result;
    }


    @SuppressLint("Range")
    public List<UserModel> getData() {
        List<UserModel> list = new ArrayList<>();
        String sql= "select * from "+SqliteHelper.tbl_user;
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            UserModel userModel= new UserModel();
            userModel.setId(cursor.getString(cursor.getColumnIndex(SqliteHelper.ID)));
            userModel.setName(cursor.getString(cursor.getColumnIndex(SqliteHelper.Name)));
            userModel.setMobile(cursor.getString(cursor.getColumnIndex(SqliteHelper.Mobile)));
            userModel.setEmail(cursor.getString(cursor.getColumnIndex(SqliteHelper.EMail)));
            userModel.setPassword(cursor.getString(cursor.getColumnIndex(SqliteHelper.Password)));
            list.add(userModel);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}

























//        public void insert(String name,String mobile,String email,String password){
//        ContentValues values = new ContentValues();
//        values.put(SqliteHelper.Name,name);
//        values.put(SqliteHelper.Mobile,mobile);
//        values.put(SqliteHelper.EMail,email);
//        values.put(SqliteHelper.Password,password);
//        sqLiteDatabase.insert("tbl_user",null,values);
//    }
//    public void select(){
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_user",new String[]{});
//
//    }


