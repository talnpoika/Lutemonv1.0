package com.example.lutemonv10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecordListAdapter extends RecyclerView.Adapter<RecordViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public RecordListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecordViewHolder(LayoutInflater.from(context).inflate(R.layout.record_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {

        holder.name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.wins.setText("Voitot: " + String.valueOf(lutemons.get(position).getWins()));
        holder.losses.setText("Tappiot: " + String.valueOf(lutemons.get(position).getLosses()));
        holder.lutemonImage.setImageResource(lutemons.get(position).getMainImage());

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
