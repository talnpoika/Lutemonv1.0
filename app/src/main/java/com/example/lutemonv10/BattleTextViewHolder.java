package com.example.lutemonv10;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BattleTextViewHolder extends RecyclerView.ViewHolder {

    TextView battleText;

    public BattleTextViewHolder(@NonNull View itemView) {
        super(itemView);

        battleText = itemView.findViewById(R.id.txtBattle);

    }
}
