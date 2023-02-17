package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ForgetPasword extends AppCompatActivity {
    private EditText et_password,et_newpass,et_confirmpass;
    private TextView err_password,err_newpass,err_confpass;
    private String pass,newpass,cnfpass;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pasword);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        et_password = (EditText) findViewById(R.id.et_password);
        et_newpass = (EditText) findViewById(R.id.et_newpass);
        et_confirmpass = (EditText) findViewById(R.id.et_confirmpass);
        err_password = (TextView) findViewById(R.id.err_password);
        err_newpass = (TextView) findViewById(R.id.err_newpass);
        err_confpass = (TextView) findViewById(R.id.err_confpass);
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
        Intent i = new Intent(ForgetPasword.this, MainActivity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
    public void login(View view) {
        Intent i =new Intent(ForgetPasword.this,MainActivity.class);
        startActivity(i);
    }
    public void forgetPassword(View view) {

        pass = et_password.getText().toString();
        newpass=et_newpass.getText().toString();
        cnfpass=et_confirmpass.getText().toString();
        validatePassword(pass);
        validateNewpass(newpass);
        validateConfpass(cnfpass);
        if (validatePassword(pass) && validateNewpass(newpass) && validateConfpass(cnfpass) )  {
            Toast.makeText(this, "Forget Password Sucessfully", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(ForgetPasword.this,MainActivity.class);
            startActivity(i);
        }

    }
    public boolean validateNewpass(String newpass) {
        if (newpass.isEmpty()) {
            err_newpass.setText("Field is Required");
            return false;
        }
        err_newpass.setText("");

        return true;
    }
    public boolean validateConfpass(String cnfpass) {
        if (cnfpass.isEmpty()) {
            err_confpass.setText("Field is Required");
            return false;
        }
        err_confpass.setText("");

        return true;
    }

    public boolean validatePassword(String pass) {
        if (pass.isEmpty()) {
            err_password.setText("Field is Required");
            return false;
        }
        err_password.setText("");

        return true;
    }
}