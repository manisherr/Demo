package com.example.demo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {
    private EditText et_name,et_mobile,et_email, et_password;
    private TextView err_name,err_mobile,err_email, err_password;
    private Button rgbtn;

//    List<UserModel> mylist=new ArrayList<>();
    Model model = new Model();

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        et_name=(EditText) findViewById(R.id.et_name);
        et_mobile=(EditText) findViewById(R.id.et_mobile);
        et_email=(EditText) findViewById(R.id.et_email);
        et_password=(EditText) findViewById(R.id.et_password);
        err_name = (TextView) findViewById(R.id.err_name);
        err_mobile= (TextView) findViewById(R.id.err_mobile);
        err_email = (TextView) findViewById(R.id.err_email);
        err_password = (TextView) findViewById(R.id.err_password);
        rgbtn = findViewById(R.id.rgbtn);

        rgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(et_name!=null && et_name.getText().toString().equalsIgnoreCase(""))
                {
                    err_name.setText("Name is Required");
                }
                else if(et_email != null && et_email.getText().toString().equalsIgnoreCase(""))
                {
                    err_email.setText("Email is Required");
                }
                else if(et_mobile != null && et_mobile.getText().toString().equalsIgnoreCase(""))
                {
                    err_mobile.setText("Mobile is Required");
                }
                else if(et_password != null && et_password.getText().toString().equalsIgnoreCase(""))
                {
                    err_password.setText("Password is Required");
                }

                else {
                    model.setName(et_name.getText().toString());
                    model.setMobile(et_mobile.getText().toString());
                    model.setEmail(et_email.getText().toString());
                    model.setPassword(et_password.getText().toString());

                    Database database = new Database(RegistrationActivity.this);
                    database.openDatabse();
//
//                    Model model = new Model();
//                    model.setName(et_name.getText().toString());
//                    model.setEmail(et_email.getText().toString());
//                    model.setMobile(et_mobile.getText().toString());
//                    model.setPassword(et_password.getText().toString());



                  long result =  database.insert(model);
                    database.closeDatabase();
                    if(result>0){
                        Toast.makeText(RegistrationActivity.this, "Registrattion Success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
//                        i.putExtra("mydata", (Serializable) model);
//                        i.putExtra("mylistdata", (Serializable) mylist);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();

    }

    public void login(View view) {
        Intent i =new Intent(RegistrationActivity.this,MainActivity.class);
        startActivity(i);
    }


}