package com.example.lutemonv10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BattleTextAdapter extends RecyclerView.Adapter<BattleTextViewHolder> {

    private Context context;

    private ArrayList<String> texts = new ArrayList<>();

    public BattleTextAdapter(Context context, ArrayList<String> texts) {
        this.context = context;
        this.texts = texts;
    }

    @NonNull
    @Override
    public BattleTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BattleTextViewHolder(LayoutInflater.from(context).inflate(R.layout.battletext_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BattleTextViewHolder holder, int position) {
        holder.battleText.setText(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    public void addItem(String text) {
        texts.add(text);
        notifyItemInserted(texts.size());
    }
}
