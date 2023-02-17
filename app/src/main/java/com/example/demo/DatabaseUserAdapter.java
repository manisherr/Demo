package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUserAdapter extends RecyclerView.Adapter<DatabaseUserAdapter.ViewHolder>{
    Context context;
    List<UserModel> userModelDatabaseInserts;

    public DatabaseUserAdapter(Context context, List<UserModel> userModelDatabaseInserts) {
        this.context = context;
        this.userModelDatabaseInserts = userModelDatabaseInserts;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myycustomolayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(userModelDatabaseInserts.get(position).getId());
        holder.name.setText(userModelDatabaseInserts.get(position).getName());
        holder.mobile.setText(userModelDatabaseInserts.get(position).getMobile());
        holder.email.setText(userModelDatabaseInserts.get(position).getEmail());
        holder.password.setText(userModelDatabaseInserts.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return userModelDatabaseInserts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,id,mobile,email,password;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.rc_name);
            id=itemView.findViewById(R.id.rc_id);
            mobile=itemView.findViewById(R.id.rc_mobile);
            email=itemView.findViewById(R.id.rc_email);
            password=itemView.findViewById(R.id.rc_password);

        }
    }
}
