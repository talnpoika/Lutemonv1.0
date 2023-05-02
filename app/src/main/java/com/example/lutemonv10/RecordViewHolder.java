package com.example.lutemonv10;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;
    TextView name, wins, losses;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonImage = itemView.findViewById(R.id.ivLutemonRecord);
        name = itemView.findViewById(R.id.txtLutemonName);
        wins = itemView.findViewById(R.id.txtVictories);
        losses = itemView.findViewById(R.id.txtLosses);
    }
}
