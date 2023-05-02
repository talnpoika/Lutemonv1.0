package com.example.lutemonv10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context,ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {

        holder.name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.defence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.experience.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.life.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth()) + "/" + String.valueOf(lutemons.get(position).getMaxHealth()));
        holder.ivLutemon.setImageResource(lutemons.get(position).getMainImage());

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
