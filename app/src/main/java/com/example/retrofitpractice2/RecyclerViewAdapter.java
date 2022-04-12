package com.example.retrofitpractice2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> list;

    public RecyclerViewAdapter(Context context, ArrayList<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvtime.setText("Published At:- "+list.get(position).getPublishedAt());
        holder.tvcontent.setText(list.get(position).getDescription());
        holder.tvauthor.setText(list.get(position).getAuthor());
        holder.mheading.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getUrlToImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Webview.class);
                intent.putExtra("url",list.get(position).getUrl());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,tvauthor,tvcontent,tvtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading = itemView.findViewById(R.id.tvheading);
            tvauthor = itemView.findViewById(R.id.tvauthor);
            tvcontent = itemView.findViewById(R.id.tvcontent);
            tvtime = itemView.findViewById(R.id.tvtime);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}
