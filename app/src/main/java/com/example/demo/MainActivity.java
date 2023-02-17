package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et_username, et_password;
    private TextView err_username, err_password;
    Button btn;
    List<UserModel> mylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        err_username = (TextView) findViewById(R.id.err_username);
        err_password = (TextView) findViewById(R.id.err_password);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });

    }

    public void forgetPassword(View view) {
        Intent i = new Intent(MainActivity.this, ForgetPasword.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void register(View view) {
        Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void login(View view) {
        if(et_username!=null && et_username.getText().toString().equalsIgnoreCase(""))
        {
            err_username.setText("Field is Required");
        }
        else if(et_password != null && et_password.getText().toString().equalsIgnoreCase(""))
        {
            err_password.setText("Field is Required");
        }
        else {
            Database database= new Database(MainActivity.this);
            database.openDatabse();
            mylist=database.getData();
            database.closeDatabase();
            Intent i = new Intent(MainActivity.this, TabViewPager
                    .class);
            i.putExtra("list",(Serializable) mylist);
            startActivity(i);
            finish();


        }
    }


}
