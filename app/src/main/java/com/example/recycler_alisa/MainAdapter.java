package com.example.recycler_alisa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    public ArrayList<Rec> list = new ArrayList<>();
    public Context context;

    public MainAdapter(ArrayList<Rec> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Rec rec = list.get(position);
        holder.textView.setText(rec.getSlovo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.txtView);
        }
    }


}
