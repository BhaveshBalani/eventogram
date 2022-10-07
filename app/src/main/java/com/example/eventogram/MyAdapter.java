package com.example.eventogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.name.setText(user.getName());
        holder.mobile.setText(user.getMobile());
        holder.email.setText(user.getEmail());
        holder.stream.setText(user.getStream());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, mobile , email, stream;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name    = itemView.findViewById(R.id.uName);
            mobile  = itemView.findViewById(R.id.uPhone);
            email   = itemView.findViewById(R.id.uEmail);
            stream  = itemView.findViewById(R.id.uStream);
        }
    }
}
