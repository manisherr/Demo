package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUsers extends AppCompatActivity {
    RecyclerView recyclerView;
    List<UserModel> userModelDatabaseInserts=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_users);
        recyclerView = (RecyclerView) findViewById(R.id.rc_user);

        Database database = new Database(this);
        database.openDatabse();
        userModelDatabaseInserts= database.getData();
        database.closeDatabase();
        DatabaseUserAdapter adapter = new DatabaseUserAdapter(DatabaseUsers.this,userModelDatabaseInserts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
}