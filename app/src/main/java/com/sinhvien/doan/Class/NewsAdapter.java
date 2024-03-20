package com.sinhvien.doan.Class;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.doan.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context mContextl;
    private ArrayList<News> newsArrayList;

    public NewsAdapter(Context mContextl, ArrayList<News>newsArrayList) {
        this.mContextl = mContextl;
        this.newsArrayList=newsArrayList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news=newsArrayList.get(position);
        if(news==null){
            return;
        }
        holder.imgNews.setImageResource(news.getResourceId());
        holder.tvName.setText(news.getName());

    }

    @Override
    public int getItemCount() {

        return newsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgNews;
        private TextView tvName;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNews=itemView.findViewById(R.id.imgletter);
            tvName=itemView.findViewById(R.id.tvTitle);
        }
    }
}