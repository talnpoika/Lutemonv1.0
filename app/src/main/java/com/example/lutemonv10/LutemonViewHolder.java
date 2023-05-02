package com.example.lutemonv10;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView ivLutemon;
    TextView name, attack, defence, experience, life;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        ivLutemon = itemView.findViewById(R.id.ivLutemon);
        name = itemView.findViewById(R.id.txtName);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        experience = itemView.findViewById(R.id.txtExperience);
        life = itemView.findViewById(R.id.txtLife);

    }
}
