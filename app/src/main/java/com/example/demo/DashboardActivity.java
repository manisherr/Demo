package com.example.demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends AppCompatActivity {
    ImageView image;
    Button btn;
    public static final int CAMERA_REQ_CODE=100;
    public TextView tv_name,tv_mobile,tv_email,tv_intent;
    public String name,mobile,email;
    Button recordbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        image = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);
        tv_name=(TextView)findViewById(R.id.tv_name) ;
        tv_mobile=(TextView)findViewById(R.id.tv_mobile) ;
        tv_email=(TextView)findViewById(R.id.tv_email) ;
        tv_intent=(TextView)findViewById(R.id.tv_intent);
        recordbtn=findViewById(R.id.btn_record);



        recordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, DatabaseUsers.class);
                startActivity(i);
            }
        });


        Intent intent = getIntent();
       // intent.getSerializableExtra("mydata");
        List<UserModel> mylist= (List<UserModel>) intent.getSerializableExtra("list");

//        Model model= (Model) intent.getSerializableExtra("mydata");
        tv_name.setText(mylist.get(0).getName());
        tv_mobile.setText(mylist.get(0).getMobile());
        tv_email.setText(mylist.get(0).getEmail());

    }


    public void onClick(View view){
        Intent icamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(icamara,CAMERA_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQ_CODE){
            Bitmap pic = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(pic);
        }
    }
}



































































//        MyDBHelper dbHelper=new MyDBHelper(this);
//        SqliteHelper sqliteHelper = new SqliteHelper(this);
//        SQLiteDatabase database = sqliteHelper.getWritableDatabase();
//        StringBuilder stringBuilderNmae=new StringBuilder();
//        StringBuilder stringBuilderMobile=new StringBuilder();
//        StringBuilder stringBuilderEmail=new StringBuilder();
//        StringBuilder stringBuilder = new StringBuilder();
//        Cursor cursor = database.rawQuery("SELECT * FROM tbl_user",new String[]{});

//        if(cursor != null){
//            cursor.moveToFirst();
//        }
//        do{
//            name= cursor.getString(0);
//            mobile=cursor.getString(1);
//            email= cursor.getString(2);
//            stringBuilder.append("Name: "+name+"Mobile: "+mobile+"Email: "+email);
//        }
//        while (cursor.moveToNext());
//        stringBuilderNmae.append("Name: "+name);
//        tv_name.setText(stringBuilderNmae.toString());
//        stringBuilderMobile.append("Mobile: "+mobile);
//        tv_mobile.setText(stringBuilderMobile.toString());
//        stringBuilderEmail.append("Email: "+email);
//        tv_email.setText(stringBuilderEmail.toString());
//        textView.setText(stringBuilder.toString());










//        SqliteHelper sqliteHelper = new SqliteHelper(this);
//        SQLiteDatabase database = sqliteHelper.getWritableDatabase();
//        Cursor cursor = database.rawQuery("SELECT * FROM tbl_user",new String[]{});
//        StringBuilder stringBuilder=new StringBuilder();
//
//        if(cursor != null){
//            cursor.moveToFirst();
//        }
//        do{
//            name= cursor.getString(0);
//            mobile=cursor.getString(1);
//            email= cursor.getString(2);
//            stringBuilder.append("Name: "+name+"Mobile: "+mobile+"Email: "+email);
//        }
//        while (cursor.moveToNext());
//        textView.setText(stringBuilder.toString());